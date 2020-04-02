package com.lv.mapper;

import com.lv.pojo.BookOrder;
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

    int updateBookOrder(BookOrder bookOrder);

    BookOrder getBookOrderByoid(@Param("oid") int oid);
}
