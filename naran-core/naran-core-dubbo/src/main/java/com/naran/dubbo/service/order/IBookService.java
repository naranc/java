package com.naran.dubbo.service.order;

import com.naran.core.entity.order.Book;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务接口
 * 
 * @author zefeng.xu
 */
public interface IBookService {

    Long addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Book findBookById(Long id);

    /**
     * 获取（分页）
     * 
     * @param bookType
     * @return
     */
    Page<Book> findBookByPage(int pageNum, int pageSize);

    Book findBookByIsbn(String isbn);

}
