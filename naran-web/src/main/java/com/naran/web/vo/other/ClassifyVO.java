package com.naran.web.vo.other;

import org.springframework.beans.BeanUtils;

import com.naran.core.entity.other.Classify;
import com.naran.foundation.util.BaseVO;
import com.naran.foundation.util.file.qiniu.QiniuImageUtil;

/**
 * 展示封装
 * 
 * @author zefeng.xu
 */
public class ClassifyVO implements BaseVO {

    private Long classifyId;

    private String classifyName;

    private String classifyValue;

    private String classifyType;

    private String remark;

    private String classifyImg;

    private Long fatherId;

    private Integer priority;

    public Long getClassifyId() {
	return classifyId;
    }

    public void setClassifyId(Long classifyId) {
	this.classifyId = classifyId;
    }

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

    @Override
    public void convertPOToVO(Object poObj) {
	if (null == poObj) {
	    return;
	}

	Classify po = (Classify) poObj;
	BeanUtils.copyProperties(po, this);
	this.classifyId = po.getId();
	this.classifyImg = QiniuImageUtil.newImageUrl(po.getClassifyImg());

    }

}
