package com.lv.mapper;

import com.lv.pojo.BookOrder;
import com.lv.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lv
 */
@Mapper
public interface BookOrderMapper {

    List<BookOrder> findAllBookOrder(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    List<BookOrder> findUserBookOrder(@Param("uid") int uid, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int getCount();

    int getCountByuid(@Param("uid") int uid);

    int updateBookOrder(BookOrder bookOrder);

    BookOrder getBookOrderByoid(@Param("oid") int oid);

    int insertBookOrder(BookOrder bookOrder);

    int getOid(@Param("dateStr") String dateStr, @Param("uid") int uid);

    int addOrderDetail(OrderDetail orderDetail);
}
