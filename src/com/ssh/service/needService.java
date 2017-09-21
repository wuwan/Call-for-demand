package com.ssh.service;

import java.util.List;
import com.ssh3.orm.needDao;
import com.ssh.orm.TbNeed;

public class needService<T> {
	
private needDao need;
	
	public List<TbNeed> queryNeeds(String CNumber,Class<TbNeed> clazz) throws Exception{
		if(CNumber == null || "".equals(CNumber))
		{
		    return need.getAllObjects(clazz);
		}
		String queryString = "SELECT u FROM TbNeed u WHERE u.CNumber like '%"+CNumber+"'";
		return need.getObjects(queryString);
	}
	
	public void addNeed(T user) throws Exception{
		need.addObject(user);
	}
	
	public void modifyNeed(T user) throws Exception{
		need.updateObject(user);
	}
	
	public void deleteNeed(String zzbm,Class<TbNeed> class1) throws Exception{
		TbNeed u = need.getObject(class1, zzbm);
		need.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getNeed(Class<TbNeed> class1, String cborder){
		return (T) need.getObject(class1, cborder);
	}

	public needDao getNeed() {
		return need;
	}

	public void setNeed(needDao need) {
		this.need = need;
	}
	

	public List<TbNeed> getData(String inudstry,String searchCon)
	{
		// TODO Auto-generated method stub
		//根据选择的查询条件拼装出对应的字符串
		String hql = getHql(inudstry,searchCon);
		List<TbNeed> requireList = need.getData(hql);
		//保存查询结果的字符串   每个技术需求项用一个字符串表示用;隔开    需求包括  需求名称   提出人    添加时间   审核状态  需求的编号
		//需求编号+需求名称+添加时间+组织机构代码+组织机构名称+审核状态
		/*String data = "";
		if(requireList != null)
		{
			for(int i = 0;i < requireList.size();i++)
			{
				RequirementInfo require = requireList.get(i);
				data = require.getRequirementCoding()+","+require.getName()+","+require.getAddTime()+","+require.getInstitutionInfo().getInstitutionCoding()+","+require.getInstitutionInfo().getName()+","+require.getNowState()+";";
			}
		}
		System.out.println("返回的数据为"+data);
		return "323232";
		*/
		return requireList;
	}
	
	//根据传过来的行业编号和查询条件来拼接hql语句
	public String getHql(String inudstry,String searchCon)
	{
		String hql = "from TbNeed require where";
		//先根据行业来封装
		//把行业条件拆开
		String[] industryArray = inudstry.substring(0,inudstry.length()-1).split(";");
		for(int i = 0; i < industryArray.length;i++)
		{
			//第一个条件不用加or
			if(i == 0)
			{
				hql += " require.CApplication like '%" + industryArray[i] + "%' ";
			}
			else
			{
				hql += "or require.CApplication like '%" + industryArray[i] + "%' ";
			}
		}
		System.out.println("使用行业信息拼装后的hql语句为"+hql);
		
		//根据查询条件来拼装  前台传过来的数据格式为     机构全称,1,精确;0,机构全称,1,精确;
		//保存查询条件的数组    这里为什么要定义成final类型的呢
		//@SuppressWarnings("serial")
		/*Map<String,String> conditionNameMap = new HashMap<String,String>();
		conditionNameMap.put("机构全称","name");
		conditionNameMap.put("归口管理部门","CBelong");
		conditionNameMap.put("所在地域","CMoneyElse");
		conditionNameMap.put("法人代表","CRepresent");
		conditionNameMap.put("联系人","CConnect");
		conditionNameMap.put("机构属性","CNature");
		conditionNameMap.put("技术需求名称","CNeedName");
		conditionNameMap.put("技术需求所属领域 ","CNeedBelong");	
		//先把每一项拆分出来   前台传递过来的字符串为   机构全称,1,精确;0,机构全称,1,精确;
		String[] searchArray = searchCon.substring(0,searchCon.length()-1).split(";");
		for(int i = 0;i < searchArray.length;i++)
		{
			//在每一项的内部进行拆分
			String[] item = searchArray[i].split(",");
			//遍历HashMap的固定格式
			@SuppressWarnings("rawtypes")
			Iterator it = conditionNameMap.entrySet().iterator();
			while(it.hasNext())
			{
				@SuppressWarnings("rawtypes")
				Entry cNameEntry = (Entry)it.next();
				String key = cNameEntry.getKey().toString();
				//查询字段匹配
				if(key.equals(item[1]))
				{
					String value = cNameEntry.getValue().toString();
					//精确查询
					if("精确".equals(item[3]))
					{
						//and
						if("0".equals(item[0]))
						{
							hql += "and require." + value +" = '" + item[2] +"' ";
						}
						//or
						else if("1".equals(item[0]))
						{
							hql += "or require." + value +" = '" + item[2] +"' ";
						}
						//不等于
						else if("2".equals(item[0]))
						{
							hql += "and require." + value +" <> '" + item[2] +"' ";
						}
					}
					//模糊查询
					else
					{
						//and
						if("0".equals(item[0]))
						{
							hql += "and require." + value +" like '%" + item[2] +"%' ";
						}
						//or
						else if("1".equals(item[0]))
						{
							hql += "or require." + value +" like '%" + item[2] +"%' ";
						}
						//不等于
						else if("2".equals(item[0]))
						{
							hql += "and require." + value +" like '%" + item[2] +"%' ";
						}
					}
				}
			}	
		}*/
		System.out.println("使用查询条件拼装后的hql语句为"+hql);
		return hql;
	}
	
}
