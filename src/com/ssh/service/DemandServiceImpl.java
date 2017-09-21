package com.ssh.service;
import java.util.List;

import com.ssh3.orm.DemandDAOImpl;

import com.ssh.orm.TbGovBelong;

public class DemandServiceImpl{
	private DemandDAOImpl demandDao;
	
	public DemandDAOImpl getDemandDao()
	{
		return demandDao;
	}


	public void setDemandDao(DemandDAOImpl demandDao)
	{
		this.demandDao = demandDao;
	}


	public void save(TbGovBelong demand) {
		this.demandDao.saveDemand(demand); 
		System.out.println("save+dao");
	}
	
	
	public List<TbGovBelong> findAll() {
		return this.demandDao.findAllDemand();
	}
//////////////////////////////////////////////////////////////////////////////////////
	public List<TbGovBelong> query(TbGovBelong tb,String order,String zzbm,String tbjg,String state,String key1,String key2,String key3) throws Exception{
		return this.demandDao.AllDemand(tb,order,zzbm,tbjg,state,key1,key2,key3);
	}
	
	public void delete(TbGovBelong demand) {
		this.demandDao.removeDemand(demand);
	}
	public void update(TbGovBelong demand) {
		this.demandDao.updateDemand(demand);
	}
	public TbGovBelong findByName(String name) {
		return this.demandDao.findDemandByName(name);
	}
}