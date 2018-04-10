package com.naran.core.enums;

/**
 * 
 * @author zefeng.xu
 */
public enum OrderType {

    BOOK("爱心书屋"), COSMETICS("美妆护理"),JEWELRY("钟表首饰"),ELECTRONICS("数码电器"),EQUIPMENT("工具器材");

    private String chinese;

    public String getChinese() {
	return chinese;
    }

    private OrderType(String chinese) {
	this.chinese = chinese;
    }
}
