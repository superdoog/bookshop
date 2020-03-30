package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.User;
import com.lv.service.UserServiceImpl;
import com.lv.util.Constant;
import com.lv.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView manaUser(ModelAndView mv, @RequestParam(value = "pageIndex", required = false) String pageIndex) {

        //获取用户总数
        int totalCount = userService.getCount();
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constant.USER_PAGE_SIZE);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                mv.setViewName("redirect:../static/404.html");
                return mv;
            }
        }
        // 控制首页和尾页在范围内
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        List<User> users = userService.findAllUser(currentPageNo, Constant.USER_PAGE_SIZE);
        mv.addObject("users", users);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("manage/user");
        return mv;
    }

    @RequestMapping("/addUserPage")
    public String addUserPage() {
        return "manage/user-add";
    }
    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView mv, String userName,String passWord,String gender,String email,String phone,String address){
        User user = new User();
        user.setUname(userName);
        user.setPassword(passWord);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAdress(address);
        userService.addUser(user);
        mv.setViewName("redirect:/UserManage");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteBook(@RequestParam("userid") String uid){
        int flag;
        Map<String, String> resultMap = new HashMap<>();
        flag = userService.deleteByuid(Integer.parseInt(uid));
        if (com.mysql.cj.util.StringUtils.isNullOrEmpty(uid)) {
            //不存在
            resultMap.put("delResult", "notexist");
        } else {
            if (flag == 1) {
                //删除成功
                resultMap.put("delResult", "true");
            } else {
                //删除失败
                resultMap.put("delResult", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

}
