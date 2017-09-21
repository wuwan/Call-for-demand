package com.ssh.service;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssh.orm.Reject;
import com.ssh3.orm.rejectDao;
import com.opensymphony.xwork2.ActionContext;

public class rejectService<T> {
	
private static final ServletRequest session = null;
private rejectDao rebase;
//HttpServletRequest servletRequest;
    public List<Reject> queryRejects(String jsname,Class<Reject> clazz) throws Exception{
    	String number=(String) ActionContext.getContext().getSession().get("zzbm");
        String re1="已退回";
		if(jsname == null || "".equals(jsname))
		{		
			String queryString = "SELECT u FROM Reject u WHERE u.RAccount = '"+number+"' AND  u.re1 = '"+re1+"'";
		    System.out.println(queryString);
			return rebase.getObjects(queryString);
		}
		String queryString = "SELECT u FROM Reject u WHERE u.RAccount = '"+number+"' AND  u.re1 = '"+re1+"' AND  u.crorder = '"+jsname+"'";
		return rebase.getObjects(queryString);
	}
	
    public List<Reject> queryRejects1(String jsname,Class<Reject> clazz) throws Exception{
    	String number=(String) ActionContext.getContext().getSession().get("zzbm");
    	String re2="已退回";
		if(jsname == null || "".equals(jsname))
		{		
			String queryString = "SELECT u FROM Reject u WHERE u.RAccount = '"+number+"' AND  u.re2 = '"+re2+"'";
		    System.out.println(queryString);
			return rebase.getObjects(queryString);
		}
		String queryString = "SELECT u FROM Reject u WHERE u.RAccount = '"+number+"' AND  u.re2 = '"+re2+"' AND  u.crorder = '"+jsname+"'";
		return rebase.getObjects(queryString);
	}
	
	public void addReject(T user) throws Exception{
		rebase.addObject(user);
	}
	
	public void modifyReject(T user) throws Exception{
		rebase.updateObject(user);
	}
	
	public void deleteReject(int zzbm,Class<Reject> class1) throws Exception{
		Reject u = rebase.getObject(class1, zzbm);
		rebase.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getReject(Class<Reject> class1, String cborder){
		return (T) rebase.getObject(class1, cborder);
	}

	public rejectDao getRebase()
	{
		return rebase;
	}

	public void setRebase(rejectDao rebase)
	{
		this.rebase = rebase;
	}

}
