package com.ssh.orm;

/**
 * TbGovBelong entity. @author MyEclipse Persistence Tools
 */

public class TbGovBelong implements java.io.Serializable
{

	// Fields

	private String cborder;
	private String cbnumber;
	private String cbid;
	private String state;
	private String state1;
	private String cbAccount;

	// Constructors

	/** default constructor */
	public TbGovBelong()
	{
	}

	/** minimal constructor */
	public TbGovBelong(String cborder, String cbnumber, String cbid)
	{
		this.cborder = cborder;
		this.cbnumber = cbnumber;
		this.cbid = cbid;
	}

	/** full constructor */
	public TbGovBelong(String cborder, String cbnumber, String cbid,
			String state, String state1, String cbAccount)
	{
		this.cborder = cborder;
		this.cbnumber = cbnumber;
		this.cbid = cbid;
		this.state = state;
		this.state1 = state1;
		this.cbAccount = cbAccount;
	}

	// Property accessors

	public String getCborder()
	{
		return this.cborder;
	}

	public void setCborder(String cborder)
	{
		this.cborder = cborder;
	}

	public String getCbnumber()
	{
		return this.cbnumber;
	}

	public void setCbnumber(String cbnumber)
	{
		this.cbnumber = cbnumber;
	}

	public String getCbid()
	{
		return this.cbid;
	}

	public void setCbid(String cbid)
	{
		this.cbid = cbid;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getState1()
	{
		return this.state1;
	}

	public void setState1(String state1)
	{
		this.state1 = state1;
	}

	public String getCbAccount()
	{
		return this.cbAccount;
	}

	public void setCbAccount(String cbAccount)
	{
		this.cbAccount = cbAccount;
	}

}