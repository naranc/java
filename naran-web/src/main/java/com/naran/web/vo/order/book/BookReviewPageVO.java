package com.naran.web.vo.order.book;

import java.util.List;

import com.naran.foundation.util.BasePageVO;

/**
 * 展示封装（分页）
 * 
 * @author zefeng.xu
 */
public class BookReviewPageVO extends BasePageVO {

    private List<BookReviewVO> reviews;

    public List<BookReviewVO> getReviews() {
	return reviews;
    }

    public void setReviews(List<BookReviewVO> reviews) {
	this.reviews = reviews;
    }

}
