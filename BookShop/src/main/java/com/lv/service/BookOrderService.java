package com.lv.service;

import com.lv.pojo.BookOrder;

import java.util.List;

/**
 * @author lv
 */
public interface BookOrderService {

    List<BookOrder> findAllBookOrder(int currentPage,int pageSize);

    int getCount();

    int updateBookOrder(BookOrder bookOrder);

    BookOrder getBookOrderByoid(int oid);

}
