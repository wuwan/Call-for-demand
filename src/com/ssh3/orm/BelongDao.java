package com.ssh3.orm;

import java.util.List;

import com.ssh.orm.TbBelong;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BelongDao extends HibernateDaoSupport 
{
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<TbBelong> getObjects(String queryString) throws Exception{
		return (List<TbBelong>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<TbBelong> getAllObjects(Class<TbBelong> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	//获取归口管理部门的第一个下拉框
	public List<TbBelong> getBelongs()
	{
		@SuppressWarnings("unchecked")
		List<TbBelong> tb=this.getHibernateTemplate().find("from TbBelong b");
		return tb;
	}
}
