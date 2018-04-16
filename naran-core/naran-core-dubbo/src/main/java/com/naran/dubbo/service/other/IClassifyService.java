package com.naran.dubbo.service.other;

import java.util.List;

import com.naran.core.entity.other.Classify;
import com.naran.foundation.mybatis.page.Page;

/**
 * 服务接口
 * 
 * @author zefeng.xu
 */
public interface IClassifyService {

    Long addClassify(Classify classify);

    void updateClassify(Classify classify);

    void deleteClassify(Long id);

    Classify findClassifyById(Long id);

    /**
     * 获取（分页）
     * 
     * @param classifyType
     * @return
     */
    Page<Classify> findClassifyByPage(String classifyType, int pageNum, int pageSize);

    List<Classify> findClassifyByFather(Long fatherId);

}
