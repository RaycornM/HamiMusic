package com.tedu.service.impl;

import com.tedu.dao.AlbumMapper;
import com.tedu.model.Album;
import com.tedu.query.AlbumQuery;
import com.tedu.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 歌手业务层的实现类  实现歌手的业务层接口
 */
@Service
public class AlbumServiceImpl extends BaseServiceImpl<AlbumQuery,Album> implements AlbumService {

     private AlbumMapper albumMapper;

     @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
        this.BaseDao=albumMapper;
    }

    @Override
    public List<Album> selectAlbumByName(Map<String, String> map) {
        return albumMapper.selectAlbumByName(map);
    }

    @Override
    public List<Album> selectobj() {
        return albumMapper.selectobj();
    }
}
