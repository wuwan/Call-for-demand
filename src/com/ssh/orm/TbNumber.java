package com.ssh.orm;

/**
 * TbNumber entity. @author MyEclipse Persistence Tools
 */

public class TbNumber implements java.io.Serializable
{

	// Fields

	private String number;
	private TbAdministrator tbAdministrator;
	private TbNeed tbNeed;
	private String state;

	// Constructors

	/** default constructor */
	public TbNumber()
	{
	}

	/** full constructor */
	public TbNumber(String number, TbAdministrator tbAdministrator,
			TbNeed tbNeed, String state)
	{
		this.number = number;
		this.tbAdministrator = tbAdministrator;
		this.tbNeed = tbNeed;
		this.state = state;
	}

	// Property accessors

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public TbAdministrator getTbAdministrator()
	{
		return this.tbAdministrator;
	}

	public void setTbAdministrator(TbAdministrator tbAdministrator)
	{
		this.tbAdministrator = tbAdministrator;
	}

	public TbNeed getTbNeed()
	{
		return this.tbNeed;
	}

	public void setTbNeed(TbNeed tbNeed)
	{
		this.tbNeed = tbNeed;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

}