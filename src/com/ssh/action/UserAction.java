package com.ssh.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONSerializer;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.SysRight;
import com.ssh.orm.SysRole;
import com.ssh.orm.TbAdministrator;
import com.ssh.orm.TbArea;
import com.ssh.orm.TbBelong;
import com.ssh.service.AreaService;
import com.ssh.service.BelongService;
import com.ssh.service.RightServiceImpl;
import com.ssh.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private TbAdministrator user;
	private List<TbAdministrator> suser;
	@SuppressWarnings("rawtypes")
	private UserServiceImpl userService;
	private RightServiceImpl rightService;
	private String message;
	private String username;
	private String password;
	private String YanZheng;
	
	//归口管理表
	private BelongService belongservice;
	private List<TbBelong> belong;
	private String BelongCode;
	//所在地域表
	private AreaService areaservice;
	private List<TbArea> area;
	private String AreaCode;
	
	//RoleUser表
	
	private String searchText;

    
	public TbAdministrator getUser()
	{
		return user;
	}

	public void setUser(TbAdministrator user)
	{
		this.user = user;
	}

	public List<TbAdministrator> getSuser()
	{
		return suser;
	}

	public void setSuser(List<TbAdministrator> suser)
	{
		this.suser = suser;
	}

	@SuppressWarnings("rawtypes")
	public UserServiceImpl getUserService()
	{
		return userService;
	}

	@SuppressWarnings("rawtypes")
	public void setUserService(UserServiceImpl userService)
	{
		this.userService = userService;
	}

	public RightServiceImpl getRightService()
	{
		return rightService;
	}

	public void setRightService(RightServiceImpl rightService)
	{
		this.rightService = rightService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getYanZheng() {
		return YanZheng;
	}

	public void setYanZheng(String yanZheng) {
		YanZheng = yanZheng;
	}

	public BelongService getBelongservice()
	{
		return belongservice;
	}

	public void setBelongservice(BelongService belongservice)
	{
		this.belongservice = belongservice;
	}

	public List<TbBelong> getBelong()
	{
		return belong;
	}

	public void setBelong(List<TbBelong> belong)
	{
		this.belong = belong;
	}

	public String getBelongCode()
	{
		return BelongCode;
	}

	public void setBelongCode(String belongCode)
	{
		BelongCode = belongCode;
	}

	public AreaService getAreaservice()
	{
		return areaservice;
	}

	public void setAreaservice(AreaService areaservice)
	{
		this.areaservice = areaservice;
	}

	public List<TbArea> getArea()
	{
		return area;
	}

	public void setArea(List<TbArea> area)
	{
		this.area = area;
	}

	public String getAreaCode()
	{
		return AreaCode;
	}

	public void setAreaCode(String areaCode)
	{
		AreaCode = areaCode;
	}

	public String getSearchText()
	{
		return searchText;
	}

	public void setSearchText(String searchText)
	{
		this.searchText = searchText;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", this.user);
		return SUCCESS;
	}
	
	
	    //不同用户角色登录
		public String login() throws Exception {
			HttpServletRequest request = ServletActionContext.getRequest();
			String sessionCode = (String)request.getSession().getAttribute("rand");
			if(!sessionCode.equals(YanZheng)){
				ActionContext.getContext().put("msg","验证码错误");
				System.out.println("验证码错误");
				return INPUT;
			}
			user = userService.getloginUser(username, password);
			if (user != null) {
				// 放置user对象到session
				ActionContext.getContext().getSession().put("userInsession", user);
				ActionContext.getContext().getSession().put("zzbm", user.getNumber());
				ActionContext.getContext().getSession().put("guanli", user.getName());
				ActionContext.getContext().getSession().put("account", user.getAccount());
				// 重定向到主页
				return "success";
			}
			ActionContext.getContext().put("msg","用户名或密码错误");
			return INPUT;
		}
		//登录失败
		public String loginOut() throws Exception {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			return INPUT;
		}
		public String userUpdateInfo() {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			TbAdministrator user = (TbAdministrator) session.getAttribute("user");
			this.user = this.userService.findByName(user.getAccount());
			return "userUpdate";
		}
		//修改用户信息
		public String updateUser() {
			this.userService.update(user);
			message = "修改信息成功。";
			return "updateSuc";
		}
		
		//用户注册
		@SuppressWarnings("unchecked")
		public String doAdd(){
			user.getSysRole().add(new SysRole("4"));
			
			String result = "";
			try {
				String param = getParam("param");
				if(Integer.parseInt(param) > 0){
					
					String password=user.getPassword();				
					user.setPassword(password);
					userService.addUser(user);
					result = "success";
				}else
					result = "addUser";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		/////////////////添加用户和权限/////////////////////////////////
		@SuppressWarnings("unchecked")
		public String doAdd1(){
			String role=user.getRole();
			if(role.equals("普通用户"))
			{
				user.getSysRole().add(new SysRole("4"));
			}
			else if(role.equals("形式审核人员"))
			{
				user.getSysRole().add(new SysRole("3"));
			}
			else if(role.equals("技术审核人员"))
			{
				user.getSysRole().add(new SysRole("2"));
			}
			
			String result = "";
			try {
				String param = getParam("param");
				if(Integer.parseInt(param) > 0){
					
					String password=user.getPassword();				
					user.setPassword(password);
					userService.addUser(user);
					result = "success";
				}else
					result = "add";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//判断用户名是否已经注册
		public void textajax()throws Exception{

			HttpServletRequest request=ServletActionContext.getRequest();
			String name=request.getParameter("name");
			user=userService.findByName(name);
			String msg;
			if (user==null)
			{
				msg="用户名可以使用！";
			}
			else {
				msg="用户名已存在！";
			}
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(msg);		
		}
		
		//按权限显示侧边栏菜单
		public String menu() throws Exception {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			user =  (TbAdministrator) ActionContext.getContext().getSession().get("userInsession");
			List<SysRight> list = rightService.findByLoginUserId(user.getNumber());
			System.out.println("Action");
			for (SysRight sysRight : list) {
				System.out.println(sysRight);
			}
			String json = JSONSerializer.toJSON(list).toString();
			out.print(json);
			return null;
			}
		
		@SuppressWarnings("unchecked")
		public String doQuery() throws Exception{
			searchText = getParam("queryText");
			suser = userService.queryUsers(searchText,TbAdministrator.class);
			return "1";
		}
	///////////////////////////从数据库中提取相关的信息显示在填报表中/////////////////////
		@SuppressWarnings("unchecked")
		public String douserQuery5() throws Exception  {
			String Zzbm=(String) ActionContext.getContext().getSession().get("zzbm");
			user =(TbAdministrator) userService.getUser(TbAdministrator.class, Zzbm);
			belong = belongservice.query(TbBelong.class);
			area = areaservice.query(TbArea.class);
			return "5";
				}
		
	////////////////////////////显示所有用户///////////////////////////////////////		
		@SuppressWarnings("unchecked")
		public String showAlluser() throws Exception {
			try{
				suser=userService.findAll();
				return SUCCESS;
			}catch (Exception e) {
				e.printStackTrace();
				return ERROR;
				}
		}
		
		@SuppressWarnings("unchecked")
		public String douserQuery6() throws Exception  {
				String Zzbm=(String) ActionContext.getContext().getSession().get("zzbm");
				user =(TbAdministrator) userService.getUser(TbAdministrator.class, Zzbm);
				return "6";
					}
		@SuppressWarnings("unchecked")
		public String douserEdit() throws Exception{
			try {
				Integer param = Integer.parseInt(getParam("param"));
				if(param == 0){
					String account = getParam("account");
					user = (TbAdministrator) userService.getUser(TbAdministrator.class, account);
					return "editUser";
				}else if(param == 1){
					userService.modifyUser(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "editUser";
		}
		@SuppressWarnings("unchecked")
		public String doDelete() throws Exception{
			try {
				Integer param = Integer.parseInt(getParam("zzbm"));
				userService.deleteUser(param,TbAdministrator.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return doQuery();
		}
		
		protected String getParam(String key){
			return ServletActionContext.getRequest().getParameter(key);
		}
	}