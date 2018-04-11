package com.naran.bd.vo.account;

import java.util.List;

import com.naran.foundation.util.BasePageVO;

public class AccountPageVO extends BasePageVO {

    private List<AccountVO> accounts;

    public List<AccountVO> getAccounts() {
	return accounts;
    }

    public void setAccounts(List<AccountVO> accounts) {
	this.accounts = accounts;
    }

}
