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

    private Double average;// 评分
    
    private Double ordinate;//纵坐标
    
    private Double abscissa;//横坐标
    

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
