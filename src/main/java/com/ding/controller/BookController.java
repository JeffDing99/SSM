package com.ding.controller;

import com.ding.pojo.Books;
import com.ding.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/08/20 16:37
 * @Version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    //controller 调 service 层
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询全部的书籍，并且返回到一个书籍展示页面
     * @param model
     * @return
     */
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addPaper(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model ,int id){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Model model,Books book){
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books",books);

        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model) {
        List<Books> list = bookService.queryBook(queryBookName);

        model.addAttribute("list",list);

        return "allBook";
    }

    //查询书籍
    @RequestMapping("/queryBookByName")
    public String queryBookByName(String queryBookName,Model model) {
        Books books = bookService.queryBookByName(queryBookName);

        List<Books> list = new ArrayList<Books>();

        list.add(books);

        if (books == null) {
            list = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "allBook";
    }
}
