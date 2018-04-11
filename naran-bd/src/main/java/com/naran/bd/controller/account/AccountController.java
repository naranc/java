package com.naran.bd.controller.account;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naran.bd.controller.base.BaseController;
import com.naran.bd.controller.base.BdCode;
import com.naran.bd.param.BasePageParam;
import com.naran.bd.vo.account.AccountPageVO;
import com.naran.bd.vo.account.AccountVO;
import com.naran.core.entity.account.Account;
import com.naran.dubbo.service.account.IAccountService;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.util.DateUtil;
import com.naran.foundation.util.ListVO;
import com.naran.foundation.util.ResultMessageBuilder;

/**
 * （用户账号）模块控制器
 * 
 * @author zefeng.xu
 */
@Controller
@RequestMapping("/bd/account")
public class AccountController extends BaseController {

    @Autowired
    private IAccountService accountService;

    /**
     * 用户列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/page")
    public void page(BasePageParam param, HttpServletRequest request, HttpServletResponse response) {
	AccountPageVO pageVO = new AccountPageVO();
	// 加载
	Page<Account> page = accountService.findAccountByPage(null, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setAccounts(new ListVO<AccountVO>(page.getResult(), AccountVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 新增用户列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/new/page")
    public void newPage(BasePageParam param, HttpServletRequest request, HttpServletResponse response) {
	AccountPageVO pageVO = new AccountPageVO();
	String startDate = DateUtil.formatDate(new Date());
	String endDate = DateUtil.formatDate(new Date());
	// 加载
	Page<Account> page = accountService.findAccountByPage(null, null, startDate, endDate, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setAccounts(new ListVO<AccountVO>(page.getResult(), AccountVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 沉默用户列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/silent/page")
    public void silentPage(BasePageParam param, HttpServletRequest request, HttpServletResponse response) {
	AccountPageVO pageVO = new AccountPageVO();
	String silentTime = DateUtil.formatDate(DateUtil.getAddMonthDate(new Date(), -1));
	// 加载
	Page<Account> page = accountService.findAccountByPage(silentTime, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setAccounts(new ListVO<AccountVO>(page.getResult(), AccountVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 沉默用户列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/defriend/page")
    public void defriendPage(BasePageParam param, HttpServletRequest request, HttpServletResponse response) {
	AccountPageVO pageVO = new AccountPageVO();
	
	// 加载
	Page<Account> page = accountService.findAccountByPage(null, Boolean.FALSE, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setAccounts(new ListVO<AccountVO>(page.getResult(), AccountVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 获取用户信息
     * 
     */
    @RequestMapping(value = "/by/id", method = RequestMethod.POST)
    public void byId(Long accountId, HttpServletRequest request, HttpServletResponse response) {
	Account account = accountService.getAccountById(accountId);
	AccountVO accountVO = new AccountVO();
	accountVO.convertPOToVO(account);
	writeAjaxJSONResponse(ResultMessageBuilder.build(accountVO), response);
    }

    /**
     * 拉黑
     * 
     */
    @RequestMapping(value = "/defriend", method = RequestMethod.POST)
    public void defriend(Long accountId, HttpServletRequest request, HttpServletResponse response) {

	Account account = accountService.getAccountById(accountId);
	if (account.getDefriend()) {
	    account.setDefriend(Boolean.FALSE);
	} else {
	    account.setDefriend(Boolean.TRUE);
	}
	accountService.updateAccount(account);
	writeAjaxJSONResponse(ResultMessageBuilder.build(BdCode.SUCCESS_CODE), response);
    }

}
