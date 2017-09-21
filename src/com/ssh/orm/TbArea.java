package com.ssh.orm;

/**
 * TbArea entity. @author MyEclipse Persistence Tools
 */

public class TbArea implements java.io.Serializable
{

	// Fields

	private String ACode;
	private String ARepresent;

	// Constructors

	/** default constructor */
	public TbArea()
	{
	}

	/** full constructor */
	public TbArea(String ACode, String ARepresent)
	{
		this.ACode = ACode;
		this.ARepresent = ARepresent;
	}

	// Property accessors

	public String getACode()
	{
		return this.ACode;
	}

	public void setACode(String ACode)
	{
		this.ACode = ACode;
	}

	public String getARepresent()
	{
		return this.ARepresent;
	}

	public void setARepresent(String ARepresent)
	{
		this.ARepresent = ARepresent;
	}

}