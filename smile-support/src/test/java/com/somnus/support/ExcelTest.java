package com.somnus.support;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.excel.JxlsUtils;

public class ExcelTest extends AbstractTestSupport {
	@Test
	public void test1(){
		CommonTemplate temp = (CommonTemplate)ApplicationContextHolder.getBean(CommonTemplate.class);
		try {
			OutputStream out2 = new FileOutputStream("E://b.xlsx");
			
			temp.export(null, null, out2);
			
			out2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		CommonTemplate temp = (CommonTemplate)ApplicationContextHolder.getBean(CommonTemplate.class);
		try {
			OutputStream out2 = new FileOutputStream("E://d.xlsx");
			
			Workbook workbook =temp.exportReport(new String[] { "1日", "2日","3日", "4日", "5日", "6日", "7日", "8日", "9日", "10日",
					"11日", "12日","13日", "14日", "15日", "16日", "17日", "18日", "19日", "20日",
					"21日", "22日","23日", "24日", "25日", "26日", "27日", "28日", "29日", "30日"});
			JxlsUtils.cleanRepeatedMergedRegion(workbook);
			workbook.write(out2);
			out2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
