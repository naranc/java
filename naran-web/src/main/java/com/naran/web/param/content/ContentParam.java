package com.naran.web.param.content;

import com.naran.web.param.BaseParam;

public class ContentParam extends BaseParam {

    private String contentTitle;

    private String contentBody;

    private String contentImg;

    public String getContentTitle() {
	return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
	this.contentTitle = contentTitle;
    }

    public String getContentBody() {
	return contentBody;
    }

    public void setContentBody(String contentBody) {
	this.contentBody = contentBody;
    }

    public String getContentImg() {
	return contentImg;
    }

    public void setContentImg(String contentImg) {
	this.contentImg = contentImg;
    }

}
