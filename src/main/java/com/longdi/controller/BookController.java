package com.longdi.controller;

import com.longdi.pojo.Books;
import com.longdi.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/27 22:47
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    //跳转到修改页面
    @RequestMapping("toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        int i=bookService.updateBook(books);
        if(i>0){
            System.out.println("添加books成功"+books);
        }

        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
         Books books=bookService.queryBookByName(queryBookName);
        System.err.println("queryBook=>"+books);
         List<Books> list=new ArrayList<Books>();
         list.add(books);

         if(books==null){
             list=bookService.queryAllBook();
             model.addAttribute("error","未查到");
         }

         model.addAttribute("list",list);
         return "allBook";
    }

}