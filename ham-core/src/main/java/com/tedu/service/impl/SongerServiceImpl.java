package com.tedu.service.impl;

import com.tedu.dao.SongerMapper;
import com.tedu.model.Songer;
import com.tedu.query.SongerQuery;
import com.tedu.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 歌手业务层的实现类  实现歌手的业务层接口
 */
@Service
public class SongerServiceImpl extends BaseServiceImpl<SongerQuery,Songer> implements SongerService {

     private SongerMapper songerMapper;

     @Autowired
    public void setSongerMapper(SongerMapper songerMapper) {
        this.songerMapper = songerMapper;
        this.BaseDao=songerMapper;
    }

    @Override
    public List<Songer> selectobj() {
        return songerMapper.selectobj();
    }

    @Override
    public Songer selectB(int srId) {
        return songerMapper.selectB(srId);
    }
}
