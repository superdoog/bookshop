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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        List<Book> books = bookService.findAllBook(currentPageNo, Constant.BOOK_PAGE_SIZE);
        mv.addObject("books", books);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.setViewName("manage/product");
        return mv;
    }

    @RequestMapping("/addBookPage")
    public ModelAndView addBookPage(ModelAndView mv) {
        Set<String> bts = bookService.getBookType();
        mv.addObject("bts", bts);
        mv.setViewName("manage/product-add");
        return mv;
    }
    @RequestMapping("/addBook")
    public ModelAndView addBook(ModelAndView mv, HttpSession session,
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
public String modifyBookPage(Model model, Integer bid) {
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
    @RequestMapping("/deleteBook")
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

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv, HttpServletRequest request) {
        Set<String> bts = bookService.getBookType();
        List<Book> books = bookService.findAllBook(1,10);
        List<Book> Cbooks = getCookies(request);
        mv.addObject("books", books);
        mv.addObject("Cbooks", Cbooks);
        mv.addObject("bts", bts);
        mv.setViewName("front/index");
        return mv;
    }

    @RequestMapping("/productList")
    public ModelAndView productList(ModelAndView mv,
                                    String type,
                                    String key,
                                    HttpServletRequest request,
                                    @RequestParam(value = "pageIndex", required = false) String pageIndex) {

        //获取总数
        int totalCount = bookService.getSelectCount(key, type);
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constant.PRODUCT_LIST_PAGE_SIZE);
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

        List<Book> Cbooks = getCookies(request);
        Set<String> bts = bookService.getBookType();
        List<Book> books = bookService.findBook(key, type, currentPageNo, Constant.PRODUCT_LIST_PAGE_SIZE);

        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);
        mv.addObject("books", books);
        mv.addObject("bts", bts);
        mv.addObject("Cbooks", Cbooks);
        mv.setViewName("front/product-list");
        return mv;
    }

    @RequestMapping("/productView")
    public ModelAndView bookView(ModelAndView mv,
                                 Integer bid,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        setCookies(bid, request, response);
        List<Book> Cbooks = getCookies(request);
        Book book = bookService.getBookBybid(bid);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(book.getDate());
        Set<String> bts = bookService.getBookType();
        mv.addObject("bts", bts);
        mv.addObject("book", book);
        mv.addObject("Cbooks", Cbooks);
        mv.addObject("dateStr", dateStr);
        mv.setViewName("front/product-view");
        return mv;
    }


    List<Book> getCookies(HttpServletRequest request) {
        List<Book> Cbooks = new ArrayList<Book>();
        String list = "";
        //从客户端获得Cookies集合
        Cookie[] cookies = request.getCookies();
        //遍历这个Cookies集合
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("ListViewCookie")) {
                    list = c.getValue();
                }
            }
        }
        if (list != "") {
            String[] arr = list.split("#");
            for (String s : arr) {
                Book book = bookService.getBookBybid(Integer.parseInt(s));
                Cbooks.add(book);
            }
        }
        return Cbooks;
    }

    void setCookies(Integer bid, HttpServletRequest request, HttpServletResponse response) {
        boolean flag = true;
        String list = "";
        //从客户端获得Cookies集合
        Cookie[] cookies = request.getCookies();
        //遍历这个Cookies集合
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("ListViewCookie")) {
                    list = c.getValue();
                }
            }
        }
        //如果浏览记录超过10条，清零.
        String[] arr = list.split("#");
        if (list != "") {
            for (String s : arr) {
                if (Integer.parseInt(s) == bid) {
                    flag = false;
                }
            }
        }
        if (flag) {
            list += bid + "#";
        }
        if (arr != null && arr.length > 0) {
            if (arr.length >= 10) {
                list = "";
            }
        }
        Cookie cookie = new Cookie("ListViewCookie", list);
        response.addCookie(cookie);
    }
}
