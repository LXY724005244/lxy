package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.modular.system.model.DTO.JiaoAnDTO;
import com.stylefeng.guns.modular.system.model.Jiaoan;
import com.stylefeng.guns.modular.system.model.Tag;
import com.stylefeng.guns.modular.system.service.IJiaoanService;
import com.stylefeng.guns.modular.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
@RequestMapping("/jiaoan")
public class JiaoanController  {
    protected static String SUCCESS = "SUCCESS";
    protected static String ERROR = "ERROR";
    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";
    private static String PREFIX = "/system/jiaoan/";
    @Autowired
    private IJiaoanService jiaoanService;
    @RequestMapping("/addja")
    public String jiaoAn(){

        return PREFIX+"jiaoan.html";
    }

    @RequestMapping("/add_jiaoan")
    public String addJiaoan(){
        return PREFIX+"add_jiaoan.html";
    }

    @RequestMapping("/submitjiaoan")
    @ResponseBody
    public Tip SubmitJiaoan(JiaoAnDTO jadto){
        Jiaoan jiaoan=new Jiaoan();
        jiaoan.setMdMaterial(jadto.getId_input_md());
        String html=HtmlUtils.htmlUnescape(jadto.getId_input_html());
        jiaoan.setHtmlMaterial(html);
        jiaoan.setIntroduction(jadto.getIntroduction());
        jiaoan.setAuthor(jadto.getAuthor());
        jiaoan.setTitle(jadto.getTitle());
        jiaoanService.insert(jiaoan);
     return SUCCESS_TIP;
    }
    @RequestMapping("/jiaoanlist")
    public ModelAndView JiaoanList(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName(PREFIX+"jiaoan_list.html");
        List<Tag> list=jiaoanService.SelectTag();
        modelAndView.addObject("Tag",list);
        return  modelAndView;
    }
}
