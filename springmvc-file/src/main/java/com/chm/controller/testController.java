package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @RequestMapping("/test")
    public String test(){
        int a = 1/0;
        return "seccess";
    }
}
