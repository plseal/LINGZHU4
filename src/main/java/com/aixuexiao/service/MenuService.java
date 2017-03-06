package com.aixuexiao.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
@Service("menuService")
public class MenuService {
	private static Logger logger = Logger.getLogger(MenuService.class);
	
	@Resource(name="accessTokenService")
	private AccessTokenService accessTokenService;

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	// 菜单Get（Get） 限100（次/天）
		public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	* 描述:菜单管理器类 </br>
	* 发布版本：V1.0  </br>
	 */
    public void createMenu(Menu menu,String strAPPID,String strAPPSECRET) {
    	logger.info("["+this.getClass().getName()+"][createMenu][start]");

        // 调用接口获取access_token
        AccessToken at = accessTokenService.getAccessToken(strAPPID, strAPPSECRET);

        if (null != at) {
            // 调用接口创建菜单
            int result = createMenu(menu, at.getAccess_token());

            // 判断菜单创建结果
            if (0 == result)
            	logger.info("菜单创建成功！");
            else
            	logger.info("菜单创建失败，错误码：" + result);
        }
        logger.info("["+this.getClass().getName()+"][createMenu][end]");
    }

	/**
	* 描述:菜单管理器类 </br>
	* 发布版本：V1.0  </br>
	 */
    public String getMenu(String strAPPID,String strAPPSECRET) {
    	logger.info("["+this.getClass().getName()+"][getMenu][start]");

        // 调用接口获取access_token
        AccessToken at = accessTokenService.getAccessToken(strAPPID, strAPPSECRET);
        String result = "no result";
        if (null != at) {
            // 调用接口创建菜单
     
    		

    		// 拼装创建菜单的url
    		String url = menu_get_url.replace("ACCESS_TOKEN", at.getAccess_token());
    		// 将菜单对象转换成json字符串
    		//String jsonMenu = JSONObject.fromObject(menu).toString();
    		// 调用接口创建菜单
    		JSONObject jsonObject = WeixinUtil.httpRequest(url, "GET",null);

    		if (null != jsonObject) {

    				result = jsonObject.toString();

    		}
    		
    		
            
        }
        
        logger.info("["+this.getClass().getName()+"][getMenu][end]");
        return result;
    }
    
    
	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public int createMenu(Menu menu, String accessToken) {
		logger.info("["+this.getClass().getName()+"][createMenu][start]");
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 ");
			}
		}
		logger.info("["+this.getClass().getName()+"][createMenu][end]");
		return result;
	}
	
	
}
