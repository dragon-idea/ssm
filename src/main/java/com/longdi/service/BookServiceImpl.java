package com.longdi.service;

import com.longdi.dao.BookMapper;
import com.longdi.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/27 21:05
 */

public class BookServiceImpl implements BookService{

    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        System.out.println("BookServiceImpl:updateBook=>"+books);
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
