package com.tedu.service;

import com.tedu.model.Mtype;
import com.tedu.query.MtypeQuery;
import org.springframework.stereotype.Service;

import java.util.List;

//歌手的业务层接口
public interface MtypeService extends BaseService<MtypeQuery,Mtype> {
    List<Mtype> selectobj();

    //添加歌手的业务层接口
    //通过歌手获取歌手详细信息的接口
    //更新歌手的方法接口
    //删除歌手

}
