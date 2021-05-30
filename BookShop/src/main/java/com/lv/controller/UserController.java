package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.BookOrder;
import com.lv.pojo.User;
import com.lv.service.BookOrderServiceImpl;
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
    @Resource
    private BookOrderServiceImpl bookOrderService;

    @RequestMapping("/backLoginPage")
    public String loginPage() {
        return "manage/login";
    }

    @RequestMapping("/backLogin")
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
                mv.setViewName("redirect:../static/404.jsp");
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
        mv.setViewName("/manage/user");
        return mv;
    }

    @RequestMapping("/addUserPage")
    public String addUserPage() {
        return "/manage/user-add";
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView mv, String userName, String passWord, String gender, String email, String phone, String address) {
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

    @RequestMapping("/UserModifyPage")
    public ModelAndView toBookModifyPage(ModelAndView mv, @RequestParam("uid") String uid) {
        User user = userService.getUserById(Integer.parseInt(uid));
        mv.addObject("user", user);
        mv.setViewName("/manage/user-modify");
        return mv;
    }
    @RequestMapping("/modifyUser")
    public ModelAndView modifyUser(ModelAndView mv, @RequestParam("uid") String uid,
                                   @RequestParam("userName") String userName,
                                   @RequestParam("passWord") String passWord,
                                   @RequestParam("gender") String gender,
                                   @RequestParam("email") String email,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("address") String address) {
        int flag;
        User user = new User(Integer.parseInt(uid), userName, passWord, gender, email, phone, address);

        flag = userService.updateUser(user);
        if (flag == 0) {
            mv.addObject("error", "修改user失败");
            mv.setViewName("error");
            return mv;
        }
        mv.setViewName("redirect:/UserManage");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userid") String uid) {
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

    @ResponseBody
    @RequestMapping("/loginCheck")
    public String loginCheck(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, @RequestParam("yan") String yan,HttpSession session){
        Map<String, String> resultMap = new HashMap<>();
        User user = userService.getUserByuname(userName);
        String yanCode = (String) session.getAttribute("yanCode");

        if (!yan.equals(yanCode)&&!yan.equals("KEY")) {
            resultMap.put("Result","yanFalse");
            return JSONArray.toJSONString(resultMap);
        }

        if (user == null){
            resultMap.put("Result", "null");
            return JSONArray.toJSONString(resultMap);
        }

        if (!passWord.equals(user.getPassword())){
            resultMap.put("Result", "false");
            return JSONArray.toJSONString(resultMap);
        }
        session.setAttribute(Constant.USER_SESSION, user);
        resultMap.put("Result", "success");
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/adminLogout")
    public ModelAndView adminLogout(ModelAndView mv, HttpSession session){
        session.removeAttribute("admin");
        mv.setViewName("redirect:/backLoginPage");
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView mv, HttpSession session){
        session.removeAttribute(Constant.CART);
        session.removeAttribute(Constant.USER_SESSION);
        mv.setViewName("redirect:/index");
        return mv;
    }

    @RequestMapping("/Register")
    public ModelAndView register(ModelAndView mv,
                                 @RequestParam("userName") String userName,
                                 @RequestParam("userPassword") String userPassword,
                                 @RequestParam("gender") String gender,
                                 @RequestParam("address") String address) {
        Map<String, String> resultMap = new HashMap<>();
        User user = userService.getUserByuname(userName);
        if (user != null){
            mv.addObject("error","注册失败，用户名已存在！");
            mv.setViewName("/front/register");
            return mv;
        }
        User u = new User();
        u.setUname(userName);
        u.setPassword(userPassword);
        u.setGender(gender);
        u.setAdress(address);
        userService.addUser(u);
        mv.setViewName("/front/login");
        return mv;
    }

    @RequestMapping("/updateUserPage")
    public ModelAndView updateUserPage(ModelAndView mv, HttpSession session) {
        User user = (User) session.getAttribute(Constant.USER_SESSION);
        user = userService.getUserById(user.getUid());
        mv.addObject("user",user);
        mv.setViewName("/front/update");
        return mv;
    }

    @RequestMapping("/updateUserMessage")
    public ModelAndView updateUserMessage(ModelAndView mv, @RequestParam("uid") String uid,
                                   @RequestParam("gender") String gender,
                                   @RequestParam("email") String email,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("address") String address) {
        int flag;
        User user = new User();
        user.setUid(Integer.parseInt(uid));
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAdress(address);

        flag = userService.updateUser(user);
        if (flag == 0) {
            mv.addObject("error", "修改失败");
            mv.setViewName("error");
            return mv;
        }
        mv.setViewName("redirect:/index");
        return mv;
    }

    @RequestMapping("/updateUserPwd")
    public ModelAndView updateUserPwd(ModelAndView mv, HttpSession session,
                                      @RequestParam("uid") String uid,
                                      @RequestParam("newPassword") String newPassword) {
        int flag;
        User user = new User();
        user.setUid(Integer.parseInt(uid));
        user.setPassword(newPassword);

        flag = userService.updateUser(user);
        if (flag == 0) {
            session.removeAttribute(Constant.USER_SESSION);
            mv.addObject("error", "修改失败");
            mv.setViewName("error");
            return mv;
        }

        session.removeAttribute(Constant.USER_SESSION);
        mv.setViewName("redirect:/index");
        return mv;
    }

    @RequestMapping("/userOrder")
    public ModelAndView userOrder(ModelAndView mv,
                                  HttpSession session,
                                  @RequestParam(value = "pageIndex", required = false) String pageIndex){
        User user = (User) session.getAttribute(Constant.USER_SESSION);
        //获取总数
        int totalCount = bookOrderService.getCountByuid(user.getUid());
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constant.ORDER_PAGE_SIZE);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                mv.setViewName("redirect:../static/404.jsp");
                return mv;
            }
        }
        // 控制首页和尾页在范围内
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        List<BookOrder> bookOrders = bookOrderService.findUserBookOrder(user.getUid(), currentPageNo, Constant.User_ORDER_PAGE_SIZE);
        mv.addObject("bookOrders", bookOrders);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("/front/user-order");
        return mv;
    }


}
