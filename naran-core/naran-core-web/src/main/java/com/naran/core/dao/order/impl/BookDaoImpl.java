package com.naran.core.dao.order.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naran.core.dao.order.BookDao;
import com.naran.core.entity.order.Book;
import com.naran.foundation.mybatis.dao.MyBatisDAO;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.mybatis.page.PageRequest;

/**
 * 
 * @author zefeng.xu
 */
@Repository
public class BookDaoImpl implements BookDao {

    private static final String ADD_BOOK = "addBook";
    private static final String UPDATE_BOOK = "updateBook";
    private static final String FIND_BOOK_BY_ID = "findBookById";
    private static final String FIND_BOOK_BY_ISBN = "findBookByIsbn";
    private static final String FIND_BOOK_BY_PAGE = "findBookByPage";

    @Autowired
    private MyBatisDAO myBatisDAO;

    @Override
    public Long addBook(Book book) {
	book.setCreateTime(new Date());
	book.setUpdateTime(new Date());
	book.setExpired(Boolean.TRUE);
	myBatisDAO.insert(ADD_BOOK, book);
	return book.getId();
    }

    @Override
    public void updateBook(Book book) {
	book.setUpdateTime(new Date());
	myBatisDAO.update(UPDATE_BOOK, book);
    }

    @Override
    public void deleteBook(Long id) {
	Book book = new Book();
	book.setId(id);
	book.setExpired(Boolean.FALSE);
	myBatisDAO.update(UPDATE_BOOK, book);
    }

    @Override
    public Book findBookById(Long id) {
	if (id == null) {
	    return null;
	}
	return (Book) myBatisDAO.findForObject(FIND_BOOK_BY_ID, id);
    }
    
    @Override
    public Book findBookByIsbn(String isbn) {
	if (isbn == null) {
	    return null;
	}
	return (Book) myBatisDAO.findForObject(FIND_BOOK_BY_ISBN, isbn);
    }
    
    

    @SuppressWarnings("unchecked")
    @Override
    public Page<Book> findBookByPage(int pageNum, int pageSize) {
	Map<String, Object> param = new HashMap<String, Object>();
	// param.put("bookType", bookType);
	return myBatisDAO.findForPage(FIND_BOOK_BY_PAGE, new PageRequest(pageNum, pageSize, param));
    }

}
