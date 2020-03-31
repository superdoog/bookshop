package com.lv.mapper;

import com.lv.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author lv
 */
@Mapper
public interface BookMapper {
    List<Book> findAllBook(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int getCount();

    int deleteBybid(@Param("bid") int bid);

    Book getBookBybid(@Param("bid") int bid);

    int updateBook(Book book);

    Set<String> getBookType();

    int addBook(Book book);

}
