package com.naran.web.controller.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naran.core.entity.content.Content;
import com.naran.core.enums.ContentType;
import com.naran.dubbo.service.content.IContentService;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.util.ListVO;
import com.naran.foundation.util.ResultMessageBuilder;
import com.naran.web.controller.base.AppCode;
import com.naran.web.controller.base.BaseController;
import com.naran.web.param.content.ContentPageParam;
import com.naran.web.param.content.ContentParam;
import com.naran.web.vo.content.ContentPageVO;
import com.naran.web.vo.content.ContentVO;

/**
 * （官方相关推文）模块控制器
 * 
 * @author zefeng.xu
 */
@Controller
@RequestMapping("/api/content/book")
public class ContentBookController extends BaseController {

    @Autowired
    private IContentService contentService;

    /**
     * 以书会友列表(分页)
     */
    @RequestMapping(value = "/friends/page")
    public void friendsPage(ContentPageParam param, HttpServletRequest request, HttpServletResponse response) {
	ContentPageVO pageVO = new ContentPageVO();
	// 加载
	Page<Content> page = contentService.findContentByPage(ContentType.BOOK_FRIENDS.name(), param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setContents(new ListVO<ContentVO>(page.getResult(), ContentVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 以书会友新增
     */
    @RequestMapping(value = "/friends/add")
    public void friendsAdd(ContentParam param, HttpServletRequest request, HttpServletResponse response) {
	Content content = new Content();
	BeanUtils.copyProperties(param, content);
	content.setContentType(ContentType.BOOK_FRIENDS.name());
	contentService.addContent(content);
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }

    /**
     * 以书会友删除
     */
    @RequestMapping(value = "/friends/delete")
    public void friendsDelete(Long contentId, HttpServletRequest request, HttpServletResponse response) {
	contentService.deleteContent(contentId);
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }

    /**
     * 书荒互助列表(分页)
     * 
     */
    @RequestMapping(value = "/assist/page")
    public void assistPage(ContentPageParam param, HttpServletRequest request, HttpServletResponse response) {
	ContentPageVO pageVO = new ContentPageVO();
	// 加载
	Page<Content> page = contentService.findContentByPage(ContentType.BOOK_ASSIST.name(), param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setContents(new ListVO<ContentVO>(page.getResult(), ContentVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }

    /**
     * 书荒互助新增
     */
    @RequestMapping(value = "/assist/add")
    public void assistAdd(ContentParam param, HttpServletRequest request, HttpServletResponse response) {
	Content content = new Content();
	BeanUtils.copyProperties(param, content);
	content.setContentType(ContentType.BOOK_ASSIST.name());
	contentService.addContent(content);
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }

    /**
     * 书荒互助删除
     */
    @RequestMapping(value = "/assist/delete")
    public void assistDelete(Long contentId, HttpServletRequest request, HttpServletResponse response) {
	contentService.deleteContent(contentId);
	writeAjaxJSONResponse(ResultMessageBuilder.build(AppCode.SUCCESS_CODE), response);
    }
    
    /**
     * 书摘列表(分页)
     */
    @RequestMapping(value = "/digest/page")
    public void digestPage(ContentPageParam param, HttpServletRequest request, HttpServletResponse response) {
	ContentPageVO pageVO = new ContentPageVO();
	// 加载
	Page<Content> page = contentService.findContentByPage(ContentType.BOOK_DIGEST.name(), param.getPageNum(), param.getPageSize());
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    pageVO.setPageAll(param.getPageNum(), param.getPageSize(), page.getTotalPage(), page.getTotalCount());
	    pageVO.setContents(new ListVO<ContentVO>(page.getResult(), ContentVO.class).getVoList());
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(pageVO), response);
    }
    
    /**
     * 书摘首页显示
     */
    @RequestMapping(value = "/digest/home")
    public void digestHome(ContentPageParam param, HttpServletRequest request, HttpServletResponse response) {
	ContentVO VO = new ContentVO();
	Page<Content> page = contentService.findContentByPage(ContentType.BOOK_DIGEST.name(),1, 1);
	if (null != page && CollectionUtils.isNotEmpty(page.getResult())) {
	    VO.convertPOToVO(page.getResult().get(0)); 
	}
	writeAjaxJSONResponse(ResultMessageBuilder.build(VO), response);
    }
}
