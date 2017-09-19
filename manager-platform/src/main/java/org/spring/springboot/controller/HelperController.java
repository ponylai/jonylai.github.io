package org.spring.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class HelperController {

   
    @RequestMapping(value = "/helper")
    public String ToIndex() {
        return "help";
    }
}
