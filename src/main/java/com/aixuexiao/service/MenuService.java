package com.aixuexiao.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aixuexiao.dao.ClassesDao;
import com.aixuexiao.dao.ClassesNewsDao;
import com.aixuexiao.dao.StudentDao;
import com.aixuexiao.model.AccessToken;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ClassesNews;
import com.aixuexiao.model.CommonButton;
import com.aixuexiao.model.ComplexButton;
import com.aixuexiao.model.Menu;
import com.aixuexiao.model.Student;
import com.aixuexiao.util.WeixinUtil;
import com.aixuexiao.web.controller.WeixinController;

import org.apache.log4j.Logger;
@Service("menuService")
public class MenuService {
	private static Logger logger = Logger.getLogger(MenuService.class);
	
	@Resource(name="accessTokenService")
	private AccessTokenService accessTokenService;
	/**
	* 描述:菜单管理器类 </br>
	* 发布版本：V1.0  </br>
	 */
    public void createMenu() {
    	logger.info("["+this.getClass().getName()+"][createMenu][start]");
        // 第三方用户唯一凭证
        String appId = "wx4ca73689bde8aa0d";
        // 第三方用户唯一凭证密钥
        String appSecret = "c9cc9b55e2ae3434247d04af1be62b97";

        // 调用接口获取access_token
        AccessToken at = accessTokenService.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getAccess_token());

            // 判断菜单创建结果
            if (0 == result)
            	logger.info("菜单创建成功！");
            else
            	logger.info("菜单创建失败，错误码：" + result);
        }
        logger.info("["+this.getClass().getName()+"][createMenu][end]");
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private Menu getMenu() {
    	logger.info("["+this.getClass().getName()+"][getMenu][start]");
        CommonButton btn11 = new CommonButton();
        btn11.setName("快乐孕检");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("健康潮流");
        btn12.setType("click");
        btn12.setKey("12");


        CommonButton btn21 = new CommonButton();
        btn21.setName("成长点滴");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("快乐体检");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn31 = new CommonButton();
        btn31.setName("直接咨询");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("了解我们");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("联系我们");
        btn33.setType("click");
        btn33.setKey("33");

        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("辣妈最爱");
        //一级下有2个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12 });

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("萌宝天地");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22 });

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("医学咨询");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new ComplexButton[] { mainBtn1, mainBtn2, mainBtn3 });
        logger.info("["+this.getClass().getName()+"][getMenu][end]");
        return menu;
    }
	
	
}
