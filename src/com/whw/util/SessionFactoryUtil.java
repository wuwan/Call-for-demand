package com.whw.util;

import org.hibernate.SessionFactory;

public class SessionFactoryUtil
{
	//sessionFactory是重量级的，一个项目使用一个sessionFactory就可以了
	private static SessionFactory sessionFactory = null;
	private SessionFactoryUtil()
	{
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			sessionFactory = (SessionFactory) ApplicationContextUtil.getApplicationContext().getBean("sessionFactory");
		}
		return sessionFactory;
	}
}
