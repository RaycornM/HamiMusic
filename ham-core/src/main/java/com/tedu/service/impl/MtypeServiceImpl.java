package com.tedu.service.impl;

import com.tedu.dao.MtypeMapper;
import com.tedu.model.Mtype;
import com.tedu.query.MtypeQuery;
import com.tedu.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 歌手业务层的实现类  实现歌手的业务层接口
 */
@Service
public class MtypeServiceImpl extends BaseServiceImpl<MtypeQuery,Mtype> implements MtypeService {

     private MtypeMapper mtypeMapper;

     @Autowired
    public void setMtypeMapper(MtypeMapper mtypeMapper) {
        this.mtypeMapper = mtypeMapper;
        this.BaseDao=mtypeMapper;
    }

    @Override
    public List<Mtype> selectobj() {
        return mtypeMapper.selectobj();
    }
}
