package com.somnus.support.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.beanutils.BeanUtils;
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
	@SuppressWarnings("unchecked")
	public static void mergeTemplate(String template, Object obj, String outPath) {
		try {
			mergeTemplate(template, BeanUtils.describe(obj), outPath);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param obj
	 * @param os
	 */
	@SuppressWarnings("unchecked")
	public static void mergeTemplate(String template, Object obj, OutputStream os) {
		try {
			mergeTemplate(template, BeanUtils.describe(obj), os);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据模板生成文件到指定路径
	 * 
	 * @param template
	 * @param obj
	 * @param os
	 */
	@SuppressWarnings("unchecked")
	public static Workbook  mergeTemplate(String template, Object obj) {
		Workbook  Workbook = null;
		try {
			Workbook = mergeTemplate(template, BeanUtils.describe(obj));
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		return Workbook;
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
