package com.tedu.service.impl;

import com.tedu.dao.BaseDao;
import com.tedu.model.Mtype;
import com.tedu.service.BaseService;
import com.tedu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<Q,T> implements BaseService<Q,T>{


    protected BaseDao BaseDao;

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return BaseDao.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(T record) {
        return BaseDao.insert(record);
    }

    @Override
    public T selectByPrimaryKey(Integer tid) {
        return (T)BaseDao.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return BaseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<T> selectObjectAll() {
        return BaseDao.selectObjectAll();
    }

    @Override
    public List<T> selectByCondition(Q q) {
        return BaseDao.selectByCondition(q);
    }

    @Override
    public Integer selectByConditionCount(Q q) {
        return BaseDao.selectByConditionCount(q);
    }

    /**
     * 业务层实现类  实现分页条件查询业务
     * @param q
     * @return
     */
    @Override
    public PageUtil<T> selectByConditionPage(Q q) {
        //分页的业务代码
        //定一个最终要返回的页对象Page
        PageUtil<T> page=new PageUtil<>();
        //通过反射调用拿到传过来的q对象中的值
        //获取查询条件对象的类对象
        Class<?> cq = q.getClass();
        try {
            //通过类对象获取getPageNo的方法
            Method getPageNo = cq.getDeclaredMethod("getPageNo", null);
            //通过反射调用查询对象的getPageNo的方法获得pageNo的值
            Integer pageNo = (Integer) getPageNo.invoke(q, null);
            //通过类对象获取getPageSzie的方法
            Method getPageSize = cq.getDeclaredMethod("getPageSize", null);
            //通过反射调用查询对象的getPageSzie的方法获得pageSzie的值
            Integer pageSzie = (Integer) getPageSize.invoke(q, null);
            //通过类对象获取setStartNum的方法
            Method setStartNum = cq.getDeclaredMethod("setStartNum", Integer.class);
            //通过反射调用查询对象的setStartNum的方法设置StartNum的值
            setStartNum.invoke(q, (pageNo - 1) * pageSzie);

            //设置page对象的值
            page.setPageNo(pageNo);
            page.setPageSize(pageSzie);
            page.setStartNum((pageNo-1)*pageSzie);

            //剩三个  totalpage  toealcount   list
            //toealcount从数据库查询
            Integer totalCount = BaseDao.selectByConditionCount(q);
            page.setTotalCount(totalCount);
            //查询数据
            List list = BaseDao.selectByCondition(q);
            page.setList(list);
        }catch (Exception e){
            e.printStackTrace();
        }

        return page;
    }

}
