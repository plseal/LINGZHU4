package com.aixuexiao.web.controller;


import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.AccessToken;
import com.aixuexiao.service.AccessTokenService;
import com.aixuexiao.service.ManagerService;
import com.aixuexiao.service.MenuService;
import com.aixuexiao.util.WeixinUtil;

/**
 * Menu管理
 */
@Controller
public class ManagerController {
	
	private static Logger logger = Logger.getLogger(MenuService.class);
	
	@Resource(name="managerService")
	private ManagerService managerService;

	@Resource(name="accessTokenService")
	private AccessTokenService accessTokenService;
	
	
	@Value("#{setting[APPID]}")
	private String strAPPID; 
	
	@Value("#{setting[APPSECRET]}")
	private String strAPPSECRET; 
	
	@RequestMapping(value="/manager/get-access-token",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView get_access_token() throws FileNotFoundException, IOException{
		
		logger.info("["+this.getClass().getName()+"][get_access_token][start]"); 
		ModelAndView mv=new ModelAndView();
        // 调用接口获取access_token
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPID]"+strAPPID);
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPSECRET]"+strAPPSECRET);
		//String tmp = PropertiesUtil.getProperties();
        AccessToken at = accessTokenService.getAccessToken(strAPPID, strAPPSECRET);
        logger.info("["+this.getClass().getName()+"][get_access_token][accessToken]"+at.getAccess_token());
        
        mv.setViewName("result");
        mv.addObject("strResult", at.getAccess_token());
		//mv.addObject("sidebar","classes");
		logger.info("["+this.getClass().getName()+"][get_access_token][end]"); 
		return mv;
	}

	

	
}
