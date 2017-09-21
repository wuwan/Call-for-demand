package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbAdministrator entity. @author MyEclipse Persistence Tools
 */

public class TbAdministrator implements java.io.Serializable
{

	// Fields

	private String number;
	private String account;
	private String name;
	private String address;
	private String poster;
	private String password;
	private String role;
	private Set<SysRole> sysRole = new HashSet<SysRole>();

	// Constructors

	/** default constructor */
	public TbAdministrator()
	{
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPoster()
	{
		return poster;
	}

	public void setPoster(String poster)
	{
		this.poster = poster;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public Set<SysRole> getSysRole()
	{
		return sysRole;
	}

	public void setSysRole(Set<SysRole> sysRole)
	{
		this.sysRole = sysRole;
	}

	@Override
	public String toString()
	{
		return "TbAdministrator [number=" + number + ", account=" + account
				+ ", name=" + name + ", address=" + address + ", poster="
				+ poster + ", password=" + password + ", role=" + role
				+ ", sysRole=" + sysRole + "]";
	}

}