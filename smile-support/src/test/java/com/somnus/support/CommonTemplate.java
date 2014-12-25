package com.somnus.support;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somnus.support.domain.Bank;
import com.somnus.support.domain.Base;
import com.somnus.support.domain.Example;
import com.somnus.support.domain.User;
import com.somnus.support.util.excel.AbstractReportTemplate;

@Component
public class CommonTemplate<T extends Base> extends AbstractReportTemplate {
	private final static Logger log = LoggerFactory.getLogger(CommonTemplate.class);
	
	private XLSTransformer tran = new XLSTransformer();
	
	@Override
	public Workbook exportReport(String strartDate, String endDate) {
		try {
			Map<String, List> SheetMap = new HashMap<String, List>();
			List<User> list01 = new ArrayList<User>();
			for(int i=1;i<=100;i++){
				User user = new User();
				user.setId(i);
				user.setUsername("username"+i);
				user.setPassword("password"+i);
				list01.add(user);
			}
			List<User> list02 = new ArrayList<User>();
			for(int i=1;i<=100;i++){
				User user = new User();
				user.setId(i);
				user.setUsername("username"+i);
				user.setPassword("password"+i);
				list02.add(user);
			}
			List<User> list03 = new ArrayList<User>();
			for(int i=1;i<=100;i++){
				User user = new User();
				user.setId(i);
				user.setUsername("username"+i);
				user.setPassword("password"+i);
				list03.add(user);
			}
			List<User> list04 = new ArrayList<User>();
			for(int i=1;i<=100;i++){
				User user = new User();
				user.setId(i);
				user.setUsername("username"+i);
				user.setPassword("password"+i);
				list04.add(user);
			}

			SheetMap.put("STL01", list01);
			SheetMap.put("STL02", list02);
			SheetMap.put("STL03", list03);
			SheetMap.put("STL04", list04);
			// 如果没有任何数据，就返回null
			if (list01.size() + list02.size() + list03.size() + list04.size() == 0) {
				return null;
			} else {
				String template = TEMP_PATH_XLS + "temp.xlsx";
				InputStream in = getClass().getClassLoader().getResourceAsStream(template);
				Workbook workbook = tran.transformMultipleSheetsList(in, null,null, "", SheetMap, 0);
				in.close();
				return workbook;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	
	/**
	 * @description 给数据分组
	 * @param banklist
	 * @param statlist
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Map<String,List<T>> groupList(List<Bank> banklist,List<T> statlist) throws InstantiationException, IllegalAccessException{
		// 创建map，允许根据bankAccNo_bankCode查找bank_acc_id
		Map<String, String> idMap = new HashMap<String, String>();
		for (Bank bank : banklist) {
			// 将小于10的id前面补0
			String id = bank.getId().trim();
			if (id.length() == 1) {
				bank.setId("0" + id);
			}
			idMap.put(bank.getAccountno() + "_" + bank.getBankcode(), bank.getId());
		}
		Class<T> clazz = (Class<T>) statlist.get(0).getClass();
		TreeMap<String, List<T>> map = new TreeMap<String, List<T>>();
		
		for (int i = 0; i < statlist.size(); i++) {
			T object = statlist.get(i);
			List<T> list = null;
			String accId = idMap.get(object.getBankActNo() + "_" + object.getBankCode());
			if (accId != null) {
				if (map.containsKey(accId)) {
					list = map.get(accId);
					list.add(object);
				} else {
					list = new ArrayList<T>();
					list.add(object);
					map.put(accId, list);
				}
			}
		}
		//为没有数据的账户填充0
		for (int i = 0; i < banklist.size(); i++) {
			Bank bank = banklist.get(i);
			if (!map.containsKey(bank.getId())) {
				List<T> list = new ArrayList<T>();
				T obj = clazz.newInstance();
				obj.setBankActName(bank.getAccountname());
				obj.setBankActNo((bank.getAccountno()));
				obj.setBankCode((bank.getBankcode()));
				obj.setBankName((bank.getBankname()));
				obj.setTranDate("");
				list.add(obj);
				map.put(bank.getId(), list);
			}
		}
		return map;
	}
	
	/**
	 * @description 给具体每个sheet组，补填数据数据，且计算合计
	 * @param arr 决定sheet有多少行
	 * @return
	 * @throws Exception
	 */
	public Workbook exportReport(String[] arr){
		Map<String,List> soucremap = getData();
		Map<String, List<T>> map;
		try {
			map = groupList(soucremap.get("banklist"), soucremap.get("list"));
		} catch (InstantiationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		if (arr.length < 1) {
			throw new RuntimeException("arr is not allowed to empty");
		}
		log.info("遍历的数组："+StringUtils.join(arr, "#"));
		List<List<T>> resultlist = new ArrayList<List<T>>();
		List<String> newSheetNames = new ArrayList<String>();
		try {
			for(String key:map.keySet()){
				List<T> relist = new ArrayList<T>();
				Class<T> clazz = (Class<T>) map.get(key).get(0).getClass();
				Map<String, T> datamap = new TreeMap<String, T>();
				//创建出总共需要的对象，全部赋相对应的值
				for (int i = 0; i < arr.length; i++) {
					T t = clazz.newInstance();
					datamap.put(arr[i], t);
					PropertyUtils.setProperty(t, "tranDate", arr[i]);
					PropertyUtils.setProperty(t, "bankName", map.get(key).get(0).getBankName());
					PropertyUtils.setProperty(t, "bankCode", map.get(key).get(0).getBankCode());
					PropertyUtils.setProperty(t, "bankActNo", map.get(key).get(0).getBankActName());
					PropertyUtils.setProperty(t, "bankActName", map.get(key).get(0).getBankActNo());
				}
				//替换能从list中取到的值，比如11日有数据，则替换
				for (int i = 0; i < map.get(key).size(); i++) {
					T object = map.get(key).get(i);
					String value = object.getTranDate();
					if(datamap.containsKey(value)){
						datamap.put(value, object);
					}
				}
				Field[] fields = clazz.getDeclaredFields();
				T total = clazz.newInstance();
				total.setTranDate("合计");
				
				// 合计用，初始化一个sum值
				Map<String, Object> summap = new HashMap<String, Object>();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					if (BigDecimal.class.equals(field.getType())) {
						summap.put(field.getName(), BigDecimal.ZERO);
					}
				}
				
				for (int i = 0; i < arr.length; i++){
					for (int j = 0; j < fields.length; j++) {
						Field field = fields[j];
						String fieldName = field.getName();
						for (String sum : summap.keySet()) {
							if (sum.equals(fieldName) && BigDecimal.class.equals(field.getType())) {
								BigDecimal getValue = (BigDecimal) PropertyUtils.getProperty(datamap.get(arr[i]), fieldName);
								BigDecimal totalValue = (BigDecimal) summap.get(sum);
								if(getValue!=null&&getValue.intValue()>0)
									summap.put(sum, totalValue.add(getValue));
								PropertyUtils.setProperty(total, fieldName, summap.get(sum));
							}
						}
					}
					relist.add(datamap.get(arr[i]));
					newSheetNames.add("ACCOUNT-"+(newSheetNames.size()+1));
				}
				relist.add(total);
				resultlist.add(relist);
			}
		} catch (InstantiationException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		try {
			String template = TEMP_PATH_XLS + "temp3.xlsx";
			InputStream in= getClass().getClassLoader().getResourceAsStream(template);
			Workbook workbook  = tran.transformMultipleSheetsList(in, resultlist, newSheetNames, "rows", null, 0);
			in.close();
			return workbook;
		} catch (ParsePropertyException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (InvalidFormatException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 拼数据
	 * @return
	 */
	public Map<String,List> getData(){
		Map<String,List> map = new HashMap<String,List>();
		
		List<Bank> banklist = new ArrayList<Bank>();
		Bank b1 = new Bank();
		b1.setId("1");
		b1.setAccountname("xxxxxxxx");
		b1.setAccountno("1001278619005534066");
		b1.setBankcode("1100");
		b1.setBankname("工商银行");
		Bank b2 = new Bank();
		b2.setId("2");
		b2.setAccountname("xxxxxxxx");
		b2.setAccountno("03342900040020221");
		b2.setBankcode("1101");
		b2.setBankname("农业银行");
		Bank b3 = new Bank();
		b3.setId("3");
		b3.setAccountname("xxxxxxxx");
		b3.setAccountno("755915059310402");
		b3.setBankcode("1102");
		b3.setBankname("招商银行");
		Bank b4 = new Bank();
		b4.setId("4");
		b4.setAccountname("xxxxxxxx");
		b4.setAccountno("216140100100149330");
		b4.setBankcode("1103");
		b4.setBankname("兴业银行");
		Bank b5 = new Bank();
		b5.setId("5");
		b5.setAccountname("xxxxxxxx");
		b5.setAccountno("23001625151050509551");
		b5.setBankcode("1106");
		b5.setBankname("建设银行");
		Bank b6 = new Bank();
		b6.setId("6");
		b6.setAccountname("xxxxxxxx");
		b6.setAccountno("7332910182600000738");
		b6.setBankcode("1104");
		b6.setBankname("中信银行");
		Bank b7 = new Bank();
		b7.setId("7");
		b7.setAccountname("xxxxxxxx");
		b7.setAccountno("320757593548");
		b7.setBankcode("1107");
		b7.setBankname("中国银行");
		Bank b8 = new Bank();
		b8.setId("8");
		b8.setAccountname("xxxxxxxx");
		b8.setAccountno("310066580018170190431");
		b8.setBankcode("1108");
		b8.setBankname("交通银行");
		Bank b9 = new Bank();
		b9.setId("9");
		b9.setAccountname("xxxxxxxx");
		b9.setAccountno("97260154740003652");
		b9.setBankcode("1109");
		b9.setBankname("浦发银行");
		banklist.add(b1);
		banklist.add(b2);
		banklist.add(b3);
		banklist.add(b4);
		banklist.add(b5);
		banklist.add(b6);
		banklist.add(b7);
		banklist.add(b8);
		banklist.add(b9);
		
		List<Example> list = new ArrayList<Example>();
		Example e = new Example();
		e.setBankActName("xxxxxxxx");
		e.setBankActNo("1001278619005534066");
		e.setBankCode("1100");
		e.setBankName("工商银行");
		e.setTranDate("2014-11-11");
		e.setValue(new BigDecimal(10000000));
		e.setValue2(new BigDecimal(20000000));
		e.setValue3(new BigDecimal(30000000));
		Example e1 = new Example();
		e1.setBankActName("xxxxxxxx");
		e1.setBankActNo("1001278619005534066");
		e1.setBankCode("1100");
		e1.setBankName("工商银行");
		e1.setTranDate("2014-11-12");
		e1.setValue(new BigDecimal(10000000));
		e1.setValue2(new BigDecimal(20000000));
		e1.setValue3(new BigDecimal(30000000));
		
		Example e8 = new Example();
		e8.setBankActName("xxxxxxxx");
		e8.setBankActNo("310066580018170190431");
		e8.setBankCode("1108");
		e8.setBankName("交通银行");
		e8.setTranDate("2014-11-05");
		e8.setValue(new BigDecimal(10000000));
		e8.setValue2(new BigDecimal(20000000));
		e8.setValue3(new BigDecimal(30000000));
		Example e9 = new Example();
		e9.setBankActName("xxxxxxxx");
		e9.setBankActNo("97260154740003652");
		e9.setBankCode("1109");
		e9.setBankName("浦发银行");
		e9.setTranDate("2014-11-24");
		e9.setValue(new BigDecimal(10000000));
		e9.setValue2(new BigDecimal(20000000));
		e9.setValue3(new BigDecimal(30000000));
		list.add(e);
		list.add(e1);
		list.add(e8);
		list.add(e9);
		
		map.put("banklist", banklist);
		map.put("list", list);
		return map;
	}

}
