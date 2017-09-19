package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by jony.lai on 07/02/2017.
 */
@RestController
public class CityRestController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private CityService cityService;
    
    @Autowired  
    private RestTemplate restTemplate;  
      
        // Restful服务对应的url地址  
    @Value("${user.userServicePath}")  
    private String userServicePath;  
  
    @GetMapping("/template/{id}")  
    public City findById(@PathVariable Long id) {  
    	City u = this.restTemplate.getForObject(this.userServicePath + id, City.class);  
        System.out.println(u);  
        return u;  
    }  
    
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String toCity() {
    	log.info("dd");
        return "city";
    }
    
    @RequestMapping(value = "/api/city/getCity/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
    	log.info("dd");
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city/getCity", method = RequestMethod.GET)
    public List<City> findAllCity() {
    	log.info("dd");
    	log.debug("xxxx");
        return cityService.findAllCity();
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> selectAllCity() {
    	log.info("11");
    	log.debug("22");
        return cityService.findAllCity();
    }


    @RequestMapping(value = "/api/city/postCity", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
    	log.info("dd");
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/putCity", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
    	log.info("dd");
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/deleteCity/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
    	log.info("dd");
        cityService.deleteCity(id);
    }
}
