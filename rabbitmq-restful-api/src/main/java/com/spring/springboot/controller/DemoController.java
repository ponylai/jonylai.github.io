package com.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.springboot.sender.Sender;


/**
 * Created by 男孩的天职 on 2016/11/14.
 */
@Controller
public class DemoController {
    @Autowired
    private Sender sender;


    @RequestMapping("/")
    @ResponseBody
    public  String hello() throws Exception {
        for(int i=0;i<10;i++){
            sender.send(i+1);
        }
          return "ok";
    }
}
