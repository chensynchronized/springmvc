package com.chm.controller;

import com.chm.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class paramController {
    @RequestMapping("/seccess")
    public String params(@RequestBody String user) {
        System.out.println(user);
        return "seccess";
    }
}
