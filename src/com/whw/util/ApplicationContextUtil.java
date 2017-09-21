package com.whw.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil
{
	//使用单例模式来获取ApplicationContext的对象
	private static ApplicationContext ac = null;
	
	private ApplicationContextUtil()
	{
		
	}
	
	public static ApplicationContext getApplicationContext()
	{
		if(ac == null)
		{
			ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return ac;
	}
	
}
