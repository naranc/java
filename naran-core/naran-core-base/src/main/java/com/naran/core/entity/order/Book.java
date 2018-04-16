package com.naran.core.entity.order;

import java.math.BigDecimal;

import com.naran.foundation.entity.BaseEntityPO;

public class Book extends BaseEntityPO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String isbn;

    private String title;

    private Integer pages;

    private String author;

    private BigDecimal price;

    private String publisher;

    private String summary;

    private BigDecimal average;

    private String tags;
    
    private String bookImg;

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

    public String getPublisher() {
	return publisher;
    }

    public void setPublisher(String publisher) {
	this.publisher = publisher;
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
    }

    public BigDecimal getAverage() {
	return average;
    }

    public void setAverage(BigDecimal average) {
	this.average = average;
    }

    public String getTags() {
	return tags;
    }

    public void setTags(String tags) {
	this.tags = tags;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }
    
    
    

}