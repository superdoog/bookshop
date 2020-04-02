package com.lv.controller;


import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.Book;
import com.lv.pojo.Cart;
import com.lv.service.BookServiceImpl;
import com.lv.service.CartService;
import com.lv.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lv
 */
@Controller
public class CartController {

    @Resource
    private BookServiceImpl bookService;
    @Resource
    private CartService cartService;

    @RequestMapping("/addGoodsInCart")
    public ModelAndView addGoodsInCart(Integer bid, Integer number, HttpSession session) {
        Book book = bookService.getBookBybid(bid);
        Cart cart = null;
        if (session.getAttribute(Constant.CART) != null) {
            cart = (Cart) session.getAttribute(Constant.CART);
        } else {
            cart = new Cart();
        }
        cart = cartService.addGoodsInCart(book, number, cart);
        session.setAttribute(Constant.CART, cart);
        return new ModelAndView("redirect:/cartPage");
    }

    @RequestMapping("/removeGoodsFromCart")
    public ModelAndView removeGoodsFromCart(Integer bid, HttpSession session) {
        Book book = bookService.getBookBybid(bid);
        Cart cart = (Cart) session.getAttribute(Constant.CART);
        cart = cartService.removeGoodsFromCart(book, cart);
        session.setAttribute("cart", cart);
        return new ModelAndView("redirect:/cartPage");
    }

    @RequestMapping("/cleanCart")
    public ModelAndView cleanCart(HttpSession session) {
        Cart cart = null;
        session.setAttribute("cart", cart);
        return new ModelAndView("redirect:/cartPage");
    }

    @ResponseBody
    @RequestMapping("/checkStore")
    public String checkStore(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, String> result = new HashMap<>();
        Map<Book, Integer> map = cart.getGoods();
        Iterator<Map.Entry<Book, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Book, Integer> entry = iter.next();
            Book book = entry.getKey();
            Integer number = entry.getValue();
            if (!bookService.checkStore(book.getBid(), number)) {
                result.put("False", "《" + book.getBname() + "》库存不足,库存剩余:" + book.getStore());
                return JSONArray.toJSONString(result);
            }
        }
        result.put("Success","success");
        return JSONArray.toJSONString(result);
    }


}
