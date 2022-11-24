package com.tedu.service.impl;

import com.tedu.dao.SongMapper;
import com.tedu.dao.SongerMapper;
import com.tedu.model.Song;
import com.tedu.model.Songer;
import com.tedu.query.SongQuery;
import com.tedu.query.SongerQuery;
import com.tedu.service.SongService;
import com.tedu.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 歌手业务层的实现类  实现歌手的业务层接口
 */
@Service
public class SongServiceImpl extends BaseServiceImpl<SongQuery,Song> implements SongService {

     private SongMapper songMapper;

     @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
        this.BaseDao=songMapper;
    }

    @Override
    public List<Song> selectSongBySids(List<Integer> list) {
        return songMapper.selectSongBySids(list);
    }
}
