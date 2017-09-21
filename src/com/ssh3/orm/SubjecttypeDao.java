package com.ssh3.orm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.orm.Subjecttype;

public class SubjecttypeDao
{
	private SessionFactory sessionFactory;
	//private Session session;
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public String getOneIndustry()
	{
		//首先获取当前连接 
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			System.out.println("typeDao 获取的是当前连接");
		}
		//如果当前连接没有获取成功的话打开一次新的连接
		catch(Exception e)
		{
			session = sessionFactory.openSession();
			System.out.println("typeDao 打开的是新连接");
		}
		finally
		{
			String hql = "from Subjecttype type where type.code like '_0000'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Subjecttype> oneIndustryList = query.list();
			//保证代码的健壮性
			if(oneIndustryList != null)
			{
				//保存返回的字符串  每个行业之间用;隔开    行业内部的代码和标题用,隔开
				String oneIndustry = "";
				//记录行业列表中的一个行业
				Subjecttype industry = null;
				//查找所有的一级行业
				//把每一个行业的行业代码和名称添加到字符串的最后
				for(int i = 0;i < oneIndustryList.size();i++)
				{
					industry = oneIndustryList.get(i);
					//当前行业下面还有子行业
					if(nextLevel(industry.getCode().substring(0,1)+"__00"))
					{
						//先添加行业代码再添加行业名称  最后的true表示还有子行业
						//一级行业只添加行业代码的第一个字母    这样方便检索
						oneIndustry += industry.getCode().substring(0,1) + "," + industry.getTitle() + ",true;";
					}
					else
					{
						//先添加行业代码再添加行业名称  最后的false表示没有子行业
						oneIndustry += industry.getCode().substring(0,1) + "," + industry.getTitle() + ",false;";
					}
				}
				session.close();
				System.out.println("后台获取到的  一级行业的字符串为"+oneIndustry);
				return oneIndustry;	
			}
		}
		
		return null;		
	}

	public String getTwoIndustry(String oneIndustry)
	{
		// TODO Auto-generated method stub
		//首先获取当前连接 
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			System.out.println("IndustryDao 获取的是当前连接");
		}
		//如果当前连接没有获取成功的话打开一次新的连接
		catch(Exception e)
		{
			session = sessionFactory.openSession();
			System.out.println("IndustryDao 打开的是新连接");
		}
		finally
		{
			//查找匹配的关键字
			String key = oneIndustry.substring(0,1);
			String hql = "from Subjecttype type where type.code like '"+key+"__00'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Subjecttype> twoIndustryList = query.list();
			//保证代码的健壮性
			if(twoIndustryList != null)
			{
				//保存返回的字符串  每个行业之间用;隔开    行业内部的代码和标题用,隔开
				String twoIndustry = "";
				//记录行业列表中的一个行业
				Subjecttype industry = null;
				//查找所有的一级行业
				//把每一个行业的行业代码和名称添加到字符串的最后
				for(int i = 0;i < twoIndustryList.size();i++)
				{
					industry = twoIndustryList.get(i);
					//不能包含自己
					if(!industry.getCode().equals(oneIndustry))
					{
						//当前行业下面还有子行业
						if(nextLevel(industry.getCode().substring(0,3)+"__"))
						{
							//先添加行业代码再添加行业名称  最后的true表示还有子行业
							//二级行业只添加行代码的前三个字母
							twoIndustry += industry.getCode().substring(0,3) + "," + industry.getTitle() + ",true;";
						}
						else
						{
							//先添加行业代码再添加行业名称  最后的false表示没有子行业
							twoIndustry += industry.getCode().substring(0,3) + "," + industry.getTitle() + ",false;";
						}
					}
					
				}
				session.close();
				System.out.println("后台获取到的  二级行业的字符串为"+twoIndustry);
				return twoIndustry;	
			}
		}
		
		return null;
	}

	public String getThreeIndustry(String twoIndustry)
	{
		// TODO Auto-generated method stub
		//首先获取当前连接
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			System.out.println("IndustryDao 获取的是当前连接");
		}
		//如果当前连接没有获取成功的话打开一次新的连接
		catch(Exception e)
		{
			session = sessionFactory.openSession();
			System.out.println("IndustryDao 打开的是新连接");
		}
		finally
		{
			//查找匹配的关键字
			String key = twoIndustry.substring(0,3);
			String hql = "from Subjecttype type where type.code like '"+key+"__'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Subjecttype> threeIndustryList = query.list();
			//保证代码的健壮性
			if(threeIndustryList != null)
			{
				//保存返回的字符串  每个行业之间用;隔开    行业内部的代码和标题用,隔开
				String threeIndustry = "";
				//记录行业列表中的一个行业
				Subjecttype industry = null;
				//查找所有的一级行业
				//把每一个行业的行业代码和名称添加到字符串的最后
				for(int i = 0;i < threeIndustryList.size();i++)
				{
					industry = threeIndustryList.get(i);
					if(!industry.getCode().equals(twoIndustry))
					{
						//先添加行业代码再添加行业名称  三级行业不用加 状态参数
						threeIndustry += industry.getCode() + "," + industry.getTitle() + ";";
					}
					else
					{
						
					}
				}
				session.close();
				System.out.println("后台获取到的  三级行业的字符串为"+threeIndustry);
				return threeIndustry;	
			}
		}
		
		return null;
	}
	
	//该方法被弃用
	//根据某一个字符串匹配相应的行业信息
	//key表示的是要匹配的关键字   code当前行业的代码  code存在的目的是查找子行业的时候去掉自己
	public String getIndustry(String key,String code)
	{
		//首先获取当前连接 
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			System.out.println("IndustryDao 获取的是当前连接");
		}
		//如果当前连接没有获取成功的话打开一次新的连接
		catch(Exception e)
		{
			session = sessionFactory.openSession();
			System.out.println("IndustryDao 打开的是新连接");
		}
		finally
		{
			String hql = "from Subjecttype industry where industry.code like '"+key+"'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Subjecttype> oneIndustryList = query.list();
			//保证代码的健壮性
			if(oneIndustryList != null)
			{
				//保存返回的字符串  每个行业之间用;隔开    行业内部的代码和标题用,隔开
				String oneIndustry = "";
				//记录行业列表中的一个行业
				Subjecttype industry = null;
				//查找所有的一级行业
				if(code == null)
				{
					//把每一个行业的行业代码和名称添加到字符串的最后
					for(int i = 0;i < oneIndustryList.size();i++)
					{
						industry = oneIndustryList.get(i);
						//先添加行业代码再添加行业名称
						oneIndustry += industry.getCode() + "," + industry.getTitle() + ";";
					}
					System.out.println("后台获取到的  一级行业的字符串为"+oneIndustry);
					return oneIndustry;
				}
				
			}
		}
		
		return null;		
	}
	
	//检测某一个行业下面是否有子行业
	@SuppressWarnings("finally")
	public boolean nextLevel(String code)
	{
		//首先获取当前连接 
		Session session = null;
		try
		{
			session = sessionFactory.getCurrentSession();
			System.out.println("typeDao 获取的是当前连接");
		}
		//如果当前连接没有获取成功的话打开一次新的连接
		catch(Exception e)
		{
			session = sessionFactory.openSession();
			System.out.println("typeDao 打开的是新连接");
		}
		finally
		{
			String hql = "from Subjecttype type where type.code like '"+code+"'";
			Query query = session.createQuery(hql);
			//判断的条件是结果集要大于1  最少有两个一个是自己  其他的是子行业
			if(query.list().size() > 1)
			{
				session.close();
				return true;
			}
			session.close();
			return false;
		}
	}
}
