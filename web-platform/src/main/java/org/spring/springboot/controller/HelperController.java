package org.spring.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by jony.lai on 07/02/2017.
 */
@Controller
public class HelperController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
   
    @RequestMapping(value = "/helper")
    public String ToIndex() {
        return "help";
    }
    
    // 测试使用
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String toCity() {
    	log.info("dd");
        return "city";
    }
}
