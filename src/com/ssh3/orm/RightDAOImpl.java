package com.ssh3.orm;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh3.orm.RightDAOImpl;
import com.ssh.orm.SysRight;

public class RightDAOImpl extends HibernateDaoSupport{

	public void save(SysRight srt) {
		this.getHibernateTemplate().save(srt);
	}

	@SuppressWarnings("unchecked")
	public List<SysRight> findAll() {
		String hql = "from SysRight srt order by srt.rightId";
		return (List<SysRight>) this.getHibernateTemplate().find(hql);
	}

	public void remove(SysRight srt) {
		this.getHibernateTemplate().delete(srt);
	}

	public void update(SysRight srt) {
		this.getHibernateTemplate().update(srt);
	}
	@SuppressWarnings("unchecked")
	public List<SysRight> findByHql(String hql, Object... objects) {
		System.out.println("到了DAO");
		return (List<SysRight>) this.getHibernateTemplate().find(hql);
//		return (List<SysRight>) this.getHibernateTemplate().find(hql,objects);
	}

}
