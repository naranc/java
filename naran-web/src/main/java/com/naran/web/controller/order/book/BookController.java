package com.naran.web.controller.order.book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naran.core.entity.account.Account;
import com.naran.core.entity.order.Book;
import com.naran.core.entity.order.BookReview;
import com.naran.core.entity.order.Order;
import com.naran.core.entity.other.Classify;
import com.naran.core.enums.CertificationType;
import com.naran.core.enums.OrderType;
import com.naran.dubbo.service.account.IAccountService;
import com.naran.dubbo.service.order.IBookService;
import com.naran.dubbo.service.order.IOrderApplyService;
import com.naran.dubbo.service.order.IOrderService;
import com.naran.dubbo.service.other.IClassifyService;
import com.naran.foundation.entity.TudouBookInfo;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.util.DoubanUtil;
import com.naran.foundation.util.ListVO;
import com.naran.foundation.util.ResultMessageBuilder;
import com.naran.foundation.util.StringUtil;
import com.naran.foundation.util.file.qiniu.QiniuImageUtil;
import com.naran.web.controller.base.AppCode;
import com.naran.web.controller.base.BaseController;
import com.naran.web.param.order.DonationBookParam;
import com.naran.web.param.order.OrderPageParam;
import com.naran.web.vo.order.OrderPageVO;
import com.naran.web.vo.order.OrderSimpleVO;
import com.naran.web.vo.order.book.BookVO;
import com.naran.web.vo.other.ClassifyVO;

/**
 * （图书）模块控制器
 * 
 * @author zefeng.xu
 */
