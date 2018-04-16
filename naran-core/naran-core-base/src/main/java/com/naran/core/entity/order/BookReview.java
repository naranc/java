package com.naran.core.entity.order;

import com.naran.foundation.entity.BaseEntityPO;

public class BookReview extends BaseEntityPO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String title;

    private String content;
    
    private Long authorId;

    private String author;

    private String authorImg;

    private Integer commentTimes;

    private Integer likeTimes;

    private Long bookId;

    private Long orderId;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    
    

}