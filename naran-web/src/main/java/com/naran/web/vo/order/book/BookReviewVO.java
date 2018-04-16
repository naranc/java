package com.naran.web.vo.order.book;

import org.springframework.beans.BeanUtils;

import com.naran.core.entity.order.BookReview;
import com.naran.foundation.util.BaseVO;
import com.naran.foundation.util.file.qiniu.QiniuImageUtil;

public class BookReviewVO implements BaseVO {

    private Long reviewId;

    private String title;

    private String content;

    private Long authorId;

    private String author;

    private String authorImg;

    private Integer commentTimes;

    private Integer likeTimes;

    private Long bookId;

    private Long orderId;

    public Long getReviewId() {
	return reviewId;
    }

    public void setReviewId(Long reviewId) {
	this.reviewId = reviewId;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public Long getAuthorId() {
	return authorId;
    }

    public void setAuthorId(Long authorId) {
	this.authorId = authorId;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getAuthorImg() {
	return authorImg;
    }

    public void setAuthorImg(String authorImg) {
	this.authorImg = authorImg;
    }

    public Integer getCommentTimes() {
	return commentTimes;
    }

    public void setCommentTimes(Integer commentTimes) {
	this.commentTimes = commentTimes;
    }

    public Integer getLikeTimes() {
	return likeTimes;
    }

    public void setLikeTimes(Integer likeTimes) {
	this.likeTimes = likeTimes;
    }

    public Long getBookId() {
	return bookId;
    }

    public void setBookId(Long bookId) {
	this.bookId = bookId;
    }

    public Long getOrderId() {
	return orderId;
    }

    public void setOrderId(Long orderId) {
	this.orderId = orderId;
    }

    @Override
    public void convertPOToVO(Object poObj) {

	if (null == poObj) {
	    return;
	}
	BookReview po = (BookReview) poObj;
	BeanUtils.copyProperties(po, this);
	this.reviewId = po.getId();
	this.authorImg = QiniuImageUtil.newImageUrl(po.getAuthorImg());
    }

}
