package com.ssh.orm;

/**
 * Guanli entity. @author MyEclipse Persistence Tools
 */

public class Guanli implements java.io.Serializable
{

	// Fields

	private String idcode;
	private String idname;

	// Constructors

	/** default constructor */
	public Guanli()
	{
	}

	/** full constructor */
	public Guanli(String idcode, String idname)
	{
		this.idcode = idcode;
		this.idname = idname;
	}

	// Property accessors

	public String getIdcode()
	{
		return this.idcode;
	}

	public void setIdcode(String idcode)
	{
		this.idcode = idcode;
	}

	public String getIdname()
	{
		return this.idname;
	}

	public void setIdname(String idname)
	{
		this.idname = idname;
	}

}