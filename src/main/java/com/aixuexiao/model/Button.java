package com.aixuexiao.model;

/**
 * 按钮的基类
 * 菜单项的基类，
 * 所有一级菜单、二级菜单都共有一个相同的属性，那就是name。
 */
public class Button {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}