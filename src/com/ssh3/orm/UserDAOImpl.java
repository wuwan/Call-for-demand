package com.ssh3.orm;
import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh3.orm.UserDAOImpl;
import com.ssh.orm.TbAdministrator;

public class UserDAOImpl extends HibernateDaoSupport{
	public void saveUser(TbAdministrator user) {
		this.getHibernateTemplate().save(user);
	}
	@SuppressWarnings("unchecked")
	public List<TbAdministrator> findAllUsers() {
		String hql = "from TbAdministrator user";
		return (List<TbAdministrator>) this.getHibernateTemplate().find(hql);
	}

	public void removeUser(TbAdministrator user) {
		this.getHibernateTemplate().delete(user);
	}
	public void updateUser(TbAdministrator user) {
		this.getHibernateTemplate().update(user);
	}
	public TbAdministrator findByName(String name) {
		TbAdministrator user = (TbAdministrator) this.getHibernateTemplate().get(TbAdministrator.class, name);

		return user;
	}
	@SuppressWarnings("unchecked")
	public TbAdministrator loginUser(String username,String password) {
		String hql = "from TbAdministrator user where user.account='"
				+ username + "' and user.password='"
				+ password + "'";
		List<TbAdministrator> users = (List<TbAdministrator>) this.getHibernateTemplate().find(hql);
		if (users.size() > 0) {
			return users.get(0);
		}else{
			return null;
		}
	}
	
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<TbAdministrator> getObjects(String queryString) throws Exception{
		return (List<TbAdministrator>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<TbAdministrator> getAllObjects(Class<TbAdministrator> clazz){
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
}




