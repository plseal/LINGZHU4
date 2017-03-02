package com.aixuexiao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aixuexiao.model.AccessToken;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.Student;

@Component("accessTokenDao")
public class AccessTokenDao extends BaseDao {

	
	public AccessToken getAccessToken(int id) {
		return this.readSqlSession.selectOne("com.aixuexiao.dao.AccessTokenDao.getAccessToken",id);
	}
	
	public void updateAccessToken(AccessToken accessToken){
		writerSqlSession.update("com.aixuexiao.dao.AccessTokenDao.updateAccessToken", accessToken);
	}
}
