package com.chm.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("/file/down")
    public ResponseEntity<byte[]> DownFile(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("static");
        realPath=realPath+ File.separator+"1.jpg";
        System.out.println(realPath);
        InputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, status);
        return responseEntity;


    }
    @RequestMapping("/file/up")
    public String UpFile(MultipartFile photo,HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");
        String originalFilename = photo.getOriginalFilename();
        String hzName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String fileName = realPath+File.separator+uuid+hzName;
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        photo.transferTo(new File(fileName));

        System.out.println(fileName);
        return "seccess";
    }
}
