package com.tedu.controller;

import com.alibaba.fastjson.JSON;
import com.tedu.model.Mtype;
import com.tedu.model.Song;
import com.tedu.query.SongQuery;
import com.tedu.service.AlbumService;
import com.tedu.service.MtypeService;
import com.tedu.service.SongService;
import com.tedu.service.SongerService;
import com.tedu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 前台访问首页的controller
 */
@Controller
@RequestMapping("portal")
public class SearchController {

    @Autowired
    private SongService songService;

    @Autowired
    private MtypeService mtypeService;

    @Autowired
    AlbumService albumService;

    @Autowired
    SongerService songerService;

     @RequestMapping("search.do")
     public String  doFindAll(SongQuery mq, Model model){

         if(mq.getPageNo() == null){
             mq.setPageNo(1);
         }
         //查询分页的数据
         PageUtil<Song> page = songService.selectByConditionPage(mq);
         //把page对象发给页面
         model.addAttribute("page", page);
         //把查询条件也要回显
         model.addAttribute("mq", mq);
         //查询流派
         List<Mtype> mtypes = mtypeService.selectObjectAll();
         model.addAttribute("mtypes", mtypes);
         return "search";
     }

    @RequestMapping("play")
    public String song(String sids, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String[] idsArr = null;
        idsArr = sids.split(",");
        Cookie[] cookies = request.getCookies();
        String cookieIds = null;
        String[] idsArrCookie = null;

        if(cookies !=null){
            for (Cookie cookie:cookies){
                String cookieName = cookie.getName();
                if("playids".equals(cookieName)){
                    cookieIds = cookie.getValue();
                    cookieIds = URLDecoder.decode(cookieIds,"UTF-8");
                }
            }
        }
        if(cookieIds !=null){
            idsArrCookie = cookieIds.split(",");
        }

        List<Integer> list=new ArrayList<Integer>();
        cookieIds="";
        if(idsArr !=null) {
            for (String s : idsArr) {
                list.add(Integer.parseInt(s));
                cookieIds = cookieIds + s + ",";
            }
        }
        if(idsArrCookie !=null && !"".equals(idsArrCookie)){
            for(String s: idsArrCookie){
                Integer sid = new Integer(s);
                boolean exists = false;
                for(Integer i :list){
                    if(sid.equals(i)){
                        exists = true;
                        break;
                    }
                }
                if(!exists){
                    list.add(sid);
                    cookieIds = cookieIds + s+",";
                }
            }
        }
        List<Song> songs = songService.selectSongBySids(list);

        cookieIds = URLEncoder.encode(cookieIds,"UTF-8");
        Cookie cookie = new Cookie("playids",cookieIds);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        model.addAttribute("songs",songs);
        return "player";
    }

    @RequestMapping(value = "getSong",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String search(Integer sid, Model model){
//    model.addAttribute("song",songService.selectByPrimaryKey(sid));
        Song song = songService.selectByPrimaryKey(sid);
        return JSON.toJSONString(song);
    }

}

