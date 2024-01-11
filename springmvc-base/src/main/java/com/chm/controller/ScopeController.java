package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ScopeController {
    @RequestMapping("/scope/mav")
    public ModelAndView mavTest(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","使用ModelAndView向请求域中共享数据");
        mav.setViewName("seccess");
        return mav;
    }
    @RequestMapping("/scope/model")
    public String modelTest(Model model){
        model.addAttribute("msg","使用Model向请求域中共享数据");
         return "seccess";
    }
    @RequestMapping("/scope/modelmap")
    public String modelTest(ModelMap modelMap){

        modelMap.addAttribute("msg","使用Modelmap向请求域中共享数据");
        return "seccess";
    }
    @RequestMapping("/scope/map")
    public String modelTest(Map<String, Object> modelMap){
        System.out.println(modelMap.getClass().getName());
        modelMap.put("msg","使用map向请求域中共享数据");
        return "seccess";
    }
}