@Controller
@RequestMapping("/api/book")
public class BookController extends BaseController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderApplyService orderApplyService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IClassifyService classifyService;

    /**
     * 图书分类
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/type")
    public void type(HttpServletRequest request, HttpServletResponse response) {
	// 加载
	List<Classify> classifys = classifyService.findClassifyByFather(1l);
	writeAjaxJSONResponse(ResultMessageBuilder.build(new ListVO<ClassifyVO>(classifys, ClassifyVO.class).getVoList()), response);
    }

    /**
     * 列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/order/page")
    public void orderPage(OrderPageParam param, String bookClassify, HttpServletRequest request, HttpServletResponse response) {
	OrderPageVO pageVO = new OrderPageVO();
	// 加载
	Page<Order> page = orderService.findOrderByPage(OrderType.BOOK.name(), null, bookClassify, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setOrders(getPages(page.getResult()));
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 推荐列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/recommend/page")
    public void recommendPage(OrderPageParam param, HttpServletRequest request, HttpServletResponse response) {
	OrderPageVO pageVO = new OrderPageVO();
	// 加载
	Page<Order> page = orderService.findOrderByPage(OrderType.BOOK.name(), null, null, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setOrders(getPages(page.getResult()));
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 相关列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/relevant/page")
    public void relevantPage(OrderPageParam param, Long bookId, HttpServletRequest request, HttpServletResponse response) {
	OrderPageVO pageVO = new OrderPageVO();
	// 加载
	Page<Order> page = orderService.findOrderByPage(OrderType.BOOK.name(), null, null, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setOrders(getPages(page.getResult()));
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 热门列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/hot/page")
    public void hotPage(OrderPageParam param, HttpServletRequest request, HttpServletResponse response) {
	OrderPageVO pageVO = new OrderPageVO();
	// 加载
	Page<Order> page = orderService.findOrderByPage(OrderType.BOOK.name(), null, null, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setOrders(getPages(page.getResult()));
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }
    
    /**
     * 书摘列表(分页)
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/digest/page")
    public void digestPage(OrderPageParam param, HttpServletRequest request, HttpServletResponse response) {
	OrderPageVO pageVO = new OrderPageVO();
	// 加载
	Page<Order> page = orderService.findOrderByPage(OrderType.BOOK.name(), null, null, null, null, null, param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setOrders(getPages(page.getResult()));
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    private List<OrderSimpleVO> getPages(List<Order> orders) {
	List<OrderSimpleVO> VOs = new ArrayList<OrderSimpleVO>();
	Book book = null;
	OrderSimpleVO VO = null;
	for (Order order : orders) {
	    VO = new OrderSimpleVO();
	    VO.convertPOToVO(order);
	    book = bookService.findBookById(order.getTypeId());
	    if (book != null) {
		if (book.getAverage() != null) {
		    VO.setAverage(book.getAverage().setScale(1, BigDecimal.ROUND_HALF_UP).toString());
		}
		VO.setOrderAuthor(book.getAuthor());
		if (book.getBookImg() != null && book.getBookImg().indexOf("http") < 0) {
		    VO.setOrderImgs(QiniuImageUtil.newImageUrl(book.getBookImg()));
		} else {
		    VO.setOrderImgs(book.getBookImg());
		}
		VOs.add(VO);
	    }
	}
	return VOs;
    }

    /**
     * 获取图书
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/by/isbn")
    public void byIsbn(String isbn, HttpServletRequest request, HttpServletResponse response) {
	Book book = bookService.findBookByIsbn(isbn);
	BookVO VO = new BookVO();
	if (book == null) {
	    TudouBookInfo tudouBook = DoubanUtil.getBook(isbn);
	    if (tudouBook != null) {
		book = new Book();
		BeanUtils.copyProperties(tudouBook, book);
		book.setBookImg(tudouBook.getImagePath());
		book.setIsbn(isbn);
		book.setTags(null);
		if (tudouBook.getPrice() != null) {
		    book.setPrice(new BigDecimal(tudouBook.getPrice().replace("元", "")));
		}
		if (tudouBook.getPages() != null) {
		    book.setPages(Integer.valueOf(tudouBook.getPages()));
		}
		if (tudouBook.getAverage() != null) {
		    book.setAverage(new BigDecimal(tudouBook.getAverage()).setScale(1, BigDecimal.ROUND_HALF_UP));
		}
		// bookService.addBook(book);
	    }
	}
	VO.convertPOToVO(book);
	writeAjaxJSONResponse(ResultMessageBuilder.build(VO), response);
    }

    /**
     * 获取图书ID
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/by/id")
    public void byId(Long id, HttpServletRequest request, HttpServletResponse response) {
	Book book = bookService.findBookById(id);
	BookVO VO = new BookVO();

	VO.convertPOToVO(book);
	writeAjaxJSONResponse(ResultMessageBuilder.build(VO), response);
    }

    /**
     * 捐书
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/donation")
    public void donation(DonationBookParam param, HttpServletRequest request, HttpServletResponse response) {
	Account current = accountService.currentAccount(param.getAccessToken());
	if (null == current) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.GO_TO_LOGIN_CODE), response);
	    return;
	}
	if (!CertificationType.SUCCESS.name().equals(current.getCertificationType())) {
	    writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.ACCOUNT_CERTIFICATION_CODE), response);
	    return;
	}
	Order order = new Order();
	order.setOrderType(OrderType.BOOK.name());
	BeanUtils.copyProperties(param, order);
	order.setInitiatorId(current.getId());
	order.setInitiatorNike(current.getNickName());

	Book book = bookService.findBookById(param.getBookId());
	if (book == null) {
	    book = new Book();
	    BeanUtils.copyProperties(param, book);
	}
	order.setOrderTitle(book.getTitle());
	order.setOrderImgs(book.getBookImg());
	order.setOrderContent(book.getSummary());
	BookReview bookReview = null;
	if (StringUtil.isNotBlank(param.getBookReview())) {
	    bookReview = new BookReview();
	    bookReview.setAuthorId(current.getId());
	    bookReview.setAuthor(current.getNickName());
	    bookReview.setAuthorImg(current.getPhoto());
	    bookReview.setContent(param.getBookReview());
	}

	orderService.addOrderByBook(order, book, bookReview);
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }
}
