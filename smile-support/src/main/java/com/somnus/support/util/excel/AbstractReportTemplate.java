package com.somnus.support.util.excel;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @author caobin
 * @date 2014-1-20
 * @version 1.0
 */
public abstract class AbstractReportTemplate{
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	protected static final String TEMP_PATH_XLS = "META-INF/template/xls/";
	
	public void export(String strartDate, String endDate, OutputStream outputStream){
		Workbook workbook = exportReport(strartDate, endDate);
		try {
			workbook.write(outputStream);
		} catch (IOException e) {
			log.error("导出报表异常",e);
			throw new RuntimeException("导出报表异常", e);
		}
	}
	
	public abstract Workbook exportReport(String strartDate, String endDate);
}
