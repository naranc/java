package com.naran.core.dao.other.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naran.core.dao.other.ClassifyDao;
import com.naran.core.entity.other.Classify;
import com.naran.foundation.mybatis.dao.MyBatisDAO;
import com.naran.foundation.mybatis.page.Page;
import com.naran.foundation.mybatis.page.PageRequest;

/**
 * 
 * @author zefeng.xu
 */
@Repository
public class ClassifyDaoImpl implements ClassifyDao {

    private static final String ADD_CLASSIFY = "addClassify";
    private static final String UPDATE_CLASSIFY = "updateClassify";
    private static final String FIND_CLASSIFY_BY_ID = "findClassifyById";
    private static final String FIND_CLASSIFY_BY_PAGE = "findClassifyByPage";

    @Autowired
    private MyBatisDAO myBatisDAO;

    @Override
    public Long addClassify(Classify classify) {
	classify.setCreateTime(new Date());
	classify.setUpdateTime(new Date());
	classify.setExpired(Boolean.TRUE);
	myBatisDAO.insert(ADD_CLASSIFY, classify);
	return classify.getId();
    }

    @Override
    public void updateClassify(Classify classify) {
	classify.setUpdateTime(new Date());
	myBatisDAO.update(UPDATE_CLASSIFY, classify);
    }

    @Override
    public void deleteClassify(Long id) {
	Classify classify = new Classify();
	classify.setId(id);
	classify.setExpired(Boolean.FALSE);
	myBatisDAO.update(UPDATE_CLASSIFY, classify);
    }

    @Override
    public Classify findClassifyById(Long id) {
	if (id == null) {
	    return null;
	}
	return (Classify) myBatisDAO.findForObject(FIND_CLASSIFY_BY_ID, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Page<Classify> findClassifyByPage(String classifyType, int pageNum, int pageSize) {
	Map<String, Object> param = new HashMap<String, Object>();
	param.put("classifyType", classifyType);
	return myBatisDAO.findForPage(FIND_CLASSIFY_BY_PAGE, new PageRequest(pageNum, pageSize, param));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Classify> findClassifyByFather(Long fatherId) {
	Map<String, Object> param = new HashMap<String, Object>();
	param.put("fatherId", fatherId);
	return myBatisDAO.findForList(FIND_CLASSIFY_BY_PAGE, param);
    }

}
