package com.naran.dubbo.service.order;

import com.naran.core.entity.order.BookReview;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务接口
 * 
 * @author zefeng.xu
 */
public interface IBookReviewService {

    Long addBookReview(BookReview bookReview);

    void updateBookReview(BookReview bookReview);

    void deleteBookReview(Long id);

    BookReview findBookReviewById(Long id);

    /**
     * 获取（分页）
     * 
     * @return
     */
    Page<BookReview> findBookReviewByPage(Long orderId,int pageNum, int pageSize);


}
