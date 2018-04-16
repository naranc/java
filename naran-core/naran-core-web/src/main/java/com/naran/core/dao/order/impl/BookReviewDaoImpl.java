package com.naran.core.dao.order.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naran.core.dao.order.BookReviewDao;
import com.naran.core.entity.order.BookReview;
import com.naran.foundation.mybatis.dao.MyBatisDAO;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.mybatis.page.PageRequest;

/**
 * 
 * @author zefeng.xu
 */
@Repository
public class BookReviewDaoImpl implements BookReviewDao {

    private static final String ADD_BOOK_REVIEW = "addBookReview";
    private static final String UPDATE_BOOK_REVIEW = "updateBookReview";
    private static final String FIND_BOOK_REVIEW_BY_ID = "findBookReviewById";
    private static final String FIND_BOOK_REVIEW_BY_PAGE = "findBookReviewByPage";

    @Autowired
    private MyBatisDAO myBatisDAO;

    @Override
    public Long addBookReview(BookReview bookReview) {
	bookReview.setCreateTime(new Date());
	bookReview.setUpdateTime(new Date());
	bookReview.setExpired(Boolean.TRUE);
	myBatisDAO.insert(ADD_BOOK_REVIEW, bookReview);
	return bookReview.getId();
    }

    @Override
    public void updateBookReview(BookReview bookReview) {
	bookReview.setUpdateTime(new Date());
	myBatisDAO.update(UPDATE_BOOK_REVIEW, bookReview);
    }

    @Override
    public void deleteBookReview(Long id) {
	BookReview bookReview = new BookReview();
	bookReview.setId(id);
	bookReview.setExpired(Boolean.FALSE);
	myBatisDAO.update(UPDATE_BOOK_REVIEW, bookReview);
    }

    @Override
    public BookReview findBookReviewById(Long id) {
	if (id == null) {
	    return null;
	}
	return (BookReview) myBatisDAO.findForObject(FIND_BOOK_REVIEW_BY_ID, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Page<BookReview> findBookReviewByPage(Long orderId,int pageNum, int pageSize) {
	Map<String, Object> param = new HashMap<String, Object>();
	param.put("orderId", orderId);
	return myBatisDAO.findForPage(FIND_BOOK_REVIEW_BY_PAGE, new PageRequest(pageNum, pageSize, param));
    }

}
