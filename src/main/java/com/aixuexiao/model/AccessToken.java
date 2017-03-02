package com.aixuexiao.model;

import java.sql.Time;

/**
 * 微信通用接口凭证
 * 
 */
public class AccessToken {
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	// ID
	private Integer id;
	// 获取到的凭证
	private String access_token;
	
	private Long create_time;
	// 凭证有效时间，单位：秒
	private int expires_in;

	
}