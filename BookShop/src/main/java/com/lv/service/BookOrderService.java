package com.lv.service;

import com.lv.pojo.BookOrder;
import com.lv.pojo.OrderDetail;

import java.util.List;

/**
 * @author lv
 */
public interface BookOrderService {

    List<BookOrder> findAllBookOrder(int currentPage,int pageSize);

    List<BookOrder> findUserBookOrder(int uid, int currentPage,int pageSize);

    int getCount();

    int getCountByuid(int uid);

    int updateBookOrder(BookOrder bookOrder);

    BookOrder getBookOrderByoid(int oid);

    int insertBookOrder(BookOrder bookOrder);

    int getOid(String dateStr, int uid);

    int addOrderDetail(OrderDetail orderDetail);
}
