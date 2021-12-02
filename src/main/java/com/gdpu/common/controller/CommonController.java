package com.gdpu.common.controller;

import com.gdpu.annotation.PassLogin;
import com.gdpu.entity.User;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommonController {

    @GetMapping("/login") //映射到"/login"请求
    @PassLogin
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    @PassLogin
    public String register() {
        return "register";
    }

    @GetMapping("/index")
    @PassLogin //测试用
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
//        User user = (User) request.getSession().getAttribute("userinfo");
//        if (user != null) {
//            if (user.getStatus() == User.ADMIN_STATUS) {
//                mv.setViewName("admin/index");
//            } else {
//                mv.setViewName("user/index");
//            }
//        } else {
//            mv.setViewName("login");
//        }
        mv.setViewName("admin/index");
        return mv;
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtil.out(request, response);
    }
}
