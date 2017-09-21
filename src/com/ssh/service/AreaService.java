package com.ssh.service;

import java.util.List;

import com.ssh.orm.TbArea;
import com.ssh3.orm.AreaDao;

public class AreaService
{
	private AreaDao area;

	public AreaDao getArea()
	{
		return area;
	}

	public void setArea(AreaDao area)
	{
		this.area = area;
	}

	//获取管理处室的下拉框
	 public List<TbArea> query(Class<TbArea> clazz) throws Exception{	
			return area.getAreas();
	 }
}
