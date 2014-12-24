package com.somnus.support.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import com.somnus.support.common.Constants;

/**   
 * @Title: SystemUtil
 * @Description: TODO
 * @author: cjliu
 * @date: 2012-9-13下午7:30:00
 * @version: 1.0  
 */
public class SystemUtil {
	private static String ip = null;
	private static String machine = null;

	private static void init(){
		InetAddress addr = null;
	    try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 
		ip=addr.getHostAddress().toString();//获得本机IP 
		machine=addr.getHostName().toString();//获得本机名称 
	}
	/**
	 * 
	 * @return 机器IP
	 */
	public static String getIp(){
		if(ip == null){
			init();
		}
		return ip;
	}
	/**
	 * 
	 * @return 机器编号
	 */
	public static String getMachine(){
		if(machine == null){
			init();
		}
		return machine;
	}
	
	/**
	 * 
	 * @return 当前系统时间 yyyy-MM-dd HH24:MI:SS
	 */
	public static String getSysCurrentDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		String time = sdf.format(new java.util.Date());  
		return time;
	}
	
	/**
	 * 
	 * @return 当前系统时间 yyyy-MM-dd
	 */
	public static String getSysCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);  
		String time = sdf.format(new java.util.Date());  
		return time;
	}
	
	/**
	 * 
	 * @return 当前系统时间 HH24:MI:SS
	 */
	public static String getSysCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT);  
		String time = sdf.format(new java.util.Date());  
		return time;
	}
}
