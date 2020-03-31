package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.Book;
import com.lv.service.BookServiceImpl;
import com.lv.util.Constant;
import com.lv.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lv
 */
@Controller
public class BookController {

    @Resource
    private BookServiceImpl bookService;

    @RequestMapping("/BookManage")
    public ModelAndView manaBook(ModelAndView mv, @RequestParam(value = "pageIndex", required = false) String pageIndex){

        //获取总数
        int totalCount = bookService.getCount();
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constant.BOOK_PAGE_SIZE);
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

        List<Book> books = bookService.findAllBook(currentPageNo, Constant.BOOK_PAGE_SIZE);
        mv.addObject("books", books);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("manage/product");
        return mv;
    }

    @RequestMapping("/addBookPage")
    public ModelAndView addUserPage(ModelAndView mv) {
        Set<String> bts = bookService.getBookType();
        mv.addObject("bts", bts);
        mv.setViewName("manage/product-add");
        return mv;
    }
    @RequestMapping("/addBook")
    public ModelAndView addUser(ModelAndView mv, HttpSession session,
                                String bname,
                                String detail,
                                String price,
                                String type,
                                String writer,
                                String printer,
                                String dateString,
                                Integer store,
                                MultipartFile image) throws IOException {
        int flag = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book();
        book.setBname(bname);
        book.setDetail(detail);
        book.setPrice(price);
        book.setType(type);
        book.setWriter(writer);
        book.setPrinter(printer);
        book.setDate(date);
        book.setStore(store);
        String fileName = image.getOriginalFilename();
        book.setImage(fileName);

        String path=session.getServletContext().getRealPath("/static/image/product");
        if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
            File file = new File(path, fileName);
            image.transferTo(file);
        }

        flag = bookService.addBook(book);
        if (flag == 0) {
            mv.addObject("error", "修改book失败");
            mv.setViewName("error");
            return mv;
        }
        mv.setViewName("redirect:/BookManage");
        return mv;
    }
    
//    @RequestMapping("/upload")
//    public void upload(MultipartFile img, HttpSession session) throws IOException {
//        String path=session.getServletContext().getRealPath("/static/image/product");
//        System.out.println(path);
//        String fileName = img.getOriginalFilename();
//        System.out.println(fileName);
//        if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
//            File file = new File(path, fileName);
//            img.transferTo(file);
//        }
//        System.out.println("=====================dd==========================");
//    }

@RequestMapping("/modifyBookPage")
public String modifyUserPage(Model model, Integer bid) {
    Book book = bookService.getBookBybid(bid);
    Set<String> bts = bookService.getBookType();
    model.addAttribute("bts", bts);
    model.addAttribute("book", book);
    return "manage/product-modify";
}
    @RequestMapping("/modifyBook")
    public ModelAndView modifyBook(ModelAndView mv, HttpSession session,
                                   String bid,
                                   String bname,
                                   String detail,
                                   String price,
                                   String type,
                                   String writer,
                                   String printer,
                                   String dateString,
                                   Integer store,
                                   MultipartFile image) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book();
        book.setBid(Integer.parseInt(bid));
        book.setBname(bname);
        book.setDetail(detail);
        book.setPrice(price);
        book.setType(type);
        book.setWriter(writer);
        book.setPrinter(printer);
        book.setDate(date);
        book.setStore(store);

        System.out.println(book);

        if (image == null) {
            book.setImage(null);
        }else {
            String fileName = image.getOriginalFilename();
            book.setImage(fileName);
            String path=session.getServletContext().getRealPath("/static/image/product");
            if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
                File file = new File(path, fileName);
                image.transferTo(file);
            }
        }
        bookService.updateBook(book);
        return new ModelAndView("redirect:/BookManage");
    }

    @ResponseBody
    @RequestMapping("deleteBook")
    public String deleteBook(@RequestParam("bid") String bid){
        int flag;
        Map<String, String> resultMap = new HashMap<>();
        flag = bookService.deleteBybid(Integer.parseInt(bid));
        if (com.mysql.cj.util.StringUtils.isNullOrEmpty(bid)) {
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
