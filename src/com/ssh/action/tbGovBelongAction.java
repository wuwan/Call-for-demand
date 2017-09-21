package com.ssh.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.TbGovBelong;
import com.ssh.orm.TbNeed;
import com.ssh.service.tbGovBelongService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class tbGovBelongAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private TbGovBelong tbgovbelong = new TbGovBelong(); 
	
	private tbGovBelongService<TbGovBelong> tbGovBelongService;
	
	private List<TbGovBelong> tbgovbelongs;
	
	private String searchText;
	
	public String doQuery()   {
		try{
		searchText = getParam("queryText");
		System.out.println(searchText);
		tbgovbelongs = tbGovBelongService.querytbGovBelongs(searchText, TbGovBelong.class);
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
		
	}	
	
	public String doQuery1()  {
		try{
		searchText = getParam("queryText");
		tbgovbelongs = tbGovBelongService.querytbGovBelongs1(searchText, TbGovBelong.class);
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	//////////////////////////////形式审核查看//////////////////////////////////
	public String doQuery2()  {
		try{
			String searchText1,searchText2;
		searchText1 = getParam("queryText1");
		searchText2 = getParam("queryText2");
		tbgovbelongs = tbGovBelongService.querytbGovBelongs2(searchText1,searchText2, TbGovBelong.class);
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	///////////////////////////技术审核查看///////////////////////////////////////
	public String doQuery3()  {
		try{
			String searchText1,searchText2;
		searchText1 = getParam("queryText1");
		searchText2 = getParam("queryText2");
		tbgovbelongs = tbGovBelongService.querytbGovBelongs3(searchText1,searchText2, TbGovBelong.class);
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String dotbGovBelongAdd(){
		String result = "";
		try {
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				tbGovBelongService.addtbGovBelong(tbgovbelong);
				//result = doneedQuery();
				return "tbGovBelongS";
			}else
				result = "addtbGovBelong";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
/////////////////////////形式审核//////////////////////////////////////////////
	public String doshenhe() throws Exception{
		String submit1 = getParam("submit1");
		String submit2 = getParam("submit2");
		if(submit1!=null)
		{
			return "tuihui1";
		}
		else if(submit2!=null)
		{
			try {
				Integer param = Integer.parseInt(getParam("param"));
				if(param == 0){
					String cborder = getParam("cborder");
					tbgovbelong = (TbGovBelong) tbGovBelongService.gettbGovBelong(TbGovBelong.class, cborder);
					return "accept1";
				}else if(param == 1){
					String state="已通过";
					tbgovbelong.setState(state);
					tbGovBelongService.modifytbGovBelong(tbgovbelong);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "accept1";
		}
		else
			return "accept1";
	}
/////////////////////////技术审核//////////////////////////////////////////////	
	public String doshenpi() throws Exception{
		String submit1 = getParam("submit3");
		String submit2 = getParam("submit4");
		String guanli=(String) ActionContext.getContext().getSession().get("guanli");
		System.out.println(guanli);
		if(submit1!=null)
		{
			return "tuihui";
		}
		else if(submit2!=null)
		{
			try {
				Integer param = Integer.parseInt(getParam("param"));
				if(param == 0){
					String cborder = getParam("cborder");
					tbgovbelong = (TbGovBelong) tbGovBelongService.gettbGovBelong(TbGovBelong.class, cborder);
					return "accept";
				}else if(param == 1){
					String state1="已通过";
					tbgovbelong.setCbnumber(guanli);
					tbgovbelong.setState1(state1);
					tbGovBelongService.modifytbGovBelong(tbgovbelong);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "accept";
		}
		else
			return "accept";
	}
	
	public String doDelete() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("zzbm"));
			String cborder = getParam("cborder");
			tbGovBelongService.deletetbGovBelong(cborder,TbGovBelong.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doQuery();
	}
	
	private String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public TbGovBelong getTbgovbelong()
	{
		return tbgovbelong;
	}

	public void setTbgovbelong(TbGovBelong tbgovbelong)
	{
		this.tbgovbelong = tbgovbelong;
	}

	public tbGovBelongService<TbGovBelong> getTbGovBelongService()
	{
		return tbGovBelongService;
	}

	public void setTbGovBelongService(
			tbGovBelongService<TbGovBelong> tbGovBelongService)
	{
		this.tbGovBelongService = tbGovBelongService;
	}



	public List<TbGovBelong> getTbgovbelongs()
	{
		return tbgovbelongs;
	}

	public void setTbgovbelongs(List<TbGovBelong> tbgovbelongs)
	{
		this.tbgovbelongs = tbgovbelongs;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
}
