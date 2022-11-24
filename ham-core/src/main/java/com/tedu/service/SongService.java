package com.tedu.service;

import com.tedu.model.Song;
import com.tedu.model.Songer;
import com.tedu.query.SongQuery;
import com.tedu.query.SongerQuery;

import java.util.List;

//歌手的业务层接口
public interface SongService extends BaseService<SongQuery,Song> {
    //添加歌手的业务层接口
    //通过歌手获取歌手详细信息的接口
    //更新歌手的方法接口
    //删除歌手
    List<Song> selectSongBySids(List<Integer> list);
}
