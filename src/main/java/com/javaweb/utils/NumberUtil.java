package com.javaweb.utils;

public class NumberUtil {
	
	public static boolean isNum(String s) {
		try {
			Integer num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
