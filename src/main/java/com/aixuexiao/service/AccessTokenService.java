package com.aixuexiao.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aixuexiao.dao.AccessTokenDao;
import com.aixuexiao.dao.ClassesDao;
import com.aixuexiao.dao.ExamDao;
import com.aixuexiao.dao.StudentDao;
import com.aixuexiao.dao.StudentMessageDao;
import com.aixuexiao.model.AccessToken;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ExamMark;
import com.aixuexiao.model.Student;
import com.aixuexiao.model.StudentMessage;
import com.aixuexiao.util.WeixinUtil;

@Service("accessTokenService")
public class AccessTokenService {
	
	private static Logger logger = Logger.getLogger(AccessTokenService.class);
	
	@Resource(name="accessTokenDao")
	private AccessTokenDao accessTokenDao;
	
	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public AccessToken getAccessToken(String appid, String appsecret) {
		
		logger.info("["+this.getClass().getName()+"][getAccessToken][start]");
		AccessToken accessToken = null;
		
		//先从DB查找accessToken，存在并且没有过期的话，就不用去微信官方服务器取了
		accessToken = accessTokenDao.getAccessToken(1);

		//int _in = Integer.parseInt(accessToken.getExpires_in());
		long create_time = accessToken.getCreate_time();
		//7200秒有效，保险起见3600秒刷新一次
		if ((System.currentTimeMillis()-create_time)/1000 < 3600) {// 有效
			logger.info("["+this.getClass().getName()+"][getAccessToken][Get From URL is not necessary]");
			
		//过期的话，需要去微信官方服务器再取一次
		} else {
			//System.out.println("无效重新创建");

			accessToken = WeixinUtil.getAccessTokenFromURL(appid, appsecret);
			Map map2 = new HashMap();
			accessToken.setCreate_time(System.currentTimeMillis());
			
			accessTokenDao.updateAccessToken(accessToken);//更新数据库
		}
		
		logger.info("["+this.getClass().getName()+"][getAccessToken][end]");
		return accessToken;
	}

	
}
