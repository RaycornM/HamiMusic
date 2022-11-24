package com.tedu.service;

import com.tedu.model.Album;
import com.tedu.query.AlbumQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//歌手的业务层接口
public interface AlbumService extends BaseService<AlbumQuery,Album> {
    List<Album> selectAlbumByName(Map<String, String> map);

    List<Album> selectobj();
    //添加歌手的业务层接口
    //通过歌手获取歌手详细信息的接口
    //更新歌手的方法接口
    //删除歌手

}
