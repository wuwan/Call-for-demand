package com.ssh3.orm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.orm.TbGovBelong;


public class DemandDAOImpl extends HibernateDaoSupport{
	
	public void saveDemand(TbGovBelong demand) {
		this.getHibernateTemplate().save(demand);
	}
	@SuppressWarnings("unchecked")
	public List<TbGovBelong> findAllDemand() {
		String hql = "from TbGovBelong tb";
		return (List<TbGovBelong>) this.getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<TbGovBelong> AllDemand(TbGovBelong tb,String order,String zzbm,String tbjg,String state,String key1,String key2,String key3) throws Exception{
		Set<TbGovBelong> sets=new HashSet<TbGovBelong>();
		StringBuffer hql=new StringBuffer();
		hql.append("from TbGovBelong tb where cbid like '").append("%'");
		
		if(tb.getCborder()!=null&&!tb.getCborder().equals("")){
			if("%".equals(order))
				hql.append("and tb.cborder like '%").append(tb.getCborder()).append("%'");
			else
				hql.append("and tb.cborder='").append(tb.getCborder()).append("'");			
		}
		if(tb.getCbid()!=null&&!tb.getCbid().equals("")){
			if("%".equals(zzbm))
				hql.append(key1).append(" tb.cbid like '%").append(tb.getCbid()).append("%'");
			else
				hql.append(key1).append(" tb.cbid='").append(tb.getCbid()).append("'");
		}
		if(tb.getState()!=null&&!tb.getState().equals("")){
			if("%".equals(state))
				hql.append(key3).append(" tb.state like '%").append(tb.getState()).append("%'");
			else
			    hql.append(key3).append(" tb.state='").append(tb.getState()).append("'");
		}
		if(tb.getCbAccount()!=null&&!tb.getCbAccount().equals("")){
			if("%".equals(tbjg))
				hql.append(key2).append(" tb.cbAccount like '%").append(tb.getCbAccount()).append("%'");
			else
			    hql.append(key2).append(" tb.cbAccount='").append(tb.getCbAccount()).append("'");
		}
		
		String s=hql.toString();
		System.out.println("查询"+s);
		return (List<TbGovBelong>) this.getHibernateTemplate().find(hql.toString());
	}
	
	public void removeDemand(TbGovBelong demand) {
		this.getHibernateTemplate().delete(demand);
	}
	public void updateDemand(TbGovBelong demand) {
		this.getHibernateTemplate().update(demand);
	}
	public TbGovBelong findDemandByName(String name) {
		TbGovBelong demand = (TbGovBelong) this.getHibernateTemplate().get(TbGovBelong.class, name);

		return demand;
	}
}