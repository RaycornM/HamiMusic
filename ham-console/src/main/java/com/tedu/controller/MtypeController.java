package com.tedu.controller;

import com.tedu.model.Mtype;
import com.tedu.query.MtypeQuery;
import com.tedu.service.MtypeService;
import com.tedu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mtype")
public class MtypeController {

    @Autowired
    private MtypeService mtypeService;


    /**
     * 条件分页查询流派信息
     * @param mq
     * @param model
     * @return
     */
    @RequestMapping("list")  //hhtp://locahost:8089/index
    public String list(MtypeQuery mq,Model model){
//        //为了程序的严谨性
        if(mq.getPageNo() == null){
            mq.setPageNo(1);
        }

        Integer pageNo = mq.getPageNo();
//        //1,根据条件查询到所有的mtype数据并且分页        2,把数据传到前端页面
//        //查询分页的数据
        PageUtil<Mtype> page = mtypeService.selectByConditionPage(mq);
//        //把page对象发给页面
        model.addAttribute("page", page);
//        //把查询条件也要回显
        model.addAttribute("mq", mq);
//       //具体的展现业务还没做
//        //查询所有的流派信息  mtype的业务层service
//        //Page<T> selectByConditionPage(Q q);
//        //Page<Mtype> mtypePage = mtypeService.selectByConditionPage(query);
       return "mtype";   //WEB-INF/PAGE/mtype.jsp
    }


    /**
     * 添加流派
     * @param mtype
     * @return
     */
    @ResponseBody
    @RequestMapping("addMtype")
    public String addMtype(Mtype mtype){
        int insert = mtypeService.insert(mtype);
        return "success";   //WEB-INF/PAGE/mtype.jsp
    }


    /**
     * 修改前的回显数据
     * @param tid
     * @return
     */
    @ResponseBody
    @RequestMapping("selectMtype")
    public Mtype getMtype(int tid){
        Mtype mtype = mtypeService.selectByPrimaryKey(tid);
        return mtype;
    }


    /**
     * 修改数据
     * @param mtype
     * @return
     */
    @ResponseBody
    @RequestMapping("updateMtype")
    public String updateMtype(Mtype mtype){
        int i = mtypeService.updateByPrimaryKeySelective(mtype);
        return "success";
    }


    /**
     * 删除流派信息
     *
     */
    @ResponseBody
    @RequestMapping("delMtype")
    public String delMtype(int tid){
        int i = mtypeService.deleteByPrimaryKey(tid);
        return "success";
    }
}
