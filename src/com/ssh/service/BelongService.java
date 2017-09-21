package com.ssh.service;

import java.util.List;

import com.ssh.orm.TbBelong;
import com.ssh3.orm.BelongDao;

public class BelongService
{
	private BelongDao belong;

	public BelongDao getBelong()
	{
		return belong;
	}

	public void setBelong(BelongDao belong)
	{
		this.belong = belong;
	}

	//获取管理处室的下拉框
	 public List<TbBelong> query(Class<TbBelong> clazz) throws Exception{	
			return belong.getBelongs();
	 }
}
