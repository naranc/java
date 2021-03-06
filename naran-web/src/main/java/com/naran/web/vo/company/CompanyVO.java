package com.naran.web.vo.company;

import org.springframework.beans.BeanUtils;

import com.naran.core.entity.company.Company;
import com.naran.foundation.util.BaseVO;
import com.naran.foundation.util.file.qiniu.QiniuImageUtil;

public class CompanyVO implements BaseVO {

    private Long companyId;

    private String companyName;

    private String charger;

    private String establishTime;

    private String address;

    private String city;

    private String province;

    private String county;

    private String phone;

    private String companyType;

    private String companyImg;

    private String companyContent;

    public Long getCompanyId() {
	return companyId;
    }

    public void setCompanyId(Long companyId) {
	this.companyId = companyId;
    }

    public String getCompanyName() {
	return companyName;
    }

    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    public String getCharger() {
	return charger;
    }

    public void setCharger(String charger) {
	this.charger = charger;
    }

    public String getEstablishTime() {
	return establishTime;
    }

    public void setEstablishTime(String establishTime) {
	this.establishTime = establishTime;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getProvince() {
	return province;
    }

    public void setProvince(String province) {
	this.province = province;
    }

    public String getCounty() {
	return county;
    }

    public void setCounty(String county) {
	this.county = county;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getCompanyType() {
	return companyType;
    }

    public void setCompanyType(String companyType) {
	this.companyType = companyType;
    }

    public String getCompanyImg() {
	return companyImg;
    }

    public void setCompanyImg(String companyImg) {
	this.companyImg = companyImg;
    }

    public String getCompanyContent() {
	return companyContent;
    }

    public void setCompanyContent(String companyContent) {
	this.companyContent = companyContent;
    }

    @Override
    public void convertPOToVO(Object poObj) {
	if (null == poObj) {
	    return;
	}

	Company po = (Company) poObj;
	BeanUtils.copyProperties(po, this);
	this.companyId = po.getId();
	this.companyImg = QiniuImageUtil.newImageUrl(po.getCompanyImg());
	// this.createTime = DateUtil.formatDateYMDHMS(po.getCreateTime());

    }

}
