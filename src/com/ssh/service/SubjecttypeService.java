package com.ssh.service;

import com.ssh3.orm.SubjecttypeDao;



public class SubjecttypeService
{
	private SubjecttypeDao industryDao;

	public SubjecttypeDao getIndustryDao()
	{
		return industryDao;
	}

	public void setIndustryDao(SubjecttypeDao industryDao)
	{
		this.industryDao = industryDao;
	}

	public String getOneIndustry()
	{
		// TODO Auto-generated method stub
		return industryDao.getOneIndustry();
	}

	public String getTwoIndustry(String oneIndustry)
	{
		// TODO Auto-generated method stub
		return industryDao.getTwoIndustry(oneIndustry);
	}

	public String getThreeIndustry(String twoIndustry)
	{
		// TODO Auto-generated method stub
		return industryDao.getThreeIndustry(twoIndustry);
	}
}
