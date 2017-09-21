package com.ssh3.orm;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh3.orm.RoleDAOImpl;
import com.ssh.orm.SysRole;

public class RoleDAOImpl extends HibernateDaoSupport{


	public void save(SysRole sr) {
		this.getHibernateTemplate().save(sr);
	}
	@SuppressWarnings("unchecked")

	public List<SysRole> findAll() {
		String hql = "from SysRole sr";
		return (List<SysRole>) this.getHibernateTemplate().find(hql);
	}

	public void remove(SysRole sr) {
		this.getHibernateTemplate().delete(sr);
	}

	public void update(SysRole sr) {
		this.getHibernateTemplate().update(sr);
	}

	@SuppressWarnings("unchecked")
	public List<SysRole> findByHql(String hql, Object... objects) {
		
		return (List<SysRole>) this.getHibernateTemplate().find(hql,objects);
	}
	
	public SysRole findByName(String name) {
		SysRole sr = (SysRole) this.getHibernateTemplate().get(SysRole.class, name);
		return sr;
	}
}
