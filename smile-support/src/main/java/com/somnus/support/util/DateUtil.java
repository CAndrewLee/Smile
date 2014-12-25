package com.somnus.support.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {
	// 格式：年－月－日 小时：分钟：秒
		public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

		// 格式：年－月－日 小时：分钟
		public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

		// 格式：年月日 小时分钟秒
		public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

		// 格式：年－月－日
		public static final String FORMAT_FOUR = "yyyy-MM-dd";
		
		// 格式：年月日
		public static final String FORMAT_FOUR_NO = "yyyyMMdd";
		
		// 格式：年－月
		public static final String FORMAT_FIVE = "yyyy-MM";

		// 格式：年月
		public static final String FORMAT_SIX = "yyyyMM";

		static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
				"星期五", "星期六" };
		/**
		 *获取当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
		 * 
		 * @return
		 */
		public static String getNow(){
			Calendar today = Calendar.getInstance();
			return dateToString(today.getTime(), FORMAT_ONE);
		}
		
		/**
		 * 获取当前时间的指定格式
		 */
		public static String getCurrDate(String format){
			return dateToString(new Date(), format);
		}
		
		/**
		 * 把符合日期格式的字符串转换为日期类型
		 */
		public static Date stringtoDate(String dateStr){
			Date date = null;
			try {
				date = DateUtils.parseDate(dateStr, new String[] 
						{ "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd", "yyyy/MM/dd","yyyy-MM" });
			} catch (ParseException e) {
				throw new RuntimeException(e.getMessage(), e);  
			}
			return date;
		}

		/**
		 * 把日期转换为字符串
		 */
		public static String dateToString(Date date, String format){
			return DateFormatUtils.format(date, format);
		}
		
		public static String addDays(String day, int amount){
			Date date = DateUtils.addDays(stringtoDate(day), amount);
			return dateToString(date,DateUtil.FORMAT_FOUR);
		}
		public static String addWeeks(String day, int amount){
			Date date = DateUtils.addWeeks(stringtoDate(day), amount);
			return dateToString(date,DateUtil.FORMAT_FOUR);
		}
		public static String addMonths(String day, int amount){
			Date date = DateUtils.addMonths(stringtoDate(day), amount);
			return dateToString(date,DateUtil.FORMAT_FOUR);
		}
		public static String addYears(String day, int amount){
			Date date = DateUtils.addYears(stringtoDate(day), amount);
			return dateToString(date,DateUtil.FORMAT_FOUR);
		}
		
		/**
		 * 获取某年某月的天数 Method1
		 */
		public static int getDaysOfMonth(String year, String month){
			Date date = stringtoDate(year+"-"+month);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		/**
		 * 获取某年某月的天数 Method2
		 */
		public static int getDaysOfMonth(int year, int month){
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, 1);
			return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		/**
		 * 返回日期的年
		 */
		public static int getYear(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.YEAR);
		}
		/**
		 * 返回日期的月份，1-12
		 */
		public static int getMonth(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.MONTH) + 1;
		}

		/**
		 * 返回日期的日1-31
		 */
		public static int getDay(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DATE);
		}
		/**
		 * 返回日期的时
		 */
		public static int getHour(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.HOUR);
		}
		/**
		 * 返回日期的分
		 */
		public static int getMinute(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.MINUTE);
		}
		/**
		 * 返回日期的秒
		 */
		public static int getSecond(Date date){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.SECOND);
		}
		
		/**
		 * 返回日期在一个年中是第几天
		 */
		public static int getDayOfYear(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_YEAR);
		}
		/**
		 * 返回日期在一个月中是第几天
		 */
		public static int getDayOfMonth(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_MONTH);
		}
		/**
		 * 返回日期在一个周中是第几天
		 */
		public static int getDayOfWeek(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_WEEK)-1;
		}
		/**
		 * 返回日期在一个月中是第几周
		 */
		public static int getDayOfWeekInMonth(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		}
		/**
		 * 返回日期在一个年中是第几周
		 */
		public static int getWeekOfYear(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.WEEK_OF_YEAR);
		}

}
