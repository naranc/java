package com.naran.core.enums;

/**
 * 
 * @author zefeng.xu
 */
public enum ContentType {

     BOOK_DIGEST("书摘"),BOOK_FRIENDS("以书会友"), BOOK_ASSIST("书荒互助"), COVERAGE("专题报道"), WEEKLY("每周推荐");

    private String chinese;

    public String getChinese() {
	return chinese;
    }

    private ContentType(String chinese) {
	this.chinese = chinese;
    }
}
