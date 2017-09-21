package com.ssh3.orm;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.orm.TbNeed;

public class needDao extends HibernateDaoSupport {
	private SessionFactory sessionFactory;
	


	/**查询*/
	@SuppressWarnings("unchecked")
	public List<TbNeed> getObjects(String queryString) throws Exception{
		return (List<TbNeed>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<TbNeed> getAllObjects(Class<TbNeed> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	
	/**添加一个*/
	public <T> void addObject(T clazz){
		this.getHibernateTemplate().save(clazz);
	}
	
	/**更新指定的*/
	public <T> void updateObject(T clazz){
		this.getHibernateTemplate().update(clazz);
	}

	/**删除指定的*/
	public <T> void deleteObject(T clazz){
		this.getHibernateTemplate().delete(clazz);
	}
	
	/**通过zzbm获取*/
	public <T> T getObject(Class<T> clazz,Serializable zzbm){
		return this.getHibernateTemplate().get(clazz, zzbm);
		
	}
	
	
	//根据查询条件来获取数据
	@SuppressWarnings("unchecked")
	public List<TbNeed> getData(String hql)
	{
		// TODO Auto-generated method stub
		Session session =  this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = null;
		List<TbNeed> requirementList = null;
		try
		{
			query = session.createQuery(hql);
			requirementList = (List<TbNeed>)query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//这个session不能关
		session.close();
		return requirementList;
	}
}

