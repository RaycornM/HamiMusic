package com.tedu.dao;

import com.tedu.model.Song;
import com.tedu.query.SongQuery;

import java.util.List;

public interface SongMapper extends BaseDao<SongQuery,Song>{
    List<Song> selectSongBySids(List<Integer> list);

//    int deleteByPrimaryKey(Integer sid);
//
//    int insert(Song record);
//
//    int insertSelective(Song record);
//
//    Song selectByPrimaryKey(Integer sid);
//
//    int updateByPrimaryKeySelective(Song record);
//
//    int updateByPrimaryKeyWithBLOBs(Song record);
//
//    int updateByPrimaryKey(Song record);
}