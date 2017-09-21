package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole{

	// Fields

	private String roleId;
	private String rolename;
	private Set <SysRight> sysRight= new HashSet<SysRight>();

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String roleId) {
		this.roleId = roleId;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<SysRight> getSysRight() {
		return sysRight;
	}

	public void setSysRight(Set<SysRight> sysRight) {
		this.sysRight = sysRight;
	}

}