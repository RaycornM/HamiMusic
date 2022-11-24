package com.tedu.dao;

import com.tedu.model.Songer;
import com.tedu.query.SongerQuery;

import java.util.List;

public interface SongerMapper extends BaseDao<SongerQuery,Songer> {
    List<Songer> selectobj();
    Songer selectB(int srId);

}