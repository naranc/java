package com.naran.bd.param.other;

import com.naran.bd.param.BaseParam;

public class PublicityParam extends BaseParam {

    private Long publicityId;

    private String publicityType;

    private String publicityName;

    private String publicityImg;

    private String publicityCategory;

    private Integer priority;

    public Long getPublicityId() {
	return publicityId;
    }

    public void setPublicityId(Long publicityId) {
	this.publicityId = publicityId;
    }

    public String getPublicityType() {
	return publicityType;
    }

    public void setPublicityType(String publicityType) {
	this.publicityType = publicityType;
    }

    public String getPublicityName() {
	return publicityName;
    }

    public void setPublicityName(String publicityName) {
	this.publicityName = publicityName;
    }

    public String getPublicityImg() {
	return publicityImg;
    }

    public void setPublicityImg(String publicityImg) {
	this.publicityImg = publicityImg;
    }

    public String getPublicityCategory() {
	return publicityCategory;
    }

    public void setPublicityCategory(String publicityCategory) {
	this.publicityCategory = publicityCategory;
    }

    public Integer getPriority() {
	return priority;
    }

    public void setPriority(Integer priority) {
	this.priority = priority;
    }

}
