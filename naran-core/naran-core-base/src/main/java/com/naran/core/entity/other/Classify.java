package com.naran.core.entity.other;

import com.naran.foundation.entity.BaseEntityPO;

public class Classify extends BaseEntityPO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String classifyName;

    private String classifyValue;

    private String classifyType;

    private String remark;

    private String classifyImg;

    private Long fatherId;

    private Integer priority;

    public String getClassifyName() {
	return classifyName;
    }

    public void setClassifyName(String classifyName) {
	this.classifyName = classifyName;
    }

    public String getClassifyValue() {
	return classifyValue;
    }

    public void setClassifyValue(String classifyValue) {
	this.classifyValue = classifyValue;
    }

    public String getClassifyType() {
	return classifyType;
    }

    public void setClassifyType(String classifyType) {
	this.classifyType = classifyType;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }

    public String getClassifyImg() {
	return classifyImg;
    }

    public void setClassifyImg(String classifyImg) {
	this.classifyImg = classifyImg;
    }

    public Long getFatherId() {
	return fatherId;
    }

    public void setFatherId(Long fatherId) {
	this.fatherId = fatherId;
    }

    public Integer getPriority() {
	return priority;
    }

    public void setPriority(Integer priority) {
	this.priority = priority;
    }

}