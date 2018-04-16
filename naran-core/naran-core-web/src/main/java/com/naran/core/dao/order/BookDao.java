package com.naran.core.dao.order;

import com.naran.core.entity.order.Book;
import com.naran.foundation.mybatis.page.Page;

/**
 * 数据访问接口
 * 
 * @author zefeng.xu
 */
public interface BookDao {

    Long addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Book findBookById(Long id);

    Page<Book> findBookByPage(int pageNum, int pageSize);

    Book findBookByIsbn(String isbn);

}
