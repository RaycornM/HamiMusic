package com.tedu.service;

import com.tedu.util.PageUtil;

import java.util.List;

public interface BaseService<Q,T> {

    int deleteByPrimaryKey(Integer tid);

    int insert(T record);

    T selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(T record);

    List<T> selectObjectAll();

    List<T> selectByCondition(Q q);

    Integer selectByConditionCount(Q q);

    /**
     * 根据条件查询数据并且用页对象承载展现
     * @return
     */
    PageUtil<T> selectByConditionPage(Q q);
}
