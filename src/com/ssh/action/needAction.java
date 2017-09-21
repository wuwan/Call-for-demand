package com.ssh.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.Guanli;
import com.ssh.orm.TbGovBelong;
import com.ssh.orm.TbNeed;
import com.ssh.service.GuanliService;
import com.ssh.service.needService;
import com.ssh.service.tbGovBelongService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户管理控制器
 * */
public class needAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private TbNeed need = new TbNeed(); 
	private TbGovBelong tbgovbelong = new TbGovBelong(); 
	
	private needService<TbNeed> needService;
	private tbGovBelongService<TbGovBelong> tbGovBelongService;
	
	private List<TbNeed> needs;
	private List<TbGovBelong> tbgovbelongs;
	//管理处室表
	private GuanliService guanliservice;
	private List<Guanli> guanlii;

	private String GuanliCode;
	
	
	private String searchText;
	
	public String doneedQuery() throws Exception{
		searchText = getParam("queryText");
		needs = needService.queryNeeds(searchText,TbNeed.class);
		return SUCCESS;
	}

	public String doneedAdd(){
		//审批表的插入
		String name=need.getName();
		tbgovbelong.setCbAccount(name);
		String number=need.getNumber();
		tbgovbelong.setCbid(number);
		String Cnumber=need.getCNumber();
		tbgovbelong.setCborder(Cnumber);
		String Cbnumber="默认";
		tbgovbelong.setCbnumber(Cbnumber);
		String state="待审核";
		tbgovbelong.setState(state);
		String state1="待审核";
		tbgovbelong.setState1(state1);
		
		String result = "";
		try {
			System.out.println("进入查询");
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				needService.addNeed(need);
				tbGovBelongService.addtbGovBelong(tbgovbelong);
				return "needS";
			}else
				result = "addNeed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//不可修改需求表	
public String doneedSelect() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				String cborder = getParam("cborder");
				need = (TbNeed) needService.getNeed(TbNeed.class, cborder);
				return "selectNeed";
			}else if(param == 1){
				needService.modifyNeed(need);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doneedQuery();
	}

//可修改需求表
public String doneedEdit() throws Exception{
	try {
		Integer param = Integer.parseInt(getParam("param"));
		if(param == 0){
			String cborder = getParam("cborder");
			need = (TbNeed) needService.getNeed(TbNeed.class, cborder);
			return "editNeed";
		}else if(param == 1){
			needService.modifyNeed(need);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return doneedQuery();
}

//更新需求表
public String doneedUpdate() throws Exception{
	try {
		Integer param = Integer.parseInt(getParam("param"));
		if(param == 0){
			String cborder = getParam("cborder");
			need = (TbNeed) needService.getNeed(TbNeed.class,cborder);
			return "updateNeed";
		}else if(param == 1){
			needService.modifyNeed(need);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "updateNeed";
}

////////////////////////形式审核查看和管理处室的查看////////////////////////////////////////////
public String doselectFormat() throws Exception{
	try {
		Integer param = Integer.parseInt(getParam("param"));
		if(param == 0){
			String cborder = getParam("cborder");
			need = (TbNeed) needService.getNeed(TbNeed.class, cborder);
			guanlii = guanliservice.query(Guanli.class);
			return "selectFormat";
		}else if(param == 1){
			needService.modifyNeed(need);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return doneedQuery();
}

////////////////////////技术审核查看////////////////////////////////////////////
public String doselectTechnology() throws Exception{
    try {
        Integer param = Integer.parseInt(getParam("param"));
        if(param == 0){
            String cborder = getParam("cborder");
            need = (TbNeed) needService.getNeed(TbNeed.class, cborder);
            return "selectTechnology";
        }else if(param == 1){
            needService.modifyNeed(need);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return doneedQuery();
}
//表的删除
public String doneedDelete() throws Exception{
		try {
			String cborder = getParam("cborder");
			needService.deleteNeed(cborder,TbNeed.class);
			tbGovBelongService.deletetbGovBelong(cborder,TbGovBelong.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteNeed";
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	

	public String getSearchText() {
		return searchText;
	}

	public TbNeed getNeed() {
		return need;
	}

	public void setNeed(TbNeed need) {
		this.need = need;
	}

	public needService<TbNeed> getNeedService()
	{
		return needService;
	}

	public void setNeedService(needService<TbNeed> needService)
	{
		this.needService = needService;
	}

	public List<TbNeed> getNeeds() {
		return needs;
	}

	public void setNeeds(List<TbNeed> needs) {
		this.needs = needs;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public List<TbGovBelong> getTbgovbelongs()
	{
		return tbgovbelongs;
	}

	public void setTbgovbelongs(List<TbGovBelong> tbgovbelongs)
	{
		this.tbgovbelongs = tbgovbelongs;
	}

	public tbGovBelongService<TbGovBelong> getTbGovBelongService()
	{
		return tbGovBelongService;
	}

	public void setTbGovBelongService(tbGovBelongService<TbGovBelong> tbGovBelongService)
	{
		this.tbGovBelongService = tbGovBelongService;
	}

	public TbGovBelong getTbgovbelong()
	{
		return tbgovbelong;
	}

	public void setTbgovbelong(TbGovBelong tbgovbelong)
	{
		this.tbgovbelong = tbgovbelong;
	}

	public String getGuanliCode()
	{
		return GuanliCode;
	}

	public void setGuanliCode(String guanliCode)
	{
		GuanliCode = guanliCode;
	}

	public List<Guanli> getGuanlii()
	{
		return guanlii;
	}

	public void setGuanlii(List<Guanli> guanlii)
	{
		this.guanlii = guanlii;
	}

	public GuanliService getGuanliservice()
	{
		return guanliservice;
	}

	public void setGuanliservice(GuanliService guanliservice)
	{
		this.guanliservice = guanliservice;
	}
}
