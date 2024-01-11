package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody
public class RequestMappingController {
    /**
     * ant风格的路径
     * ？单个任意字符
     * * 任意数量的任意字符
     * ** 任意层级的路径，**两侧必须为/，不能有别的字符
     */

    @RequestMapping("/a/?")
    public String Ant(){
        return "hello";
    }
    @RequestMapping("/a/*/b")
    public String Ant2(){
        return "hello";
    }
    @RequestMapping("/a/**")
    public String Ant3(){
        return "hello";
    }
    @RequestMapping("/rest/{username}/{password}")
    public String Rest(@PathVariable("username") String username,@PathVariable("password") String password){
        if ("123456".equals(password)){
            System.out.println("登陆成功");
            return "seccess";
        }
        return "hello";
    }

}
