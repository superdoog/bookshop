package com.lv.controller;

import com.lv.service.BookServiceImpl;
import com.lv.util.Constant;
import com.lv.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author lv
 */
@Controller
public class OrderController {

    @Resource
    private BookServiceImpl bookService;


    @RequestMapping("/OrderManage")
    public ModelAndView bookOrder(ModelAndView mv, @RequestParam(value = "pageIndex", required = false) String pageIndex) {

        //获取总数
        int totalCount = bookService.getCount();
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



        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("/manage/order");
        return mv;
    }
}
