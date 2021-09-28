package com.longdi.service;

import com.longdi.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/27 21:03
 */
public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById( int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
