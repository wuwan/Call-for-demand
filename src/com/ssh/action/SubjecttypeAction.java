package com.ssh.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.TbNeed;
import com.ssh.service.SubjecttypeService;
import com.ssh.service.needService;
import com.whw.util.CommonUtil;

public class SubjecttypeAction
{
	private SubjecttypeService typeservice;
	private needService<TbNeed> needService;
	
	public SubjecttypeService getTypeservice()
	{
		return typeservice;
	}
	public void setTypeservice(SubjecttypeService typeservice)
	{
		this.typeservice = typeservice;
	}
	public void setNeedService(needService<TbNeed> needService)
	{
		this.needService = needService;
	}
	public String execute()
	{
		//request对象获取action
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			//ajax向后台传递数据的时候会乱码    设置request的编码格式不行
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String action = request.getParameter("action");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(action == null)
		{
			return null;
		}
		else
		{
			System.out.println("IndustryAction里面获取的action   "+action);
			switch(action)
			{
				case "oneIndustry":
					String strTem=typeservice.getOneIndustry();
					System.out.println("后台获取到的字符串为："+strTem);
					out.print(typeservice.getOneIndustry());
					break;
				case "twoIndustry":
					String oneIndustry = request.getParameter("oneIndustry");
					out.print(typeservice.getTwoIndustry(oneIndustry));
					break;
				case "threeIndustry":
					String twoIndustry = request.getParameter("twoIndustry");
					out.print(typeservice.getThreeIndustry(twoIndustry));
					break;
				case "search":
					String industry = CommonUtil.changeCode(request.getParameter("industry"));
					String searchCon = CommonUtil.changeCode(request.getParameter("searchCon"));
					System.out.println("search  industry"+industry+"  "+searchCon);
					System.out.println("两个参数"+industry+"    "+searchCon);
					request.setAttribute("requirementList", needService.getData(industry, searchCon));
					//out.write(needService.getData(industry.substring(0, industry.length()-1), searchCon.substring(0, industry.length()-1)));
					return "success";
			}
		}
		return null;
	}
}
