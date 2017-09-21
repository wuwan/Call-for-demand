package com.ssh.orm;

/**
 * TbBelong entity. @author MyEclipse Persistence Tools
 */

public class TbBelong implements java.io.Serializable
{

	// Fields

	private String tcode;
	private String trepresent;

	// Constructors

	/** default constructor */
	public TbBelong()
	{
	}

	/** minimal constructor */
	public TbBelong(String tcode)
	{
		this.tcode = tcode;
	}

	/** full constructor */
	public TbBelong(String tcode, String trepresent)
	{
		this.tcode = tcode;
		this.trepresent = trepresent;
	}

	// Property accessors

	public String getTcode()
	{
		return this.tcode;
	}

	public void setTcode(String tcode)
	{
		this.tcode = tcode;
	}

	public String getTrepresent()
	{
		return this.trepresent;
	}

	public void setTrepresent(String trepresent)
	{
		this.trepresent = trepresent;
	}

}