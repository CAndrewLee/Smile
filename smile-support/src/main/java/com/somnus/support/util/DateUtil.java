package com.somnus.support.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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

		@SuppressWarnings("unused")
		private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/**
		 * @Title: stringTostring
		 * @Description: yyyyMMdd 转换为 yyyy-MM-dd
		 * @param @param str 
		 * @param @return 
		 * @return String 
		 * @throws
		 */
		public static String stringTostring(String str){
			SimpleDateFormat sf1 = new SimpleDateFormat(FORMAT_FOUR_NO);
			SimpleDateFormat sf2 =new SimpleDateFormat(FORMAT_FOUR);
			String sfstr = "";
			try 
			{
				sfstr = sf2.format(sf1.parse(str));
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return sfstr;
		}

		/**
		 * 把符合日期格式的字符串转换为日期类型
		 */
		public static java.util.Date stringtoDate(String dateStr, String format)
		{
			Date d = null;
			SimpleDateFormat formater = new SimpleDateFormat(format);
			try
			{
				formater.setLenient(false);//指定日期\时间解析是否不严格
				d = formater.parse(dateStr);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return d;
		}

		/**
		 * 把符合日期格式的字符串转换为日期类型
		 * ParsePosition(1) 从第几位开始处理
		 */
		public static java.util.Date stringtoDate(String dateStr, String format,ParsePosition pos)
		{
			Date d = null;
			SimpleDateFormat formater = new SimpleDateFormat(format);
			try
			{
				formater.setLenient(false);
				d = formater.parse(dateStr, pos);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return d;
		}

		/**
		 * 把日期转换为字符串
		 */
		public static String dateToString(java.util.Date date, String format)
		{
			String result = "";
			SimpleDateFormat formater = new SimpleDateFormat(format);
			try
			{
				result = formater.format(date);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return result;
		}

		/**
		 * @param dateKind 指定处理年、月、日
		 * @param dateStr 指定日期
		 * @param amount 指定长度
		 * @return
		 */
		public static String dateSub(int dateKind, String dateStr, int amount)
		{
			Date date = stringtoDate(dateStr, FORMAT_ONE);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateKind, amount);
			return dateToString(calendar.getTime(), FORMAT_ONE);
		}
		
		/**
		 * 
		 * @param days
		 * @return 返回一个相加减后的日期 yyyy-MM-dd
		 */
		public static String dateSub(int days)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, days);
			return dateToString(calendar.getTime(), FORMAT_FOUR);
		}

		/**
		 * 两个日期相减
		 * 
		 * @return 相减得到的秒数
		 */
		public static long timeSub(String firstTime, String secTime)
		{
			long first = stringtoDate(firstTime, FORMAT_ONE).getTime();
			long second = stringtoDate(secTime, FORMAT_ONE).getTime();
			return (second - first) / 1000;
		}

		
		/**
		 * 获取某年某月的天数 Method1
		 */
		public static int getDaysOfMonth(String year, String month)
		{
			Date date = stringtoDate(year+"-"+month, FORMAT_FIVE);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		/**
		 * 获取某年某月的天数 Method2
		 */
		public static int getDaysOfMonth(int year, int month)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, 1);
			return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		/**
		 * 返回日期的年
		 */
		public static int getYear(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.YEAR);
		}
		/**
		 * 返回当前年份
		 */
		public static int getTodayYear()
		{
			return getYear(new Date());
		}
		
		/**
		 * 返回日期的月份，1-12
		 */
		public static int getMonth(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.MONTH) + 1;
		}
		
		/**
		 * 返回当前月份
		 */
		public static int getTodayMonth()
		{
			return getMonth(new Date());
		}

		/**
		 * 返回日期的日1-31
		 */
		public static int getDay(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DATE);
		}
		/**
		 * 返回当前日期的日
		 */
		public static int getTodayday()
		{
			return getDay(new Date());
		}
		/**
		 * 返回日期的时
		 */
		public static int getHour(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.HOUR);
		}
		/**
		 * 返回日期的分
		 */
		public static int getMinute(Date date)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.MINUTE);
		}
		/**
		 * 返回日期的秒
		 */
		public static int getSecond(Date date)
		{
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

		/**
		 * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
		 */
		public static long dayDiff(Date date1, Date date2)
		{
			return (date2.getTime() - date1.getTime()) / 86400000;
		}

		/**
		 * 比较两个日期的年差
		 */
		public static int yearDiff(String before, String after)
		{
			Date beforeDay = stringtoDate(before, FORMAT_FOUR);
			Date afterDay = stringtoDate(after, FORMAT_FOUR);
			return getYear(afterDay) - getYear(beforeDay);
		}

		/**
		 * 比较指定日期与当前日期的差
		 */
		public static int yearDiffCurr(String after)
		{
			return yearDiff(getNow(),after);
		}

		/**
		 *获取当前日期字符串，格式"yyyy-MM-dd HH:mm:ss"
		 * 
		 * @return
		 */
		public static String getNow()
		{
			Calendar today = Calendar.getInstance();
			return dateToString(today.getTime(), FORMAT_ONE);
		}
		
		/**
		 * 获取当前时间的指定格式
		 */
		public static String getCurrDate(String format)
		{
			return dateToString(new Date(), format);
		}
		/**
		 * 判断日期是否有效,包括闰年的情况
		 * 
		 * @param date
		 *            YYYY-mm-dd
		 * @return
		 */
		public static boolean isDate(String date)
		{
			StringBuffer reg = new StringBuffer(
					"^((\\d{2}(([02468][048])|([13579][26]))-?((((0?");
			reg.append("[13578])|(1[02]))-?((0?[1-9])|([1-2][0-9])|(3[01])))");
			reg.append("|(((0?[469])|(11))-?((0?[1-9])|([1-2][0-9])|(30)))|");
			reg.append("(0?2-?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12");
			reg.append("35679])|([13579][01345789]))-?((((0?[13578])|(1[02]))");
			reg.append("-?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))");
			reg.append("-?((0?[1-9])|([1-2][0-9])|(30)))|(0?2-?((0?[");
			reg.append("1-9])|(1[0-9])|(2[0-8]))))))");
			Pattern p = Pattern.compile(reg.toString());
			return p.matcher(date).matches();
		}
////////////////////////////////////////////////////////////////////////
	/**
	 * @Description: 获取当前系统日期 格式:yyyy-mm-dd
	 * @return String 日期字符串
	 * @throws
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}

	/**
	 * @Title: getDate
	 * @Description: 获取当前系统日期 格式:yyyymmdd
	 * @return String
	 * @throws
	 */
	public static String getDate() {
		return getCurrentDate("yyyyMMdd");
	}

	/**
	 * 
	 * @Description: 获取当前系统日期
	 * @param format
	 *            日期格式
	 * @return String 日期字符串
	 * @throws
	 */
	public static String getCurrentDate(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * @Description: 获取当前系统时间 格式:HH:mm:ss
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTime() {
		return getCurrentDate("HH:mm:ss");
	}

	/**
	 * 
	 * @Description: 获取当前系统时间
	 * @param format
	 *            时间格式
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTime(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * @Description: 获取当前系统时间戳 格式:yyyy-mm-dd HH:mm:ss
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTimeStamp() {
		return getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}


	/**
	 * 
	 * @Description: 获取当前系统时间戳
	 * @param format
	 *            时间格式
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTimeStamp(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * 
	 * @Description: 获取当前日期时间字符串
	 * @param format
	 *            日期时间格式
	 * @return String 日期时间字符串
	 * @throws
	 */
	public static String getCurrentDateTimeStr(String format) {
		DateFormat formater = new SimpleDateFormat(format);
		return formater.format(new Date());
	}

	/**
	 * @Title:sourcePlusInterval
	 * @Description:日期增加
	 * @param source
	 * @param interval
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public static String sourcePlusInterval(String source, int interval) {
		DateFormat informater = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(informater.parse(source));
		} catch (ParseException e) {

		}
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + interval);
		return informater.format(calendar.getTime());
	}
	
	/**
	 * addMonth
	 * @Description:日期增加-周增加
	 * @param day
	 * @param amount
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public static String addWeek(String day, int amount) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(day);
		} catch (ParseException e) {
		}
		return sdf.format(DateUtils.addWeeks(date, amount));
	}
	
	
	/**
	 * addMonth
	 * @Description:日期增加-月增加
	 * @param day
	 * @param amount
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public static String addMonth(String day, int amount) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(day);
		} catch (ParseException e) {
		}
		return sdf.format(DateUtils.addMonths(date, amount));
	}
	
	/**
	 * addMonth
	 * @Description:日期增加-年增加
	 * @param day
	 * @param amount
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public static String addYear(String day, int amount) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(day);
		} catch (ParseException e) {
		}
		return sdf.format(DateUtils.addYears(date, amount));
	}
	

	/**
	 * 
	 * @Description: 将字符串从一种格式转化的
	 * @param @param source 日期原串
	 * @param @param infmt 日期输入格式
	 * @param @param outfmt 日期输出格式
	 * @param @return 目标日期字符串
	 * @throws java.text.ParseException
	 */
	public static String getFmtDate(String source, String infmt, String outfmt)
			throws ParseException {
		// 输入格式
		DateFormat informater = new SimpleDateFormat(infmt);
		// 输出格式
		DateFormat outfomater = new SimpleDateFormat(outfmt);

		return outfomater.format(informater.parse(source));
	}

	/**
	 * 
	 * @Description: 将字符串从一种格式转化的
	 * @param @param source 日期原串
	 * @param @param infmt 日期输入格式
	 * @param @param outfmt 日期输出格式
	 * @param @return 目标日期字符串
	 * @throws java.text.ParseException
	 */
	public static String getFmtDateStr(String source, String infmt,
			String outfmt) {
		String result = "";
		try {
			// 输入格式
			DateFormat informater = new SimpleDateFormat(infmt);
			// 输出格式
			DateFormat outfomater = new SimpleDateFormat(outfmt);

			result = outfomater.format(informater.parse(source));

		} catch (Exception e) {
			result = source;
		}

		return result;
	}
	/**
	 * 将日期转换为字符串
	 * @param source
	 * @param outfmt
	 * @return
	 */
	public static String getDateFmtStr(Date source,
			String outfmt) {
		String result = "";
		// 输出格式
		DateFormat outfomater = new SimpleDateFormat(outfmt);
		try {
			result = outfomater.format(source);
		} catch (Exception e) {
			result = outfomater.format(new Date());;
		}

		return result;
	}

	/**
	 * @Title:getAppointDay
	 * @Description:TODO(得到指定日期)
	 * @param @param num
	 * @param @param fmt
	 * @param @return 设定文件
	 * @return String
	 * @throws
	 * 
	 * @param num
	 * @param fmt
	 * @return
	 */
	public static String getAppointDay(String fmt, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num);
		Date tmp = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		String date = sdf.format(tmp);
		return date;
	}
	
	public static long getBetweenDays(Date d1, Date d2){
		long n1 = d1.getTime();
		long n2 = d2.getTime();
		long diff = Math.abs(n1 - n2);
		diff /= 3600 * 1000 * 24;
		return diff;
	}

}
