package com.ding.service;

import com.ding.pojo.Books;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/08/20 16:38
 * @Version 1.0
 */
@Transactional(readOnly = true)
public interface BookService {

    // 增加一本书
    @Transactional(readOnly = false)
    int addBook(Books books);

    //删除一本书
    @Transactional(readOnly = false)
    int deleteBookById(int id);

    //更改一本书
    @Transactional(readOnly = false)
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(String bookName);

    Books queryBookByName(String bookName);
}
