package com.somnus.support.util.excel;

import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Workbook;

public interface ReportTemplate {
	/**
	 * 导出模板
	 * 
	 * @param reportorType
	 * @param strartDate
	 * @param endDate
	 * @param outputStream
	 */
	public void export(String strartDate, String endDate,
			OutputStream outputStream);

	/**
	 * 导出模板
	 * 
	 * @param reportorType
	 * @param strartDate
	 * @param endDate
	 * @param outputStream
	 */
	public Workbook exportReport(String strartDate, String endDate);
}
