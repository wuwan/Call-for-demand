package com.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.SysRight;
import com.ssh.service.RightServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RightAction extends ActionSupport{

	private SysRight st;
	private List<SysRight> sts;
	private RightServiceImpl rightService;
	
	public SysRight getSt()
	{
		return st;
	}
	public void setSt(SysRight st)
	{
		this.st = st;
	}
	public List<SysRight> getSts()
	{
		return sts;
	}
	public void setSts(List<SysRight> sts)
	{
		this.sts = sts;
	}
	
	public RightServiceImpl getRightService() {
		return rightService;
	}
	public void setRightService(RightServiceImpl rightService) {
		this.rightService = rightService;
	}
	
	public String updateRole() {
		this.rightService.update(st);
		return "updateRight";
	}
	
	public String addRight() throws Exception{
		
		this.rightService.save(this.st);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("st", this.st);
		return "addRight";
	}
	public String showRight() throws Exception {
		this.sts=this.rightService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("sts", this.sts);
		return "showRight";
	}
}
