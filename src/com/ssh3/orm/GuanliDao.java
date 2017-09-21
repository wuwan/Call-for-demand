package com.ssh3.orm;

import java.util.List;

import com.ssh.orm.Guanli;
import com.ssh.orm.TbGovBelong;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class GuanliDao extends HibernateDaoSupport 
{
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<Guanli> getObjects(String queryString) throws Exception{
		return (List<Guanli>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<Guanli> getAllObjects(Class<Guanli> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	//获取归口管理部门的第一个下拉框
	public List<Guanli> getGuanlis()
	{
		@SuppressWarnings("unchecked")
		List<Guanli> gl=this.getHibernateTemplate().find("from Guanli b");
		return gl;
	}
}
