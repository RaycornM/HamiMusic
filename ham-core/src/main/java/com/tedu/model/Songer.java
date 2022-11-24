package com.tedu.model;

import java.io.Serializable;

public class Songer implements Serializable {
    private Integer srid;

    private Integer tid;

    private String srname;

    private String area;

    private String pic;

    private Integer isHot;

    private String intro;

    private Mtype mtype;

    public Mtype getMtype() {
        return mtype;
    }

    public void setMtype(Mtype mtype) {
        this.mtype = mtype;
    }

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getSrname() {
        return srname;
    }

    public void setSrname(String srname) {
        this.srname = srname == null ? null : srname.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Override
    public String toString() {
        return "Songer{" +
                "srid=" + srid +
                ", tid=" + tid +
                ", srname='" + srname + '\'' +
                ", area='" + area + '\'' +
                ", pic='" + pic + '\'' +
                ", isHot=" + isHot +
                ", intro='" + intro + '\'' +
                ", mtype=" + mtype +
                '}';
    }
}