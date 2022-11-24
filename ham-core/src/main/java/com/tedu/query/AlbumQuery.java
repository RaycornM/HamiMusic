package com.tedu.query;

 import com.tedu.model.Album;

/**
  * 作为查询对象的query
  */
 public class AlbumQuery extends Album {

     private Integer pageSize = 5;

     private Integer pageNo;

     private Integer startNum;


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
