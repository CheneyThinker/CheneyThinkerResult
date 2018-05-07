package com.cheney.thinker.result.utils;

import java.util.regex.Pattern;

public final class CheckUtils {
	
	private static final String IDCARD_REGEX 	= "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
	private static final String EMAIL_REGEX 	= "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	private static final String CHINA_REGEX 	= "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
	private static final String HK_REGEX 		= "^(5|6|8|9)\\d{7}$";
	
	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
	
	public static void checkArgument(Object str) {
		if (isEmpty(str)) {
			throw new IllegalArgumentException("Illegal Argument!");
		}
	}
	
	public static String getMessageOrDefault(Exception e, String defaultMessage) {
		return (isEmpty(e.getMessage()) ? defaultMessage : e.getMessage());
	}
	
	public static boolean isIdCard(String idCard) {
		checkArgument(idCard);
		return Pattern.matches(IDCARD_REGEX, idCard);
	}
	
	public static boolean isEmail(String email) {
		checkArgument(email);
		return Pattern.matches(EMAIL_REGEX, email);
	}
	
	public static boolean isPhone(String phone) {
		checkArgument(phone);
		return (isChinaPhone(phone) || isHKPhone(phone));
	}
	
	public static boolean isChinaPhone(String phone) {
		checkArgument(phone);
		return Pattern.matches(CHINA_REGEX, phone);
	}
	
	public static boolean isHKPhone(String phone) {
		checkArgument(phone);
		return Pattern.matches(HK_REGEX, phone);
    }
	
}
