package com.naran.core.enums;

/**
 * 
 * @author zefeng.xu
 */
public enum PublicityType {
    
    BOOK("爱心书屋"), HOME("首页");
    
    private String chinese;

    public String getChinese() {
	return chinese;
    }

    private PublicityType(String chinese) {
	this.chinese = chinese;
    }

}
