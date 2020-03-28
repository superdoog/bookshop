package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @RequestMapping("backLoginPage")
    public String loginPage(){
        return "manage/login";
    }
    @RequestMapping("backLogin")
    public ModelAndView login(ModelAndView mv, HttpSession session, String username, String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if (username.equals(password) && username.equals("admin")) {
                session.setAttribute("admin","admin"	);
                mv.setViewName("manage/userManage");
                return mv;
            }
        }
        mv.setViewName("manage/login");
        return mv;
    }


}
