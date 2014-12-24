/**
 * 
 */
package com.somnus.support.common;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * 获取MESSAGE资源文件实例
 *
 * @author: cjliu
 * @version: 2013-09-25
 */
public class GetMsgResource {
	/**
	 * MESSAGE资源文件名
	 */
	private static final String resourceURL = "message";
	
	/**
	 * resource文件实际对象
	 */
	private static ResourceBundle bundle = null;

	/**
	 * 获取资源文件，只加载一次
	 */
	static {
		Locale locale = Locale.CHINA;

		try {
			bundle = ResourceBundle.getBundle(resourceURL, locale);
			if (bundle == null) {
				// 报错，系统文件不存在！
				throw new Exception(MessageFormat.format(MsgCodeList.ERROR_300001,resourceURL));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取resource文件实际对象
	 * @return 文件实际对象
	 */
	public static ResourceBundle getBundle() {
		return bundle;
	}
	

    /**
     * 获取错误信息字符串
     *
     * @param key
     * @return
     */
	public static String getString(String key){
		if(bundle.containsKey(key)){
			return bundle.getString(key);
		}
		return "";
	}

    /**
     * 获取错误信息字符串
     *
     * @param key
     * @param args
     * @return
     */
	public static String getString(String key,Object... args){
		
		String result = "";
		if(bundle.containsKey(key)){
			result =  bundle.getString(key);
		}
		return MessageFormat.format(result, args);
	}

    /**
     * 获取错误信息字符串
     *
     * @param key
     * @param param
     * @return
     */
	public static String getString(String key,String param){
		return getString(key, new Object[]{param});
	}
}
