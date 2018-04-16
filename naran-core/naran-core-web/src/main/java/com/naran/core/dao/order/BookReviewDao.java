package com.naran.core.dao.order;

import com.naran.core.entity.order.BookReview;
import com.naran.foundation.mybatis.page.Page;

/**
 * 数据访问接口
 * 
 * @author zefeng.xu
 */
public interface BookReviewDao {

    Long addBookReview(BookReview bookReview);

    void updateBookReview(BookReview bookReview);

    void deleteBookReview(Long id);

    BookReview findBookReviewById(Long id);

    Page<BookReview> findBookReviewByPage(Long orderId,int pageNum, int pageSize);

}
