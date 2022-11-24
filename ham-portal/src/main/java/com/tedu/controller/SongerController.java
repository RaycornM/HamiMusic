package com.tedu.controller;

import com.tedu.model.Mtype;
import com.tedu.model.Songer;
import com.tedu.query.SongerQuery;
import com.tedu.service.MtypeService;
import com.tedu.service.SongerService;
import com.tedu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("songer")


public class SongerController {
    @Autowired
    SongerService songerService;
    @Autowired
    MtypeService mtypeService;

    @RequestMapping("list")
    public String list(SongerQuery songerQuery, Model model){
        if (songerQuery.getPageNo() == null){
            songerQuery.setPageNo(1);
        }
        songerQuery.setPageSize(20);
        PageUtil<Songer> pages = songerService.selectByConditionPage(songerQuery);
        List<Songer> list = pages.getList();
        ArrayList<List<Songer>> slist = new ArrayList<>();
        List <Songer> subList=null;
        for(int i=0;i<list.size();i++){
            if (i%5 ==0){
                subList=new ArrayList<Songer>();
                slist.add(subList);
            }
            Songer songer = list.get(i);
            subList.add(songer);
        }
        model.addAttribute("sList",slist);
        model.addAttribute("page",pages);
        model.addAttribute("mq",songerQuery);
        List<Mtype> mtypes = mtypeService.selectobj();
        model.addAttribute("mtypes",mtypes);
        return "songers";
    }
    @RequestMapping("getSonger")
    public String getsonger(Integer srId,Model model){
        Songer songer = songerService.selectB(srId);
//        songer.getPic();
        model.addAttribute("songer",songer);
        return "songer";
    }
}
