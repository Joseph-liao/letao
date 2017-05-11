package com.letao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO(分页控制controller)
 * @author 廖永乐
 * @Date 2017年3月24日 上午8:40:36
 * @version 1.0.0
 */
@Controller
public class PageController {

	/**
	 * 
	 * @Description (打开首页)
	 * @return
	 */
	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 
	 * @Description (显示其他页面)
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
	    return page;
	}
	
	

}
