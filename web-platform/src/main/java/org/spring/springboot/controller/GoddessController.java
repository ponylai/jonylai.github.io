package org.spring.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class GoddessController {

   
    @RequestMapping(value = "/toGoddess")
    public String toVideo() {
        return "goddess";
    }
    
    @RequestMapping(value = "/selectGoddess")
    public String SelectVideo() {
        return "goddessRepertory";
    }
    
}
