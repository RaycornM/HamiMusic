package com.tedu.dao;

import com.tedu.model.Mtype;
import com.tedu.query.MtypeQuery;

import java.util.List;

public interface MtypeMapper extends BaseDao<MtypeQuery,Mtype> {

    List<Mtype> selectobj();

}
