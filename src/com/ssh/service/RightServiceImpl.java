package com.ssh.service;

import java.util.List;

import com.ssh3.orm.RightDAOImpl;
import com.ssh.orm.SysRight;
import com.ssh.service.RightServiceImpl;

public class RightServiceImpl{

	private RightDAOImpl rightDao;

	public RightDAOImpl getRightDao()
	{
		return rightDao;
	}

	public void setRightDao(RightDAOImpl rightDao)
	{
		this.rightDao = rightDao;
	}

	public void save(SysRight srt) {
		this.rightDao.save(srt);
	}

	public List<SysRight> findAll() {
		// TODO Auto-generated method stub
		return this.rightDao.findAll();
	}

	public void remove(SysRight srt) {
		this.rightDao.remove(srt);
		
	}
	
	public void update(SysRight srt) {
		this.rightDao.update(srt);
	}

	public List<SysRight> findByLoginUserId(String id) {
		System.out.println(id);
		String hql="select distinct m from TbAdministrator u " +
				"join u.sysRole r join r.sysRight m where u.number = '"+id+"'";
		return rightDao.findByHql(hql);
	}
}
