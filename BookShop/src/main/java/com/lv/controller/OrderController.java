package com.lv.controller;

import com.lv.pojo.*;
import com.lv.service.BookOrderServiceImpl;
import com.lv.service.BookServiceImpl;
import com.lv.util.Constant;
import com.lv.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lv
 */
@Controller
public class OrderController {


    @Resource
    private BookOrderServiceImpl bookOrderService;
    @Resource
    private BookServiceImpl bookService;


    @RequestMapping("/OrderManage")
    public ModelAndView bookOrder(ModelAndView mv, @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        //获取总数
        int totalCount = bookOrderService.getCount();
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

        List<BookOrder> bookOrders = bookOrderService.findAllBookOrder(currentPageNo, Constant.ORDER_PAGE_SIZE);

        mv.addObject("bookOrders", bookOrders);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("/manage/order");
        return mv;
    }

    @RequestMapping("/BookOrderModifyPage")
    public ModelAndView toBookModifyPage(ModelAndView mv, @RequestParam("oid") String oid) {
        BookOrder bookOrder = bookOrderService.getBookOrderByoid(Integer.parseInt(oid));
        mv.addObject("bookOrder", bookOrder);
        mv.setViewName("manage/order-modify");
        return mv;
    }

    @RequestMapping("/updateBookOrder")
    public ModelAndView updateBook(ModelAndView mv,
                                   String oid,
                                   String oname,
                                   String address,
                                   String orderStatus) {
        int flag = 0;
        BookOrder bookOrder = new BookOrder();
        bookOrder.setOid(Integer.parseInt(oid));
        bookOrder.setOname(oname);
        bookOrder.setAdress(address);
        bookOrder.setStatus(orderStatus);
        flag = bookOrderService.updateBookOrder(bookOrder);
        if (flag == 0) {
            mv.addObject("error", "修改order失败");
            mv.setViewName("error");
            return mv;
        }
        mv.setViewName("redirect:/OrderManage");
        return mv;
    }

    @RequestMapping("/addOrder")
    public ModelAndView addBookOrder(ModelAndView mv,
                                     @RequestParam("uid") Integer uid,
                                     @RequestParam("oname") String oname,
                                     @RequestParam("oaddress") String oaddress,
                                     HttpSession session) {
        User user = (User) session.getAttribute(Constant.USER_SESSION);
        Cart cart = (Cart) session.getAttribute("cart");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        BookOrder bookOrder = new BookOrder();
        bookOrder.setDate(dateStr);
        bookOrder.setOname(oname);
        bookOrder.setAdress(oaddress);
        bookOrder.setStatus(Constant.UN_DO);
        bookOrder.setUid(uid);
        bookOrderService.insertBookOrder(bookOrder);
        int oid = bookOrderService.getOid(dateStr, uid);

        Map<Book, Integer> map = cart.getGoods();
        for (Map.Entry<Book, Integer> entry : map.entrySet()) {
            Book book = entry.getKey();
            Integer number = entry.getValue();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(oid);
            orderDetail.setBookId(book.getBid());
            orderDetail.setBookNum(number);
            bookOrderService.addOrderDetail(orderDetail);
            bookService.reduceStore(book.getBid(), number);
        }
//        Iterator<Map.Entry<Book, Integer>> iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<Book, Integer> entry = (Map.Entry<Book, Integer>) iter.next();
//            Book book = entry.getKey();
//            Integer number = entry.getValue();
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setOrderId(oid);
//            orderDetail.setBookId(book.getBid());
//            orderDetail.setBookNum(number);
//            bookOrderService.addOrderDetail(orderDetail);
//            bookService.reduceStore(book.getBid(), number);
//        }

        session.removeAttribute("cart");
        mv.setViewName("redirect:/shoppingResult");
        return mv;
    }


}
