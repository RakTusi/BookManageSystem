package com.gdpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/welcome")
//    @AdminLogin
    public ModelAndView welcome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/welcome");
        return mv;
    }

    @GetMapping("/table/users")
//    @AdminLogin
    public ModelAndView usersTable(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/users/userstable");
        return mv;
    }

    @GetMapping("/table/admin")
//    @AdminLogin
    public ModelAndView adminTable(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admintable");
        return mv;
    }

    @GetMapping("/table/book")
//    @AdminLogin
    public ModelAndView bookTable(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/book/booktable");
        return mv;
    }

    @GetMapping("/table/bookinfo")
//    @AdminLogin
    public ModelAndView bookInfoTable(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/bookinfo/bookinfotable");
        return mv;
    }

    @GetMapping("/table/borrowinfo")
//    @AdminLogin
    public ModelAndView borrowinfoTable(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/borrowinfo/borrowinfotable");
        return mv;
    }

}
