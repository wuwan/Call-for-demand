package com.ssh.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.Reject;
import com.ssh.orm.TbGovBelong;
import com.ssh.service.rejectService;
import com.ssh.service.tbGovBelongService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class rejectAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private Reject reject = new Reject(); 
	private TbGovBelong tbgovbelong = new TbGovBelong();
	
	private rejectService<Reject> rejectService;
	private tbGovBelongService<TbGovBelong> tbGovBelongService;
	
	private List<Reject> rejects;
	private List<TbGovBelong> tbgovbelongs;
	
	private String searchText;
	
	public String doQuery()   {
		try{
		searchText = getParam("queryText");
		System.out.println(searchText);
		rejects = rejectService.queryRejects(searchText, Reject.class);
		return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
		
	}	
	
	public String doQuery1()  {
		try{
			searchText = getParam("queryText");
			System.out.println(searchText);
			rejects = rejectService.queryRejects1(searchText, Reject.class);
			return SUCCESS;
			}catch (Exception e) {
				e.printStackTrace();
				return ERROR;
				}
	}
	
	public String docauseSelect() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				String crorder = getParam("crorder");
				reject = (Reject) rejectService.getReject(Reject.class, crorder);
				return "selectCause";
			}else if(param == 1){
				rejectService.modifyReject(reject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "selectCause";
	}
////////////////////////////形式审核退回///////////////////////////
	public String dotuihui(){
		String result = "";
		try {
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				String crorder = reject.getCrorder();
				System.out.println(crorder);
				rejectService.addReject(reject);
				tbGovBelongService.deletetbGovBelong(crorder,TbGovBelong.class);
				return "tuihui";
			}else
				result = "tuihui";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
//////////////////////////技术审核退回////////////////////////////////	
	public String dotuihui1(){
		String result = "";
		try {
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				String crorder = reject.getCrorder();
				System.out.println(crorder);
				rejectService.addReject(reject);
				tbGovBelongService.deletetbGovBelong(crorder,TbGovBelong.class);
				return "tuihui2";
			}else
				result = "tuihui2";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String doDelete() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("zzbm"));
			rejectService.deleteReject(param,Reject.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doQuery();
	}
	
	private String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public Reject getReject()
	{
		return reject;
	}

	public void setReject(Reject reject)
	{
		this.reject = reject;
	}

	public rejectService<Reject> getRejectService()
	{
		return rejectService;
	}

	public void setRejectService(rejectService<Reject> rejectService)
	{
		this.rejectService = rejectService;
	}

	public List<Reject> getRejects()
	{
		return rejects;
	}

	public void setRejects(List<Reject> rejects)
	{
		this.rejects = rejects;
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

	public void setTbGovBelongService(tbGovBelongService<TbGovBelong> tbGovBelongService)
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
