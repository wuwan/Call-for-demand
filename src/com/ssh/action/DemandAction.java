package com.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.service.DemandServiceImpl;
import com.ssh.orm.TbGovBelong;

@SuppressWarnings("serial")
public class DemandAction extends ActionSupport {
	private TbGovBelong demand=new TbGovBelong();
	private List<TbGovBelong> showdemand;
	private List<TbGovBelong> demands;

	private DemandServiceImpl demandService;
	private String message;
	
	public TbGovBelong getDemand()
	{
		return demand;
	}
	public void setDemand(TbGovBelong demand)
	{
		this.demand = demand;
	}
	public List<TbGovBelong> getShowdemand()
	{
		return showdemand;
	}
	public void setShowdemand(List<TbGovBelong> showdemand)
	{
		this.showdemand = showdemand;
	}
	public List<TbGovBelong> getDemands()
	{
		return demands;
	}
	public void setDemands(List<TbGovBelong> demands)
	{
		this.demands = demands;
	}
	public DemandServiceImpl getDemandService()
	{
		return demandService;
	}
	public void setDemandService(DemandServiceImpl demandService)
	{
		this.demandService = demandService;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("demand", this.demand);
		return SUCCESS;
	}
	public String addDemand() throws Exception {
	
		this.demandService.save(this.demand);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("demand", this.demand);
		return "addDemand";
	}
	
	public String modifyDemand() {
		this.demandService.update(this.demand);
		return "modifyDemand";
	}
	
//////////////////////////////////////////////////////////////////
	public String doQuery() {
		try{
	////////判断条件//////////////////////////////////
			String tj1=getParam("txt_1_sel");
			System.out.println(tj1);
			String tj1_value=getParam("txt_1_value1");
			
			String tj2=getParam("txt_2_sel");
			String tj2_value=getParam("txt_2_value1");
			
			String tj3=getParam("txt_3_sel");
			String tj3_value=getParam("txt_3_value1");
			
			String tj4=getParam("txt_4_sel");
			String tj4_value=getParam("txt_4_value1");
			
			////////////模糊精确/////////////////////////
			String order=getParam("txt_1_special1");
			String zzbm=getParam("txt_2_special1");
			String tbjg=getParam("txt_3_special1");
			String state=getParam("txt_4_special1");
			
///////////////并含或///////////////////////
			String key1="and";
			String key2="and";
			String key3="and";
			
			String ke1=getParam("txt_2_key");
			String ke2=getParam("txt_3_key");
			String ke3=getParam("txt_4_key");
			
			if(!tj1_value.equals("")&&tj1_value!=null)
			{
				
				if(tj1.equals("order"))
				{
					demand.setCborder(tj1_value);
					if("%".equals(order))
					{
						order="%";
					}
				}
				else if(tj1.equals("zzbm"))
				{
					demand.setCbid(tj1_value);
					if("%".equals(zzbm))
					{
						zzbm="%";
					}
				}
				else if(tj1.equals("tbjg"))
				{
					demand.setCbAccount(tj1_value);
					if("%".equals(tbjg))
					{
						tbjg="%";
					}
				}
				else if(tj1.equals("state"))
				{
					demand.setState(tj1_value);
					if("%".equals(state))
					{
						state="%";
					}
				}
			}
			
			if(tj2!=null&&tj2_value!=null)
			{
				if(tj2.equals("order"))
				{
					demand.setCborder(tj2_value);
					if("%".equals(order))
					{
						order="%";
					}
					
					if("and".equals(ke1))
					{
						key1="and";
					}
					else if("or".equals(ke1))
					{
						key1="or";
					}
				}
				else if(tj2.equals("zzbm"))
				{
					demand.setCbid(tj2_value);
					if("%".equals(zzbm))
					{
						zzbm="%";
					}
					
					if("and".equals(ke1))
					{
						key1="and";
					}
					else if("or".equals(ke1))
					{
						key1="or";
					}
				}
				else if(tj2.equals("tbjg"))
				{
					demand.setCbAccount(tj2_value);
					if("%".equals(tbjg))
					{
						tbjg="%";
					}
					
					if("and".equals(ke1))
					{
						key1="and";
					}
					else if("or".equals(ke1))
					{
						key1="or";
					}
				}
				else if(tj2.equals("state"))
				{
					demand.setState(tj2_value);
					if("%".equals(state))
					{
						state="%";
					}
					
					if("and".equals(ke1))
					{
						key1="and";
					}
					else if("or".equals(ke1))
					{
						key1="or";
					}
				}
			}
			
			if(tj3!=null&&tj3_value!=null)
			{
				if(tj3.equals("order"))
				{
					demand.setCborder(tj3_value);
					if("%".equals(order))
					{
						order="%";
					}
					
					if("and".equals(ke2))
					{
						key2="and";
					}
					else if("or".equals(ke2))
					{
						key2="or";
					}
				}
				else if(tj3.equals("zzbm"))
				{
					demand.setCbid(tj3_value);
					if("%".equals(zzbm))
					{
						zzbm="%";
					}
					
					if("and".equals(ke2))
					{
						key2="and";
					}
					else if("or".equals(ke2))
					{
						key2="or";
					}
				}
				else if(tj3.equals("tbjg"))
				{
					demand.setCbAccount(tj3_value);
					if("%".equals(tbjg))
					{
						tbjg="%";
					}
					
					if("and".equals(ke2))
					{
						key2="and";
					}
					else if("or".equals(ke2))
					{
						key2="or";
					}
				}
				else if(tj3.equals("state"))
				{
					demand.setState(tj3_value);
					if("%".equals(state))
					{
						state="%";
					}
					
					if("and".equals(ke2))
					{
						key2="and";
					}
					else if("or".equals(ke2))
					{
						key2="or";
					}
				}
			}
			
			if(tj4!=null&&tj4_value!=null)
			{
				if(tj4.equals("order"))
				{
					demand.setCborder(tj4_value);
					if("%".equals(order))
					{
						order="%";
					}
					
					if("and".equals(ke3))
					{
						key3="and";
					}
					else if("or".equals(ke3))
					{
						key3="or";
					}
				}
				else if(tj4.equals("zzbm"))
				{
					demand.setCbid(tj4_value);
					if("%".equals(zzbm))
					{
						zzbm="%";
					}
					
					if("and".equals(ke3))
					{
						key3="and";
					}
					else if("or".equals(ke3))
					{
						key3="or";
					}
				}
				else if(tj4.equals("tbjg"))
				{
					demand.setCbAccount(tj4_value);
					if("%".equals(tbjg))
					{
						tbjg="%";
					}
					
					if("and".equals(ke3))
					{
						key3="and";
					}
					else if("or".equals(ke3))
					{
						key3="or";
					}
				}
				else if(tj4.equals("state"))
				{
					demand.setState(tj4_value);
					if("%".equals(state))
					{
						state="%";
					}
					
					if("and".equals(ke3))
					{
						key3="and";
					}
					else if("or".equals(ke3))
					{
						key3="or";
					}
				}
			}
			
			this.demands=this.demandService.query(demand,order,zzbm,tbjg,state,key1,key2,key3);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("demands", this.demands);
			
			return "doQuery";
			
		}catch (Exception e){
			e.printStackTrace();
			return "error";
		}
		
	}
	

	
	public String getParam(String key)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getParameter(key);
	}
}