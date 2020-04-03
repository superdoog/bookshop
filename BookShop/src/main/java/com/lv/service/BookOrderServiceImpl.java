package com.lv.service;

import com.lv.mapper.BookOrderMapper;
import com.lv.pojo.BookOrder;
import com.lv.pojo.OrderDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lv
 */
@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Resource
    private BookOrderMapper bookOrderMapper;

    @Override
    public List<BookOrder> findAllBookOrder(int currentPage, int pageSize) {
        List<BookOrder> bookOrders = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            bookOrders = bookOrderMapper.findAllBookOrder(currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookOrders;
    }

    @Override
    public List<BookOrder> findUserBookOrder(int uid, int currentPage, int pageSize) {
        List<BookOrder> bookOrders = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            bookOrders = bookOrderMapper.findUserBookOrder(uid, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookOrders;
    }

    @Override
    public int getCount() {
        return bookOrderMapper.getCount();
    }

    @Override
    public int getCountByuid(int uid) {
        return bookOrderMapper.getCountByuid(uid);
    }

    @Override
    public int updateBookOrder(BookOrder bookOrder) {
        int flag = 0;
        try {
            flag = bookOrderMapper.updateBookOrder(bookOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public BookOrder getBookOrderByoid(int oid) {
        BookOrder bookOrder = null;
        try {
            bookOrder = bookOrderMapper.getBookOrderByoid(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookOrder;
    }

    @Override
    public int insertBookOrder(BookOrder bookOrder) {
        int flag = 0;
        try {
            flag = bookOrderMapper.insertBookOrder(bookOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int getOid(String dateStr, int uid) {
        int oid = 0;
        try {
            oid = bookOrderMapper.getOid(dateStr, uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oid;
    }

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        int flag = 0;
        try {
            flag = bookOrderMapper.addOrderDetail(orderDetail) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
