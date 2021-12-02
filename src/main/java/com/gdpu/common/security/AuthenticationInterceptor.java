package com.gdpu.common.security;

import com.gdpu.annotation.AdminLogin;
import com.gdpu.annotation.PassLogin;
import com.gdpu.entity.User;
import com.gdpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 权限校验拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    UserService userService;

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 判断是否为对后端方法的请求，如果不是则无需验证直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //2. 获取被请求的方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //3. 读取方法注解，检查是否有@PassLogin注解标明是否需要跳过验证
        if (method.isAnnotationPresent(PassLogin.class)) {
            //存在该注解，判断是否需要pass login
            if (method.getAnnotation(PassLogin.class).required()) {
                return true;
            }
        }
        //4. 从session获取用户信息判断是否登录
        HttpSession session = request.getSession();
        User userinfo = (User) session.getAttribute("userinfo");
        if (userinfo == null) {
            response.sendError(401,"请先登录");
            return false;
        }
        //5. 检查@AdminLoginToken注解标明是否需要管理员权限
        if (method.isAnnotationPresent(AdminLogin.class)) {
            if (method.getAnnotation(AdminLogin.class).required()) {
                if (!userService.isAdmin(userinfo)) {
                    response.sendError(401, "权限不足");
                    return false;
                }
            }
        }
        //6. 验证通过
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
