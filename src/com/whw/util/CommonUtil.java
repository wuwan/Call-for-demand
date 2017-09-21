package com.whw.util;

import java.io.UnsupportedEncodingException;

public class CommonUtil
{
	public static String changeCode(String str)
	{
		String returnData = null;
		try
		{
			returnData = new String(str.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnData;
	}
}
