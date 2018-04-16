package com.naran.web.param.order;

import com.naran.web.param.BasePageParam;

public class OrderPageParam extends BasePageParam {

    private String orderByType;// 排序

    private String agingDegree;// 新旧程度

    private String commodityType;// 商品类别

    private String title;

    public String getOrderByType() {
	return orderByType;
    }

    public void setOrderByType(String orderByType) {
	this.orderByType = orderByType;
    }

    public String getAgingDegree() {
	return agingDegree;
    }

    public void setAgingDegree(String agingDegree) {
	this.agingDegree = agingDegree;
    }

    public String getCommodityType() {
	return commodityType;
    }

    public void setCommodityType(String commodityType) {
	this.commodityType = commodityType;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

}
