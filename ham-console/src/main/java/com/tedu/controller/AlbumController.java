package com.tedu.controller;

import com.tedu.model.Album;
import com.tedu.model.Mtype;
import com.tedu.query.AlbumQuery;
import com.tedu.service.AlbumService;
import com.tedu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理专辑的控制层类
 */
@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("dofindAll")
    public String doFindAll(AlbumQuery aq,Model model){
//        //为了程序的严谨性
        if(aq.getPageNo() == null){
            aq.setPageNo(1);
        }
//        //1,根据条件查询到所有的mtype数据并且分页        2,把数据传到前端页面
//        //查询分页的数据
        PageUtil<Album> page = albumService.selectByConditionPage(aq);
//        //把page对象发给页面
        model.addAttribute("page", page);
//        //把查询条件也要回显
        model.addAttribute("album", aq);
//       //具体的展现业务还没做
//        //查询所有的流派信息  mtype的业务层service
//        //Page<T> selectByConditionPage(Q q);
//        //Page<Mtype> mtypePage = mtypeService.selectByConditionPage(query);
        return "album";
    }

    @ResponseBody
    @RequestMapping("addAlbum")
    public String addAblum(Album album){
        albumService.insert(album);
        return "success";
    }

    @ResponseBody
    @RequestMapping("isSname")
    public String isSameName(String aname){
        //调用业务层去数据库查询有没有该数据
       Map<String,String> map=new HashMap<>();
       map.put("aname", aname);
        List<Album> albums = albumService.selectAlbumByName(map);
        String flag="false";
        if(albums.size()>0){
            flag="true";
        }
        return flag;
    }

}
