/**
 * 
 */
package com.somnus.support.util;

import java.io.BufferedReader;
import java.io.FileReader;

/**   
 * @Title: FileUtil
 * @Package: com.ips.core.bacs.common.util
 * @Description: TODO
 * @author: cjliu
 * @date: 2012-9-21下午1:53:20
 * @version: 1.0  
 */
public class FileUtil {
	/**
	 * @Description: 读取文本文件的内容
	 * @param filePath
	 * @param @throws Exception   
	 * @return String    文件内容
	 * @throws
	 */
	public static String read(String filePath) throws Exception {
		
		StringBuffer sb = new StringBuffer("");
		FileReader reader=null;
		BufferedReader br=null;
		try {
			reader = new FileReader(filePath);
			br = new BufferedReader(reader);
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
		}finally{
			br.close();
			reader.close();
		}
		return sb.toString();
	}
}
