package com.aixuexiao.web.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ClassesNews;
import com.aixuexiao.model.CommonButton;
import com.aixuexiao.model.ComplexButton;
import com.aixuexiao.model.Menu;
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
	
	@Value("#{setting[APPID]}")
	private String strAPPID; 
	
	@Value("#{setting[APPSECRET]}")
	private String strAPPSECRET; 
	
	@Value("#{setting[mainBtn1Name]}")
	private String mainBtn1Name; 
	
	@Value("#{setting[mainBtn2Name]}")
	private String mainBtn2Name; 
	
	@Value("#{setting[mainBtn3Name]}")
	private String mainBtn3Name; 
	
	@Value("#{setting[btn11Name]}")
	private String btn11Name; 
	
	@Value("#{setting[btn12Name]}")
	private String btn12Name;
	
	@Value("#{setting[btn13Name]}")
	private String btn13Name;
	
	@Value("#{setting[btn14Name]}")
	private String btn14Name;
	
	@Value("#{setting[btn15Name]}")
	private String btn15Name; 
	
	@Value("#{setting[btn21Name]}")
	private String btn21Name; 
	
	@Value("#{setting[btn22Name]}")
	private String btn22Name;
	
	@Value("#{setting[btn23Name]}")
	private String btn23Name;
	
	@Value("#{setting[btn24Name]}")
	private String btn24Name;
	
	@Value("#{setting[btn25Name]}")
	private String btn25Name; 
	
	@Value("#{setting[btn31Name]}")
	private String btn31Name; 
	
	@Value("#{setting[btn32Name]}")
	private String btn32Name;
	
	@Value("#{setting[btn33Name]}")
	private String btn33Name;
	
	@Value("#{setting[btn34Name]}")
	private String btn34Name;
	
	@Value("#{setting[btn35Name]}")
	private String btn35Name; 
	
	@RequestMapping(value="/manager/create-menu",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView createMenu(){
		
		logger.info("["+this.getClass()+"][createMenu][start]");
		
		
		Menu menu = getMenu();
		
		ModelAndView mv=new ModelAndView();
		menuService.createMenu(menu,strAPPID,strAPPSECRET);
        mv.setViewName("result");
        mv.addObject("strResult", "create Menu successed!");
		
		logger.info("["+this.getClass().getName()+"][createMenu][end]"); 
		return mv;
	}
	
	
    /**
     * 组装菜单数据
     * 
     * @return
     */
    private Menu getMenu() {

    	
    	logger.info("["+this.getClass().getName()+"][getMenu][start]");
        CommonButton btn11 = new CommonButton();
        btn11.setName(btn11Name);
        btn11.setType("view");
        btn11.setKey("11");
        btn11.setUrl("http://www.plseal.com/Blog/index.html");

        CommonButton btn12 = new CommonButton();
        btn12.setName(btn12Name);
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName(btn13Name);
        btn13.setType("click");
        btn13.setKey("13");
        
        CommonButton btn14 = new CommonButton();
        btn14.setName(btn14Name);
        btn14.setType("click");
        btn14.setKey("14");
        
        CommonButton btn15 = new CommonButton();
        btn15.setName(btn15Name);
        btn15.setType("click");
        btn15.setKey("15");

        CommonButton btn21 = new CommonButton();
        btn21.setName(btn21Name);
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName(btn22Name);
        btn22.setType("click");
        btn22.setKey("22");
        
        CommonButton btn23 = new CommonButton();
        btn23.setName(btn23Name);
        btn23.setType("click");
        btn23.setKey("23");
        
        CommonButton btn24 = new CommonButton();
        btn24.setName(btn24Name);
        btn24.setType("click");
        btn24.setKey("24");
        
        CommonButton btn25 = new CommonButton();
        btn25.setName(btn25Name);
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName(btn31Name);
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName(btn32Name);
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName(btn33Name);
        btn33.setType("click");
        btn33.setKey("33");

        CommonButton btn34 = new CommonButton();
        btn34.setName(btn34Name);
        btn34.setType("click");
        btn34.setKey("34");
        
        CommonButton btn35 = new CommonButton();
        btn35.setName(btn35Name);
        btn35.setType("click");
        btn35.setKey("35");
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName(mainBtn1Name);
        //一级下有2个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14, btn15 });

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName(mainBtn2Name);
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName(mainBtn3Name);
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33, btn34, btn35 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new ComplexButton[] { mainBtn1, mainBtn2, mainBtn3 });
        logger.info("["+this.getClass().getName()+"][getMenu][end]");
        return menu;
    }

	

	
}
