package com.ding.service.impl;

import com.ding.dao.BookDao;
import com.ding.pojo.Books;
import com.ding.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/08/20 18:22
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {



    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public int addBook(Books books) {
        return bookDao.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookDao.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookDao.queryAllBooks();
    }

    @Override
    public List<Books> queryBook(String bookName) {
        return bookDao.queryBook(bookName);
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookDao.queryBookByName(bookName);
    }
}
