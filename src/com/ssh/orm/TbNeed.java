package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbNeed entity. @author MyEclipse Persistence Tools
 */

public class TbNeed implements java.io.Serializable
{

	// Fields

	private String CNumber;
	private String name;
	private String address;
	private String CWebsite;
	private String CEmail;
	private String CRepresent;
	private String poster;
	private String CConnect;
	private String CStand;
	private String CPhone;
	private String CFax;
	private String CNature;
	private String CBelong;
	private String CIntroduce;
	private String CNeedName;
	private String CImportant;
	private String CKey;
	private String CResearch;
	private String CStudy;
	private String CNeedBelong;
	private String CApplication;
	private String CCompany;
	private String CUnit;
	private String CMoneyTotal;
	private String CMoneySelf;
	private String CMoneyLoad;
	private String CMoneyElse;
	private String CStart;
	private String CEnd;
	private String CKey1;
	private String CKey2;
	private String CKey3;
	private String CKey4;
	private String number;
	private Set tbNumbers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbNeed()
	{
	}

	/** minimal constructor */
	public TbNeed(String CNumber, String name, String address, String CWebsite,
			String CEmail, String CRepresent, String poster, String CConnect,
			String CStand, String CPhone, String CFax, String CNature,
			String CBelong, String CNeedName, String CImportant, String CKey,
			String CResearch, String CStudy, String CNeedBelong,
			String CApplication, String CCompany, String CUnit,
			String CMoneySelf, String CMoneyElse)
	{
		this.CNumber = CNumber;
		this.name = name;
		this.address = address;
		this.CWebsite = CWebsite;
		this.CEmail = CEmail;
		this.CRepresent = CRepresent;
		this.poster = poster;
		this.CConnect = CConnect;
		this.CStand = CStand;
		this.CPhone = CPhone;
		this.CFax = CFax;
		this.CNature = CNature;
		this.CBelong = CBelong;
		this.CNeedName = CNeedName;
		this.CImportant = CImportant;
		this.CKey = CKey;
		this.CResearch = CResearch;
		this.CStudy = CStudy;
		this.CNeedBelong = CNeedBelong;
		this.CApplication = CApplication;
		this.CCompany = CCompany;
		this.CUnit = CUnit;
		this.CMoneySelf = CMoneySelf;
		this.CMoneyElse = CMoneyElse;
	}

	/** full constructor */
	public TbNeed(String CNumber, String name, String address, String CWebsite,
			String CEmail, String CRepresent, String poster, String CConnect,
			String CStand, String CPhone, String CFax, String CNature,
			String CBelong, String CIntroduce, String CNeedName,
			String CImportant, String CKey, String CResearch, String CStudy,
			String CNeedBelong, String CApplication, String CCompany,
			String CUnit, String CMoneyTotal, String CMoneySelf,
			String CMoneyLoad, String CMoneyElse, String CStart, String CEnd,
			String CKey1, String CKey2, String CKey3, String CKey4,
			String number, Set tbNumbers)
	{
		this.CNumber = CNumber;
		this.name = name;
		this.address = address;
		this.CWebsite = CWebsite;
		this.CEmail = CEmail;
		this.CRepresent = CRepresent;
		this.poster = poster;
		this.CConnect = CConnect;
		this.CStand = CStand;
		this.CPhone = CPhone;
		this.CFax = CFax;
		this.CNature = CNature;
		this.CBelong = CBelong;
		this.CIntroduce = CIntroduce;
		this.CNeedName = CNeedName;
		this.CImportant = CImportant;
		this.CKey = CKey;
		this.CResearch = CResearch;
		this.CStudy = CStudy;
		this.CNeedBelong = CNeedBelong;
		this.CApplication = CApplication;
		this.CCompany = CCompany;
		this.CUnit = CUnit;
		this.CMoneyTotal = CMoneyTotal;
		this.CMoneySelf = CMoneySelf;
		this.CMoneyLoad = CMoneyLoad;
		this.CMoneyElse = CMoneyElse;
		this.CStart = CStart;
		this.CEnd = CEnd;
		this.CKey1 = CKey1;
		this.CKey2 = CKey2;
		this.CKey3 = CKey3;
		this.CKey4 = CKey4;
		this.number = number;
		this.tbNumbers = tbNumbers;
	}

	// Property accessors

	public String getCNumber()
	{
		return this.CNumber;
	}

