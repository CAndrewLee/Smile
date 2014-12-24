/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.base.common;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.support.MessageSourceAccessor;

import com.somnus.support.common.MsgCodeList;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.ValidateUtil;

public class CheckUtil {
	/**
	 * @Title:mustEmpty
	 * @Description:必须为空
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void mustEmpty(String src, String name) {
		if (!ValidateUtil.isEmpty(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301003, new Object[]{name, "空"}));
		}
	}

	/**
	 * @Title:mustInVain
	 * @Description:无效
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void mustInVain(String src, String name) {
		if (!ValidateUtil.isEmpty(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301008, new Object[]{name}));
		}
	}

	/**
	 * @Title:isEmpty
	 * @Description:报文为空校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isEmpty(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301001, new Object[]{name}));
		}
	}

	/**
	 * @Title:isTranEmpty
	 * @Description:交易为空校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isTranEmpty(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[]{name}));
		}
	}

	/**
	 * @Title:isEmpty
	 * @Description:交易为空校验
	 * @param list
	 * @param name
	 * @return void
	 */
	public static <T> void isEmpty(List<T> list, String name) {
		if (list == null || list.size() == 0) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[]{name}));
		}
	}

	/**
	 * @Title:isEmpty
	 * @Description:交易为空校验
	 * @param obj
	 * @param name
	 * @return void
	 */
	public static void isEmpty(Object obj, String name) {
		if (obj == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[]{name}));
		}
	}

	/**
	 * @Title:isDecimalNumber
	 * @Description:报文金额校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isDecimalNumber(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		if (!ValidateUtil.isAmt(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301009, new Object[]{name}));
		}
	}

	/**
	 * @Title:isRightDate
	 * @Description:报文日期校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isRightDate(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		if (!ValidateUtil.isValidDateTime(src)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301003, new Object[]{name, "yyyy-MM-dd HH:mm:ss"}));
		}
	}

	/**
	 * @Title:isRightDay
	 * @Description:报文日期校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isRightDay(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		if (!ValidateUtil.isDate(src, "yyyy-MM-dd")) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301003, new Object[]{name, "yyyy-MM-dd"}));
		}
	}

	/**
	 * @Title:isRightTime
	 * @Description:时间校验
	 * @param time
	 * @param name
	 * @return void
	 */
	public static void isRightTime(String time, String name) {
		if (ValidateUtil.isEmpty(time)) {
			return;
		}
		if (!ValidateUtil.isValidTime(time)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301003, new Object[]{name, "HH:mm:ss"}));
		}
	}

	/**
	 * @Title:isInterger
	 * @Description:报文整数校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isInterger(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[1-9][0-9]*");
		java.util.regex.Matcher match = pattern.matcher(src);
		if (!match.matches()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301002, new Object[]{name}));
		}
	}
	
	/**
	 * @Title:isInterger
	 * @Description:报文正整数校验
	 * @param src
	 * @param name
	 * @return void
	 */
	public static void isPositiveInterger(String src, String name) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[1-9][0-9]*");
		java.util.regex.Matcher match = pattern.matcher(src);
		if (!match.matches()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301012, new Object[]{name}));
		}
	}

	/**
	 * @Title:isGreatLenth
	 * @Description:报文长度
	 * @param src
	 * @param name
	 * @param length
	 * @return void
	 */
	public static void isGreatLenth(String src, String name, int length) {
		if (ValidateUtil.isEmpty(src)) {
			return;
		}
		if (ValidateUtil.isGreatLenth(src, length)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301005, new Object[]{name, length}));
		}
	}

	/**
	 * @Title:isGreatLenth
	 * @Description:报文长度
	 * @param src
	 * @param name
	 * @param length
	 * @return void
	 */
	public static void isBigthanZero(String amt, String amtname) {
		if (!ValidateUtil.isEmpty(amt)
				&& new BigDecimal(amt).compareTo(new BigDecimal("0")) < 0) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_301010, new Object[]{amtname}));
		}
	}

	
	private static MessageSourceAccessor msa = ApplicationContextHolder.getBean(MessageSourceAccessor.class);
}
