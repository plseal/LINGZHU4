package com.aixuexiao.web.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ClassesNews;
import com.aixuexiao.model.Student;
import com.aixuexiao.service.ClassesService;
import com.aixuexiao.service.MenuService;

/**
 * Menu管理
 */
@Controller
public class MenuController {
	
	private static Logger logger = Logger.getLogger(MenuService.class);
	
	@Resource(name="menuService")
	private MenuService menuService;
	
	
	@RequestMapping(value="/manager/create-menu",method=RequestMethod.GET)
	@ResponseBody
	public String createMenu(){
		
		logger.info("["+this.getClass().getName()+"][createMenu][start]"); 
		//ModelAndView mv=new ModelAndView();
		menuService.createMenu();
		//mv.setViewName("classes");
		//mv.addObject("sidebar","classes");
		logger.info("["+this.getClass().getName()+"][createMenu][end]"); 
		return "create menu successed!";
	}

	

	
}
