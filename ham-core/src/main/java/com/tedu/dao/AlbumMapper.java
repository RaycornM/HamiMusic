package com.tedu.dao;

import com.tedu.model.Album;
import com.tedu.query.AlbumQuery;

import java.util.List;
import java.util.Map;

public interface AlbumMapper extends BaseDao<AlbumQuery,Album>{
    List<Album> selectAlbumByName(Map<String, String> map);
    List<Album> selectobj();
}