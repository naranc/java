package com.naran.web.controller.order.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naran.core.entity.account.Account;
import com.naran.core.entity.order.Book;
import com.naran.core.entity.order.BookReview;
import com.naran.core.entity.order.Order;
import com.naran.core.enums.CertificationType;
import com.naran.dubbo.service.account.IAccountService;
import com.naran.dubbo.service.order.IBookReviewService;
import com.naran.dubbo.service.order.IBookService;
import com.naran.dubbo.service.order.IOrderService;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.util.ListVO;
import com.naran.foundation.util.ResultMessageBuilder;
import com.naran.foundation.util.StringUtil;
import com.naran.web.controller.base.AppCode;
import com.naran.web.controller.base.BaseController;
import com.naran.web.param.BasePageParam;
import com.naran.web.param.BaseParam;
import com.naran.web.vo.order.book.BookReviewPageVO;
import com.naran.web.vo.order.book.BookReviewVO;

/**
 * （书评）模块控制器
 * 
 * @author zefeng.xu
 */
@Controller
@RequestMapping("/api/book/review")
public class BookReviewController extends BaseController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IBookReviewService bookReviewService;

    /**
     * 列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/page")
    public void bookReviewPage(Long orderId, BasePageParam param, HttpServletRequest request, HttpServletResponse response) {
	BookReviewPageVO pageVO = new BookReviewPageVO();
	// 加载
	Page<BookReview> page = bookReviewService.findBookReviewByPage(orderId, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setReviews(new ListVO<BookReviewVO>(page.getResult(), BookReviewVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 书评
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add")
    public void donation(BaseParam param, String content, Long orderId, HttpServletRequest request, HttpServletResponse response) {
	Account current = accountService.currentAccount(param.getAccessToken());
	if (null == current) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.GO_TO_LOGIN_CODE), response);
	    return;
	}
	if (!CertificationType.SUCCESS.name().equals(current.getCertificationType())) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.ACCOUNT_CERTIFICATION_CODE), response);
	    return;
	}
	Order order = orderService.findOrderById(orderId);
	if (order != null) {
	    Book book = bookService.findBookById(order.getTypeId());
	    if (book != null && StringUtil.isNotBlank(content)) {
		BookReview bookReview = new BookReview();
		bookReview.setAuthorId(current.getId());
		bookReview.setAuthor(current.getNickName());
		bookReview.setAuthorImg(current.getPhoto());
		bookReview.setContent(content);
		bookReview.setBookId(book.getId());
		bookReview.setOrderId(orderId);
		bookReviewService.addBookReview(bookReview);
	    }
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }

    /**
     * 书评删除
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/delete")
    public void donation(BaseParam param, Long reviewId, HttpServletRequest request, HttpServletResponse response) {
	Account current = accountService.currentAccount(param.getAccessToken());
	if (null == current) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.GO_TO_LOGIN_CODE), response);
	    return;
	}
	BookReview review=bookReviewService.findBookReviewById(reviewId);
	if (review!=null&&!current.getId().equals(review.getAuthorId())) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.FAIL_CODE,"不能删除别人的书评！"), response);
	    return;
	}

	bookReviewService.deleteBookReview(reviewId);

	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }
}
