package com.ssh.service;
import java.util.List;

import com.ssh3.orm.UserDAOImpl;
import com.ssh.service.UserServiceImpl;
import com.ssh.orm.TbAdministrator;

public class UserServiceImpl<T>{
	private UserDAOImpl userDao;
	
	public UserDAOImpl getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDAOImpl userDao)
	{
		this.userDao = userDao;
	}

	public void save(TbAdministrator user) {
		this.userDao.saveUser(user); 
	}
	
	public List<TbAdministrator> findAll() {
		return this.userDao.findAllUsers();
	}
	
	public void delete(TbAdministrator user) {
		this.userDao.removeUser(user);
	}
	public void update(TbAdministrator user) {
		this.userDao.updateUser(user);
	}
	public TbAdministrator findByName(String name) {
		return this.userDao.findByName(name);
	}
	
	public String loginUser(String username,String password,TbAdministrator suser) {
		if(this.userDao.loginUser(username,password)!=null)
		{
			return "C";
		}
		else
			return null;
	}
	
	public TbAdministrator getloginUser(String username, String password) {
		return userDao.loginUser(username, password);
	}
	
	public List<TbAdministrator> queryUsers(String Account,Class<TbAdministrator> clazz) throws Exception{
		if(Account == null || "".equals(Account))
			return userDao.getAllObjects(clazz);
		String queryString = "SELECT u FROM TbAdministrator u WHERE u.account like '"+Account+"%'";
		return userDao.getObjects(queryString);
	}
	
	public void addUser(T user) throws Exception{
		userDao.addObject(user);
	}
	
	public void modifyUser(T user) throws Exception{
		userDao.updateObject(user);
	}
	
	public void deleteUser(int zzbm,Class<T> clazz) throws Exception{
		T u = userDao.getObject(clazz, zzbm);
		userDao.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getUser(Class<TbAdministrator> class1, String zzbm){
		return (T) userDao.getObject(class1, zzbm);
	}
	
}