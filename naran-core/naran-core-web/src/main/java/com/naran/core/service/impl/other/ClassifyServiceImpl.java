package com.naran.core.service.impl.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naran.core.dao.other.ClassifyDao;
import com.naran.core.entity.other.Classify;
import com.naran.dubbo.service.other.IClassifyService;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务
 * 
 * @author zefeng.xu
 */
@Transactional
@Service("classifyService")
public class ClassifyServiceImpl implements IClassifyService {

    @Autowired
    private ClassifyDao classifyDao;

    @Override
    public Long addClassify(Classify classify) {
	if (classify == null) {
	    return null;
	}
	return classifyDao.addClassify(classify);
    }

    @Override
    public void updateClassify(Classify classify) {
	if (classify == null || classify.getId() == null) {
	    return;
	}
	classifyDao.updateClassify(classify);

    }

    @Override
    public void deleteClassify(Long id) {
	if (id == null) {
	    return;
	}
	classifyDao.deleteClassify(id);

    }

    @Override
    public Classify findClassifyById(Long id) {
	if (id == null) {
	    return null;
	}
	return classifyDao.findClassifyById(id);
    }

    @Override
    public Page<Classify> findClassifyByPage(String classifyType, int pageNum, int pageSize) {
	return classifyDao.findClassifyByPage(classifyType, pageNum, pageSize);
    }

    @Override
    public List<Classify> findClassifyByFather(Long fatherId) {
	return classifyDao.findClassifyByFather(fatherId);
    }

}
