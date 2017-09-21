package com.ssh.service;

import java.util.List;

import com.ssh.orm.Guanli;
import com.ssh3.orm.GuanliDao;

public class GuanliService
{
	private GuanliDao guanli;
	
	public GuanliDao getGuanli()
	{
		return guanli;
	}

	public void setGuanli(GuanliDao guanli)
	{
		this.guanli = guanli;
	}

	//获取管理处室的下拉框
	public List<Guanli> getSelectGuanli()
	{
		return guanli.getGuanlis();
	}
	
	 public List<Guanli> query(Class<Guanli> clazz) throws Exception{	
			return guanli.getGuanlis();
	 }
}
