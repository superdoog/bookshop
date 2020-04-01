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

    List<Book> findBook(@Param("key") String key, @Param("type") String type, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    int getCount();

    int getSelectCount(@Param("key") String key, @Param("type") String type);

    int deleteBybid(@Param("bid") int bid);

    Book getBookBybid(@Param("bid") int bid);

    int updateBook(Book book);

    Set<String> getBookType();

    int addBook(Book book);


}
