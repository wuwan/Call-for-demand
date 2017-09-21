package com.ssh.service;

import java.util.List;

import com.ssh.orm.Subjecttype;
import com.ssh.orm.Xueke;
import com.ssh3.orm.ClassifyDAO;

public class ClassifyService
{
	private ClassifyDAO classify;
	
	
	/**
	 * @return the classify
	 */
	public ClassifyDAO getClassify()
	{
		return classify;
	}

	/**
	 * @param classify the classify to set
	 */
	public void setClassify(ClassifyDAO classify)
	{
		this.classify = classify;
	}

	//获取国民经济行业的第一个下拉框
	public List<Subjecttype> getFirstGmjjhys()
	{
		return classify.getFirstGmjjhys();
	}
	
	//获取国民经济行业的第二个下拉框
	public List<Subjecttype> getSecondGmjjhys(String secondCode)
	{
		return classify.getSecondGmjjhys(secondCode);
	}
	
	//获取国民经济行业的第三个下拉框
	public List<Subjecttype> getThirdGmjjhys(String thirdCode)
	{
		return classify.getThirdGmjjhys(thirdCode);
	}
	
	//获取学科分类第一个下拉框
	public List<Xueke> getFirstXkfls()
	{
		return classify.getFirstXkfls();
	}

	//获取学科分类的第二个下拉框
	public List<Xueke> getSecondXkfls(String secondXcode)
	{
		return classify.getSecondXkfls(secondXcode);
	}

	//获取学科分类的第三个下拉框的值
	public List<Xueke> getThirdXkfls(String thirdXcode)
	{
		return classify.getThirdXkfls(thirdXcode);
	}
}
