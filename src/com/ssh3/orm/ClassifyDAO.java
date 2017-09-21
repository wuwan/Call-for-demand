package com.ssh3.orm;

import java.util.List;

import com.ssh.orm.Subjecttype;
import com.ssh.orm.Xueke;
import com.ssh3.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class ClassifyDAO extends HibernateDaoSupport 
{
	//获取国民经济行业的第一个下拉框
	public List<Subjecttype> getFirstGmjjhys()
	{
		@SuppressWarnings("unchecked")
		List<Subjecttype> gm=this.getHibernateTemplate().find("from Subjecttype g where g.code like '%0000'");
		return gm;
	}
	
	//获取国民经济行业的第二个下拉框
	public List<Subjecttype> getSecondGmjjhys(String secondCode)
	{
		@SuppressWarnings("unchecked")
		List<Subjecttype> gm= this.getHibernateTemplate().find("from Subjecttype g where g.code like '"+secondCode.substring(0, 1)+"%00'");
		return gm;
	}
	
	//获取国民经济行业的第三个下拉框
	public List<Subjecttype> getThirdGmjjhys(String thirdCode)
	{
		@SuppressWarnings("unchecked")
		List<Subjecttype> gm=this.getHibernateTemplate().find("from Subjecttype g where g.code like '"+thirdCode.substring(0, 3)+"%'");
	    return gm;
	}
	
	//获取学科分类第一个下拉框
	public List<Xueke> getFirstXkfls()
	{
		@SuppressWarnings("unchecked")
		List<Xueke> cl=this.getHibernateTemplate().find("from Xueke c where c.code like '%00000'");
		return cl;
	}

	//获取学科分类的第二个下拉框
	public List<Xueke> getSecondXkfls(String secondXcode)
	{
		@SuppressWarnings("unchecked")
		List<Xueke> cl=this.getHibernateTemplate().find("from Xueke c where c.code like '"+secondXcode.substring(0, 2)+"%00'");
		return cl;
	}

	//获取学科分类的第三个下拉框的值
	public List<Xueke> getThirdXkfls(String thirdXcode)
	{
		@SuppressWarnings("unchecked")
		List<Xueke> cl=this.getHibernateTemplate().find("from Xueke c where c.code like '"+thirdXcode.substring(0, 5)+"%'");
		return cl;
	}

}
