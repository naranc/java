package com.naran.web.vo.order;

import org.springframework.beans.BeanUtils;

import com.naran.core.entity.order.Order;
import com.naran.core.enums.OrderType;
import com.naran.foundation.util.BaseVO;
import com.naran.foundation.util.DateUtil;
import com.naran.foundation.util.file.qiniu.QiniuImageUtil;

/**
 * 订单列表封装
 * 
 * @author zefeng.xu
 */
public class OrderSimpleVO implements BaseVO {

    private Long orderId;

    private String orderType;

    private String typeName;

    private String orderTitle;

    private String orderAuthor;

    private String orderContent;

    private String orderImgs;

    private Double city;

    private Double province;

    private String createTime;

    private String updateTime;

    private String average;// 评分

    private String ordinate;// 纵坐标

    private String abscissa;// 横坐标

    public Long getOrderId() {
	return orderId;
    }

    public void setOrderId(Long orderId) {
	this.orderId = orderId;
    }

    public String getOrderType() {
	return orderType;
    }

    public void setOrderType(String orderType) {
	this.orderType = orderType;
    }

    public String getTypeName() {
	return typeName;
    }

    public void setTypeName(String typeName) {
	this.typeName = typeName;
    }

    public String getOrderTitle() {
	return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
	this.orderTitle = orderTitle;
    }

    public String getOrderAuthor() {
	return orderAuthor;
    }

    public void setOrderAuthor(String orderAuthor) {
	this.orderAuthor = orderAuthor;
    }

    public String getOrderContent() {
	return orderContent;
    }

    public void setOrderContent(String orderContent) {
	this.orderContent = orderContent;
    }

    public String getOrderImgs() {
	return orderImgs;
    }

    public void setOrderImgs(String orderImgs) {
	this.orderImgs = orderImgs;
    }

    public Double getCity() {
	return city;
    }

    public void setCity(Double city) {
	this.city = city;
    }

    public Double getProvince() {
	return province;
    }

    public void setProvince(Double province) {
	this.province = province;
    }

    public String getCreateTime() {
	return createTime;
    }

    public void setCreateTime(String createTime) {
	this.createTime = createTime;
    }

    public String getUpdateTime() {
	return updateTime;
    }

    public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
    }

    public String getAverage() {
	return average;
    }

    public void setAverage(String average) {
	this.average = average;
    }

    public String getOrdinate() {
	return ordinate;
    }

    public void setOrdinate(String ordinate) {
	this.ordinate = ordinate;
    }

    public String getAbscissa() {
	return abscissa;
    }

    public void setAbscissa(String abscissa) {
	this.abscissa = abscissa;
    }

    @Override
    public void convertPOToVO(Object poObj) {
	if (null == poObj) {
	    return;
	}

	Order po = (Order) poObj;
	BeanUtils.copyProperties(po, this);
	this.orderId = po.getId();
	if (this.orderType != null) {
	    this.typeName = OrderType.valueOf(this.orderType).getChinese();
	}
	this.orderImgs = QiniuImageUtil.newImageUrls(po.getOrderImgs());
	this.createTime = DateUtil.formatDateYMDHMS(po.getCreateTime());
	this.updateTime = DateUtil.formatDateYMDHMS(po.getUpdateTime());

    }
}
