package com.longdi.dao;

import com.longdi.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/27 20:32
 */
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookId")int id);

    //查询全部的书
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName")String bookName);

}
