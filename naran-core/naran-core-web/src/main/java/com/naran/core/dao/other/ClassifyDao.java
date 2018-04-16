package com.naran.core.dao.other;

import java.util.List;

import com.naran.core.entity.other.Classify;
import com.naran.foundation.mybatis.page.Page;

/**
 * 数据访问接口
 * 
 * @author zefeng.xu
 */
public interface ClassifyDao {

    Long addClassify(Classify classify);

    void updateClassify(Classify classify);
    
    void deleteClassify(Long id);

    Classify findClassifyById(Long id);

    Page<Classify> findClassifyByPage(String classifyType, int pageNum, int pageSize);

    List<Classify> findClassifyByFather(Long fatherId);

}
