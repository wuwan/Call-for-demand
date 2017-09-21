package com.ssh.service;

import java.util.List;

import com.ssh.orm.SysRole;
import com.ssh3.orm.RoleDAOImpl;
import com.ssh.service.RoleServiceImpl;

public class RoleServiceImpl{

	private RoleDAOImpl roleDao;
	
	public RoleDAOImpl getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDAOImpl roleDao) {
		this.roleDao = roleDao;
	}

	public void save(SysRole sr) {
		this.roleDao.save(sr);
	}

	public List<SysRole> findAll() {
		
		return this.roleDao.findAll();
	}

	public void remove(SysRole sr) {
		this.roleDao.remove(sr);
	}

	public void update(SysRole sr) {
		this.roleDao.update(sr);
	}

	public SysRole findByName(String name) {
		
		return this.roleDao.findByName(name);
	}
    
	public List<SysRole> findByLoginUserId(String id) {
		String hql="select distinct r from com.ssh.orm.TbAdministrator u join u.sysRole r join r.sysRight m where u.number = '"+id+"'";
		return roleDao.findByHql(hql);
	}
}
