package com.lv.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.pojo.User;
import com.lv.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lv
 */
@Controller
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping("backLoginPage")
    public String loginPage() {
        return "manage/login";
    }

    @RequestMapping("backLogin")
    public ModelAndView login(ModelAndView mv, HttpSession session, String username, String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            if (username.equals(password) && username.equals("admin")) {
                session.setAttribute("admin", "admin");
                mv.setViewName("redirect:/UserManage");
                return mv;
            }
        }
        mv.setViewName("manage/login");
        return mv;
    }

    @RequestMapping("/UserManage")
    public ModelAndView manaUser(ModelAndView mv, Integer pageNum) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum, com.lv.util.Constant.MU_PAGE_SIZE);
        } else {
            PageHelper.startPage(1, com.lv.util.Constant.MU_PAGE_SIZE);
        }
        List<User> users = userService.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("users", users);
        mv.setViewName("manage/user");
        return mv;
    }

}
