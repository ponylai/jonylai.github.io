package org.spring.springboot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.spring.springboot.domain.Wish;
import org.spring.springboot.req.WishReq;
import org.spring.springboot.res.WishRes;
import org.spring.springboot.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** wish
 * @author QQ 375113044
 * 2016.5.8
 */
@Controller
public class WishController{
	
	@Autowired
	private WishService wishService;
	
	/**根据用户名获取会员信息
	 * @return
	 */
	@RequestMapping(value="/api/getAllWish",method = RequestMethod.GET)
	@ResponseBody
	public Object findAllWish(){
		WishRes wishRes = new WishRes();
		List<Wish> wishList = wishService.findAllWish();
		wishRes.setWishList(wishList);
		return wishRes;
	}
	
	/**新增心愿
	 * @return
	 */
	@RequestMapping(value="/api/add",method = RequestMethod.POST)
	@ResponseBody
	public WishRes addWish(@RequestBody WishReq wishReq,HttpServletRequest httpServletRequest){
		String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");    
		String code = wishReq.getCode();
		WishRes wishRes = new WishRes();
		Wish wish = new Wish();
	    if(!captchaId.equals(code)){
	    	wishRes.setResultCode("vrifyCodeError");
			wishRes.setResultMsg("验证码错误");
	    }else{
		wish.setColor(wishReq.getColor());
		wish.setContent(wishReq.getContent());
		wish.setCreateTime(new Date());
		wish.setCheckStatus("0");
		wish.setUserId("laiqq");
		Long count = wishService.saveWish(wish);
		if(count!=0){
			wishRes.setResultCode("000000");
			wishRes.setResultMsg("许下心愿了");
			wishRes.setWish(wish);
		}else{
			wishRes.setResultCode("999999");
			wishRes.setResultMsg("心愿飞走了");
		}
	    }
		return wishRes;
	}
	
	/**根据id获取wish
	 * @return
	 */
	@RequestMapping(value="/api/getWish/{id}", method = RequestMethod.GET)
	@ResponseBody
	public WishRes getWishById(@PathVariable("id") Long id){
		WishRes wishRes = new WishRes();
		return wishRes;
	}
	
	/**新增心愿
	 * @return
	 */
	@RequestMapping(value="/api/toAdd")
	public Object toAddWish(){

		return "input";
	}
	
    @RequestMapping(value = "/toWall")
    public String wall() {
        return "wall";
    }
    
    @RequestMapping(value = "/toMyWish")
    public String toMyWish() {
        return "myWish";
    }
}
