package com.ssh.action;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.orm.Subjecttype;
import com.ssh.orm.Xueke;
import com.ssh.service.ClassifyService;

@SuppressWarnings("serial")
public class ClassifyAction extends ActionSupport
{
	private ClassifyService classifyservice;
	private List<Xueke> firstid;
	private List<Xueke> secondid;
	private List<Xueke> thirdid;
	private List<Subjecttype> first;
	private List<Subjecttype> second;
	private List<Subjecttype> third;
	private String ClassifyCode2;
	private String ClassifyCode3;
	private String GmCode2;
	private String GmCode3;
	
	
	/**
	 * @return the classifyservice
	 */
	@JSON(serialize=false)
	public ClassifyService getClassifyservice()
	{
		return classifyservice;
	}
	/**
	 * @param classifyservice the classifyservice to set
	 */
	public void setClassifyservice(ClassifyService classifyservice)
	{
		this.classifyservice = classifyservice;
	}
	/**
	 * @return the firstid
	 */
	public List<Xueke> getFirstid()
	{
		return firstid;
	}
	/**
	 * @param firstid the firstid to set
	 */
	public void setFirstid(List<Xueke> firstid)
	{
		this.firstid = firstid;
	}
	/**
	 * @return the secondid
	 */
	public List<Xueke> getSecondid()
	{
		return secondid;
	}
	/**
	 * @param secondid the secondid to set
	 */
	public void setSecondid(List<Xueke> secondid)
	{
		this.secondid = secondid;
	}
	/**
	 * @return the thirdid
	 */
	public List<Xueke> getThirdid()
	{
		return thirdid;
	}
	/**
	 * @param thirdid the thirdid to set
	 */
	public void setThirdid(List<Xueke> thirdid)
	{
		this.thirdid = thirdid;
	}
	/**
	 * @return the first
	 */
	public List<Subjecttype> getFirst()
	{
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(List<Subjecttype> first)
	{
		this.first = first;
	}
	/**
	 * @return the second
	 */
	public List<Subjecttype> getSecond()
	{
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(List<Subjecttype> second)
	{
		this.second = second;
	}
	/**
	 * @return the third
	 */
	public List<Subjecttype> getThird()
	{
		return third;
	}
	/**
	 * @param third the third to set
	 */
	public void setThird(List<Subjecttype> third)
	{
		this.third = third;
	}
	/**
	 * @return the classifyCode2
	 */
	public String getClassifyCode2()
	{
		return ClassifyCode2;
	}
	/**
	 * @param classifyCode2 the classifyCode2 to set
	 */
	public void setClassifyCode2(String classifyCode2)
	{
		ClassifyCode2 = classifyCode2;
	}
	/**
	 * @return the classifyCode3
	 */
	public String getClassifyCode3()
	{
		return ClassifyCode3;
	}
	/**
	 * @param classifyCode3 the classifyCode3 to set
	 */
	public void setClassifyCode3(String classifyCode3)
	{
		ClassifyCode3 = classifyCode3;
	}
	/**
	 * @return the gmCode2
	 */
	public String getGmCode2()
	{
		return GmCode2;
	}
	/**
	 * @param gmCode2 the gmCode2 to set
	 */
	public void setGmCode2(String gmCode2)
	{
		GmCode2 = gmCode2;
	}
	/**
	 * @return the gmCode3
	 */
	public String getGmCode3()
	{
		return GmCode3;
	}
	/**
	 * @param gmCode3 the gmCode3 to set
	 */
	public void setGmCode3(String gmCode3)
	{
		GmCode3 = gmCode3;
	}
	//国民下拉框一
	public String FirstGm()
	{
		first=classifyservice.getFirstGmjjhys();
		System.out.println(first.size());
		return "Success";
	}
	//国民下拉框二
	public String SecondGm()
	{
		second=classifyservice.getSecondGmjjhys(GmCode2);
		System.out.println(second.size());
		return "Success";
	}
	//国民下拉框三
	public String ThirdGm()
	{
		third=classifyservice.getThirdGmjjhys(GmCode3);
		System.out.println(third.size());
		return "Success";
	}
	
	//学科下拉框一
	
	public String FirstClassify()
	{
		firstid=classifyservice.getFirstXkfls();
		System.out.println(firstid.size());
		return "Success";
	}
	
	//学科下拉框二
	public String SecondClassify()
	{
		secondid=classifyservice.getSecondXkfls(ClassifyCode2);
		System.out.println(secondid.size());
		return "Success";
	}
	//学科下拉框三
	public String ThirdClassify()
	{
		thirdid=classifyservice.getThirdXkfls(ClassifyCode3);
		System.out.println(thirdid.size());
		return "Success";
	} 
}
