package com.ding.dao;

import com.ding.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/08/20 16:38
 * @Version 1.0
 */
public interface BookDao {
    // 增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(@Param("bookName")String bookName);

    Books queryBookByName(@Param("bookName")String bookName);
}

