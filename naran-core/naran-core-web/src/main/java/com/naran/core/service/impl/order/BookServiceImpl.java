package com.naran.core.service.impl.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naran.core.dao.order.BookDao;
import com.naran.core.entity.order.Book;
import com.naran.dubbo.service.order.IBookService;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务
 * 
 * @author zefeng.xu
 */
@Transactional
@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Long addBook(Book book) {
	if (book == null) {
	    return null;
	}
	return bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
	if (book == null || book.getId() == null) {
	    return;
	}
	bookDao.updateBook(book);

    }

    @Override
    public void deleteBook(Long id) {
	if (id == null) {
	    return;
	}
	bookDao.deleteBook(id);

    }

    @Override
    public Book findBookById(Long id) {
	if (id == null) {
	    return null;
	}
	return bookDao.findBookById(id);
    }

    @Override
    public Page<Book> findBookByPage(int pageNum, int pageSize) {

	return bookDao.findBookByPage(pageNum, pageSize);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
	if (isbn == null) {
	    return null;
	}
	return bookDao.findBookByIsbn(isbn);
    }

}
