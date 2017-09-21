package com.ssh3.orm;

import java.util.List;

import com.ssh.orm.TbArea;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AreaDao extends HibernateDaoSupport 
{
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<TbArea> getObjects(String queryString) throws Exception{
		return (List<TbArea>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<TbArea> getAllObjects(Class<TbArea> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	//获取归口管理部门的第一个下拉框
	public List<TbArea> getAreas()
	{
		@SuppressWarnings("unchecked")
		List<TbArea> ta=this.getHibernateTemplate().find("from TbArea a");
		return ta;
	}
}
