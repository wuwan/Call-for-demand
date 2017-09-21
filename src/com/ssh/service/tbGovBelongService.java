package com.ssh.service;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssh3.orm.tbGovBelongDao;
import com.ssh.orm.TbGovBelong;
import com.opensymphony.xwork2.ActionContext;

public class tbGovBelongService<T> {
	
private static final ServletRequest session = null;
private tbGovBelongDao base;
//HttpServletRequest servletRequest;
    public List<TbGovBelong> querytbGovBelongs(String jsname,Class<TbGovBelong> clazz) throws Exception{
    	String number=(String) ActionContext.getContext().getSession().get("zzbm");
        String state="已通过";
		if(jsname == null || "".equals(jsname))
		{		
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+number+"' AND  u.state = '"+state+"'";
		    System.out.println(queryString);
			return base.getObjects(queryString);
		}
		String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+number+"' AND  u.state = '"+state+"' AND  u.cborder = '"+jsname+"'";
		return base.getObjects(queryString);
	}
	
    public List<TbGovBelong> querytbGovBelongs1(String jsname,Class<TbGovBelong> clazz) throws Exception{
    	String number=(String) ActionContext.getContext().getSession().get("zzbm");
        String state="待审核";
		if(jsname == null || "".equals(jsname))
		{		
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+number+"' AND  u.state = '"+state+"'";
		    System.out.println(queryString);
			return base.getObjects(queryString);
		}
		String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+number+"' AND  u.state = '"+state+"' AND  u.cborder = '"+jsname+"'";
		return base.getObjects(queryString);
	}
/**********************************形式审核**********************************************/  
    public List<TbGovBelong> querytbGovBelongs2(String zzbm,String state,Class<TbGovBelong> clazz) throws Exception{
		if((zzbm == null || "".equals(zzbm))&&(state == null || "".equals(state)))
		{		
			String queryString = "SELECT u FROM TbGovBelong u";
			return base.getObjects(queryString);
		}
		else if(zzbm == null || "".equals(zzbm))
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.state = '"+state+"'";
			return base.getObjects(queryString);
		}
		else if(state == null || "".equals(state))
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+zzbm+"'";
			return base.getObjects(queryString);
		}
		else
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbid = '"+zzbm+"' AND  u.state = '"+state+"'";
			return base.getObjects(queryString);
		}
	}
    
    /**********************************技术审核**********************************************/  
    public List<TbGovBelong> querytbGovBelongs3(String zzbm,String state1,Class<TbGovBelong> clazz) throws Exception{
    	
    	String guanli=(String) ActionContext.getContext().getSession().get("guanli");
    	System.out.println(guanli);
    	String state="已通过";
    	if((zzbm == null || "".equals(zzbm))&&(state1 == null || "".equals(state1)))
		{		
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbnumber = '"+guanli+"' AND u.state = '"+state+"'";
			return base.getObjects(queryString);
		}
		else if(zzbm == null || "".equals(zzbm))
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbnumber = '"+guanli+"' AND u.state = '"+state+"' AND u.state1 = '"+state1+"'";
			return base.getObjects(queryString);
		}
		else if(state1 == null || "".equals(state1))
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbnumber = '"+guanli+"' AND u.state = '"+state+"' AND u.cbid = '"+zzbm+"'";
			return base.getObjects(queryString);
		}
		else
		{
			String queryString = "SELECT u FROM TbGovBelong u WHERE u.cbnumber = '"+guanli+"' AND u.state = '"+state+"' AND u.cbid = '"+zzbm+"' AND  u.state1 = '"+state1+"'";
			return base.getObjects(queryString);
		}
	}
	
	public void addtbGovBelong(T user) throws Exception{
		base.addObject(user);
	}
	
	public void modifytbGovBelong(T user) throws Exception{
		base.updateObject(user);
	}
	
	public void deletetbGovBelong(String zzbm,Class<TbGovBelong> class1) throws Exception{
		TbGovBelong u = base.getObject(class1, zzbm);
		base.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T gettbGovBelong(Class<TbGovBelong> class1, String jsname){
		return (T) base.getObject(class1, jsname);
	}

	public tbGovBelongDao getBase() {
		return base;
	}

	public void setBase(tbGovBelongDao base) {
		this.base = base;
	}
	
}
