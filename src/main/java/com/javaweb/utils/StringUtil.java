package com.javaweb.utils;

public class StringUtil {
	
	public static boolean isString(String s) {
		if(s != null && !s.equals("")) return true;
		return false;
	}
}
