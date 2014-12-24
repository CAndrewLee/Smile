package com.somnus.support.util.excel;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * JxlsUtils
 * 
 * @author levis
 * @version 1.0 14-6-23
 */
public class JxlsUtils {
	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param param
	 * @param outPath
	 */
	public static void mergeTemplate(String template, Map<String, Object> param, String outPath) {
		String templatePath = "";
		XLSTransformer transformer = new XLSTransformer();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				templatePath = url.getPath() + template;
				if (new File(templatePath).exists()) {
					break;
				}
			}
			if ("".equals(templatePath)) {
				throw new RuntimeException("template:" + template + " not found");
			}
			transformer.transformXLS(templatePath, param, outPath);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * 
	 * @param template
	 * @param objects		List of beans where each list item should be exported into a separated worksheet
	 * @param newSheetNames	Sheet names to be used for newly created worksheets
	 * @param beanName	Bean name to be used for a list item when processing sheet
	 * @param os
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 */
	public static void mergeTemplateMultipleSheets(String template, List objects, List<String> newSheetNames, String beanName, OutputStream os)
			throws IOException, InvalidFormatException, FileNotFoundException {
		String templatePath = "";
		XLSTransformer transformer = new XLSTransformer();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				templatePath = url.getPath() + template;
				if (new File(templatePath).exists()) {
					break;
				}
			}
			if ("".equals(templatePath)) {
				throw new RuntimeException("template:" + template + " not found");
			}

			Workbook workbook = transformer.transformMultipleSheetsList(new FileInputStream(templatePath), 
					objects, newSheetNames, beanName,new HashMap(), 0);

			workbook.write(os);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 
	 * @param template
	 * @param objects
	 * @param newSheetNames
	 * @param beanName
	 * @param removeSheetNames 模板中，哪些sheet需要忽略？
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 */
	public static Workbook mergeTemplateMultipleSheets(String template, List objects, List<String> newSheetNames, String beanName, int startSheetNum)
			throws IOException, InvalidFormatException, FileNotFoundException {
		String templatePath = "";
		XLSTransformer transformer = new XLSTransformer();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				templatePath = url.getPath() + template;
				if (new File(templatePath).exists()) {
					break;
				}
			}
			if ("".equals(templatePath)) {
				throw new RuntimeException("template:" + template + " not found");
			}

			return transformer.transformMultipleSheetsList(new FileInputStream(templatePath), objects, newSheetNames, beanName, new HashMap(), startSheetNum);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param param
	 * @param os
	 */
	public static void mergeTemplate(String template, Map<String, Object> param, OutputStream os) {
		String templatePath = "";
		XLSTransformer transformer = new XLSTransformer();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				templatePath = url.getPath() + template;
				if (new File(templatePath).exists()) {
					break;
				}
			}
			if ("".equals(templatePath)) {
				throw new RuntimeException("template:" + template + " not found");
			}
			Workbook workbook = transformer.transformXLS(new FileInputStream(templatePath), param);
			workbook.write(os);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param param
	 * @param os
	 */
	public static Workbook mergeTemplate(String template, Map<String, Object> param) {
		String templatePath = "";
		XLSTransformer transformer = new XLSTransformer();
		try {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				templatePath = url.getPath() + template;
				if (new File(templatePath).exists()) {
					break;
				}
			}
			if ("".equals(templatePath)) {
				throw new RuntimeException("template:" + template + " not found");
			}
			return transformer.transformXLS(new FileInputStream(templatePath), param);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param obj
	 * @param outPath
	 */
	public static void mergeTemplate(String template, Object obj, String outPath) {
		mergeTemplate(template, bean2Map(obj), outPath);
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param obj
	 * @param os
	 */
	public static void mergeTemplate(String template, Object obj, OutputStream os) {
		mergeTemplate(template, bean2Map(obj), os);
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param obj
	 * @param os
	 */
	public static Workbook  mergeTemplate(String template, Object obj) {
		return mergeTemplate(template, bean2Map(obj));
	}

	/**
	 * javaban 转化为map
	 * 
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> bean2Map(Object bean) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Class type = bean.getClass();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return returnMap;
	}
	
	/**
	 * 去掉重复的MergedRegion，解决excel打开时的报错:已删除的记录: /xl/worksheets/sheet2.xml 部分的 合并单元格
	 * @return
	 */
	public static Workbook cleanRepeatedMergedRegion(Workbook book){
		for(int i=0;i<book.getNumberOfSheets(); i++){
			Sheet sheet= book.getSheetAt(i);
			Set<String> set = new HashSet<String>();
			while(sheet.getNumMergedRegions()>0){
				set.add(sheet.getMergedRegion(0).formatAsString());
				sheet.removeMergedRegion(0);
			}
			for(String str:set){
				sheet.addMergedRegion(CellRangeAddress.valueOf(str));
			}
		}
		return book;
	}
	
}
