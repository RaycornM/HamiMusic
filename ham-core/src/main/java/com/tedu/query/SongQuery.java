package com.tedu.query;

import com.tedu.model.Song;
import com.tedu.model.Songer;

/**
 * 作为查询对象的query
 */
public class SongQuery extends Song {
    private Integer pageSize = 5;

    private Integer pageNo;

    private Integer startNum;

    //利用冗余字段的形式解决这个问题
    private String  srname;

    private String aname;

    private Integer pageNoPortal = 1;

    public Integer getPageNoPortal() {
        return pageNoPortal;
    }

    public void setPageNoPortal(Integer pageNoPortal) {
        this.pageNoPortal = pageNoPortal;
    }

    public String getSrname() {
        return srname;
    }

    public void setSrname(String srname) {
        this.srname = srname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

}