	public void setCNumber(String CNumber)
	{
		this.CNumber = CNumber;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCWebsite()
	{
		return this.CWebsite;
	}

	public void setCWebsite(String CWebsite)
	{
		this.CWebsite = CWebsite;
	}

	public String getCEmail()
	{
		return this.CEmail;
	}

	public void setCEmail(String CEmail)
	{
		this.CEmail = CEmail;
	}

	public String getCRepresent()
	{
		return this.CRepresent;
	}

	public void setCRepresent(String CRepresent)
	{
		this.CRepresent = CRepresent;
	}

	public String getPoster()
	{
		return this.poster;
	}

	public void setPoster(String poster)
	{
		this.poster = poster;
	}

	public String getCConnect()
	{
		return this.CConnect;
	}

	public void setCConnect(String CConnect)
	{
		this.CConnect = CConnect;
	}

	public String getCStand()
	{
		return this.CStand;
	}

	public void setCStand(String CStand)
	{
		this.CStand = CStand;
	}

	public String getCPhone()
	{
		return this.CPhone;
	}

	public void setCPhone(String CPhone)
	{
		this.CPhone = CPhone;
	}

	public String getCFax()
	{
		return this.CFax;
	}

	public void setCFax(String CFax)
	{
		this.CFax = CFax;
	}

	public String getCNature()
	{
		return this.CNature;
	}

	public void setCNature(String CNature)
	{
		this.CNature = CNature;
	}

	public String getCBelong()
	{
		return this.CBelong;
	}

	public void setCBelong(String CBelong)
	{
		this.CBelong = CBelong;
	}

	public String getCIntroduce()
	{
		return this.CIntroduce;
	}

	public void setCIntroduce(String CIntroduce)
	{
		this.CIntroduce = CIntroduce;
	}

	public String getCNeedName()
	{
		return this.CNeedName;
	}

	public void setCNeedName(String CNeedName)
	{
		this.CNeedName = CNeedName;
	}

	public String getCImportant()
	{
		return this.CImportant;
	}

	public void setCImportant(String CImportant)
	{
		this.CImportant = CImportant;
	}

	public String getCKey()
	{
		return this.CKey;
	}

	public void setCKey(String CKey)
	{
		this.CKey = CKey;
	}

	public String getCResearch()
	{
		return this.CResearch;
	}

	public void setCResearch(String CResearch)
	{
		this.CResearch = CResearch;
	}

	public String getCStudy()
	{
		return this.CStudy;
	}

	public void setCStudy(String CStudy)
	{
		this.CStudy = CStudy;
	}

	public String getCNeedBelong()
	{
		return this.CNeedBelong;
	}

	public void setCNeedBelong(String CNeedBelong)
	{
		this.CNeedBelong = CNeedBelong;
	}

	public String getCApplication()
	{
		return this.CApplication;
	}

	public void setCApplication(String CApplication)
	{
		this.CApplication = CApplication;
	}

	public String getCCompany()
	{
		return this.CCompany;
	}

	public void setCCompany(String CCompany)
	{
		this.CCompany = CCompany;
	}

	public String getCUnit()
	{
		return this.CUnit;
	}

	public void setCUnit(String CUnit)
	{
		this.CUnit = CUnit;
	}

	public String getCMoneyTotal()
	{
		return this.CMoneyTotal;
	}

	public void setCMoneyTotal(String CMoneyTotal)
	{
		this.CMoneyTotal = CMoneyTotal;
	}

	public String getCMoneySelf()
	{
		return this.CMoneySelf;
	}

	public void setCMoneySelf(String CMoneySelf)
	{
		this.CMoneySelf = CMoneySelf;
	}

	public String getCMoneyLoad()
	{
		return this.CMoneyLoad;
	}

	public void setCMoneyLoad(String CMoneyLoad)
	{
		this.CMoneyLoad = CMoneyLoad;
	}

	public String getCMoneyElse()
	{
		return this.CMoneyElse;
	}

	public void setCMoneyElse(String CMoneyElse)
	{
		this.CMoneyElse = CMoneyElse;
	}

	public String getCStart()
	{
		return this.CStart;
	}

	public void setCStart(String CStart)
	{
		this.CStart = CStart;
	}

	public String getCEnd()
	{
		return this.CEnd;
	}

	public void setCEnd(String CEnd)
	{
		this.CEnd = CEnd;
	}

	public String getCKey1()
	{
		return this.CKey1;
	}

	public void setCKey1(String CKey1)
	{
		this.CKey1 = CKey1;
	}

	public String getCKey2()
	{
		return this.CKey2;
	}

	public void setCKey2(String CKey2)
	{
		this.CKey2 = CKey2;
	}

	public String getCKey3()
	{
		return this.CKey3;
	}

	public void setCKey3(String CKey3)
	{
		this.CKey3 = CKey3;
	}

	public String getCKey4()
	{
		return this.CKey4;
	}

	public void setCKey4(String CKey4)
	{
		this.CKey4 = CKey4;
	}

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public Set getTbNumbers()
	{
		return this.tbNumbers;
	}

	public void setTbNumbers(Set tbNumbers)
	{
		this.tbNumbers = tbNumbers;
	}

}