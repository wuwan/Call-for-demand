package com.ssh.orm;

/**
 * Reject entity. @author MyEclipse Persistence Tools
 */

public class Reject implements java.io.Serializable
{

	// Fields

	private String crorder;
	private String re1;
	private String re2;
	private String cause;
	private String RAccount;

	// Constructors

	/** default constructor */
	public Reject()
	{
	}

	/** minimal constructor */
	public Reject(String crorder)
	{
		this.crorder = crorder;
	}

	/** full constructor */
	public Reject(String crorder, String re1, String re2, String cause,
			String RAccount)
	{
		this.crorder = crorder;
		this.re1 = re1;
		this.re2 = re2;
		this.cause = cause;
		this.RAccount = RAccount;
	}

	// Property accessors

	public String getCrorder()
	{
		return this.crorder;
	}

	public void setCrorder(String crorder)
	{
		this.crorder = crorder;
	}

	public String getRe1()
	{
		return this.re1;
	}

	public void setRe1(String re1)
	{
		this.re1 = re1;
	}

	public String getRe2()
	{
		return this.re2;
	}

	public void setRe2(String re2)
	{
		this.re2 = re2;
	}

	public String getCause()
	{
		return this.cause;
	}

	public void setCause(String cause)
	{
		this.cause = cause;
	}

	public String getRAccount()
	{
		return this.RAccount;
	}

	public void setRAccount(String RAccount)
	{
		this.RAccount = RAccount;
	}

}