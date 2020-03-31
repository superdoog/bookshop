package com.lv.service;

import com.lv.pojo.Book;

import java.util.List;
import java.util.Set;

/**
 * @author lv
 */
public interface BookService {
    List<Book> findAllBook(int currentPage, int pageSize);

    int getCount();

    int deleteBybid(int bid);

    Book getBookBybid(int bid);

    int updateBook(Book book);

    Set<String> getBookType();

    int addBook(Book book);

}
