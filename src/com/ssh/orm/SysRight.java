package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRight implements java.io.Serializable
{

	// Fields

	private String rightId;
	private String rightname;
	private Set sysRoleRights = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRight()
	{
	}

	/** minimal constructor */
	public SysRight(String rightId, String rightname)
	{
		this.rightId = rightId;
		this.rightname = rightname;
	}

	/** full constructor */
	public SysRight(String rightId, String rightname, Set sysRoleRights)
	{
		this.rightId = rightId;
		this.rightname = rightname;
		this.sysRoleRights = sysRoleRights;
	}

	// Property accessors

	public String getRightId()
	{
		return this.rightId;
	}

	public void setRightId(String rightId)
	{
		this.rightId = rightId;
	}

	public String getRightname()
	{
		return this.rightname;
	}

	public void setRightname(String rightname)
	{
		this.rightname = rightname;
	}

	public Set getSysRoleRights()
	{
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights)
	{
		this.sysRoleRights = sysRoleRights;
	}

}