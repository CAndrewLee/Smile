package com.somnus.support.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title: ValidateUtil
 * @Description: 报文验证工具类
 * @author: cjliu modify by caobin - using commons-lang3
 * @date: 2012-9-19下午7:19:59
 * @version: 1.0
 */
public class ValidateUtil {
	/**
	 * @Description: 判断字符串是否为空串(null or "" or空白串)
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isEmpty(String str) {
		String vstr = StringUtils.trim(str);
		return ((vstr == null) || (vstr.length() == 0));
	}

	/**
	 * @Description: 判断字符串长度是否大于指定的长度
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isGreatLenth(String str, int length) {
		String vstr = StringUtils.trimToEmpty(str);
		return vstr.length() > length ? true : false;
	}

	/**
	 * @Description: 判断字符串长度是否小于指定的长度
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isLessLenth(String str, int length) {
		String vstr = StringUtils.trimToEmpty(str);
		return vstr.length() < length ? true : false;
	}

	/**
	 * @Description: 判断字符串长度是否等于指定的长度
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isEqualLenth(String str, int length) {
		String vstr = StringUtils.trimToEmpty(str);
		return vstr.length() == length ? true : false;
	}

	/**
	 * @Description: 判断字符串是否是一个有效的指定格式日期
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isDate(String str, String fmt) {
		boolean flag = true;
		// 输入格式
		DateFormat formater = new SimpleDateFormat(fmt);
		try {
			formater.parse(str);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * @Description: 判断字符串是否有效的金额
	 * @param str
	 * @return boolean
	 * @throws
	 */
	public static boolean isAmt(String str) {
		return str.matches("^(-)?(([1-9]{1}\\d{0,19})|([0]{1}))(\\.(\\d){1,4})?$");
	}

	/**
	 * @Title:isInterger
	 * @Description:是否是数字
	 * @param @param src
	 * @param @param name 设定文件
	 * @return void
	 * @throws
	 */
	public static boolean isInterger(Object obj) {
		return ((String) obj).matches("[1-9][0-9]*");
	}

	/**
	 * @Description: 检查URL是否合法
	 * @param value
	 * @return boolean true 空
	 * @throws
	 */
	public boolean isURL(String value) {
		return value.matches("[a-zA-z]+://[^\\s]*");
	}

	/**
	 * @Description: 检查ip是否合法
	 * @param value
	 * @return boolean true 空
	 * @throws
	 */
	public boolean isIP(String value) {
		return value.matches("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}");
	}

	/**
	 * 判断日期格式:yyyy-mm-dd
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isValidDate(String date) {
		return date.matches("20[0-3][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))");
	}

	/**
	 * 判断日期时间格式:yyyy-mm-dd HH:mm:ss
	 * 
	 * @param dateTime
	 * @return
	 */
	public static boolean isValidDateTime(String dateTime) {
		return dateTime.matches("^(((20[0-3][0-9]-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|(20[0-3][0-9]-(0[2469]|11)-(0[1-9]|[12][0-9]|30))) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$");
	}
	
	/**
	 * 判断时间格式:HH:mm:ss
	 * 
	 * @Title:isValidTime
	 * @param time
	 * @return
	 * @return boolean
	 */
	public static boolean isValidTime(String time) {
		return time.matches("^((20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$");
	}
}
