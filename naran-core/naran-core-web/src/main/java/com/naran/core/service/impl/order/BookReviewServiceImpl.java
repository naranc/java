package com.naran.core.service.impl.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naran.core.dao.order.BookReviewDao;
import com.naran.core.entity.order.BookReview;
import com.naran.dubbo.service.order.IBookReviewService;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务
 * 
 * @author zefeng.xu
 */
@Transactional
@Service("bookReviewService")
public class BookReviewServiceImpl implements IBookReviewService {

    @Autowired
    private BookReviewDao bookReviewDao;

    @Override
    public Long addBookReview(BookReview bookReview) {
	if (bookReview == null) {
	    return null;
	}
	return bookReviewDao.addBookReview(bookReview);
    }

    @Override
    public void updateBookReview(BookReview bookReview) {
	if (bookReview == null || bookReview.getId() == null) {
	    return;
	}
	bookReviewDao.updateBookReview(bookReview);

    }

    @Override
    public void deleteBookReview(Long id) {
	if (id == null) {
	    return;
	}
	bookReviewDao.deleteBookReview(id);

    }

    @Override
    public BookReview findBookReviewById(Long id) {
	if (id == null) {
	    return null;
	}
	return bookReviewDao.findBookReviewById(id);
    }

    @Override
    public Page<BookReview> findBookReviewByPage(Long orderId,int pageNum, int pageSize) {

	return bookReviewDao.findBookReviewByPage(orderId,pageNum, pageSize);
    }

}
