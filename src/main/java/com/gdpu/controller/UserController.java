package com.gdpu.controller;

import com.gdpu.annotation.PassLogin;
import com.gdpu.common.vo.Result;
import com.gdpu.common.vo.UserQuery;
import com.gdpu.entity.User;
import com.gdpu.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @PassLogin
    public Object login(User param, @RequestParam("captcha") String captcha, HttpServletRequest request, HttpServletResponse response) {
        //验证码
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);
            return Result.fail("验证码错误！");
        }
        HttpSession session = request.getSession();
        User user = userService.login(param);
        if (user != null) {
            //登录成功，用户信息放入session
//            String token = userService.getToken(user.getId(),user.getUsername(),user.getStatus());
//            response.setHeader("Authorization", token);
            session.setAttribute("userinfo", user);
            return Result.succeed();
        } else {
            //登录失败
            return Result.fail("用户名或密码错误！");
        }
    }


    @GetMapping("/list")
    @ResponseBody
//    @AdminLogin
    public Result list(UserQuery param) {
        List<User> userList = userService.getUserList(param);
        return Result.succeed(userList, userService.getUserListNum(param));
    }

    @DeleteMapping("/delete/{ids}")
    @ResponseBody
//    @AdminLogin
    public Result delete(@PathVariable("ids") String ids) {
        String[] splitIds = ids.split(",");
        Integer[] intIds = new Integer[splitIds.length];
        for (int i = 0; i < splitIds.length; i++) {
            intIds[i] = Integer.parseInt(splitIds[i]);
        }
        if (userService.deleteUserByIds(intIds) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("/edit/{id}")
//    @AdminLogin
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        User user = userService.getUserById(id);
        user.setPassword(null);
        mv.addObject("user", user);
        mv.setViewName("admin/users/useredit");
        return mv;
    }

    @GetMapping("/add")
//    @AdminLogin
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/users/useradd");
        return mv;
    }

    @PostMapping("/adduser")
//    @AdminLogin
    public Result add(User param) {
        int result = userService.register(param);
        if (result == -1) {
            return Result.fail("用户名已存在");
        } else {
            return Result.succeed();
        }
    }

    @PostMapping("/register")
    @PassLogin
    public Result register(User param) {
        int result = userService.register(param);
        if (result == -1) {
            return Result.fail("用户名已存在");
        } else {
            return Result.succeed();
        }
    }

    @PostMapping("/update")
    @ResponseBody
//    @AdminLogin
    public Result update(User param) {
        if (userService.updateUser(param) == 1) {
            return Result.succeed();
        } else {
            return Result.fail();
        }
    }
}
