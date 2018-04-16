package com.naran.web.param.order;

import java.math.BigDecimal;

import com.naran.web.param.BaseParam;

/**
 * 捐赠书本入参
 * 
 * @author zefeng.xu
 * */
public class DonationBookParam extends BaseParam {

    private Long bookId;

    private String isbn;

    private String title;

    private Integer pages;

    private String author;

    private String publisher;

    private BigDecimal price;

    private BigDecimal average;

    private String summary;

    private String bookImg;

    private String tags;

    private String agingDegree;// 新旧程度

    private String bookReview;// 书评

    public Long getBookId() {
	return bookId;
    }

    public void setBookId(Long bookId) {
	this.bookId = bookId;
    }

    public String getIsbn() {
	return isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Integer getPages() {
	return pages;
    }

    public void setPages(Integer pages) {
	this.pages = pages;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
    }

    public String getPublisher() {
	return publisher;
    }

    public void setPublisher(String publisher) {
	this.publisher = publisher;
    }

    public String getBookImg() {
	return bookImg;
    }

    public void setBookImg(String bookImg) {
	this.bookImg = bookImg;
    }

    public String getTags() {
	return tags;
    }

    public void setTags(String tags) {
	this.tags = tags;
    }

    public String getAgingDegree() {
	return agingDegree;
    }

    public void setAgingDegree(String agingDegree) {
	this.agingDegree = agingDegree;
    }

    public String getBookReview() {
	return bookReview;
    }

    public void setBookReview(String bookReview) {
	this.bookReview = bookReview;
    }

    public BigDecimal getAverage() {
	return average;
    }

    public void setAverage(BigDecimal average) {
	this.average = average;
    }

}
