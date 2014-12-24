/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.support.exceptions;

/**
 * SysException
 *
 * @author caobin
 * @version 1.0 2013-4-17
 */
@SuppressWarnings("serial")
public class SysException extends RuntimeException {

	public SysException() {
		super();		
	}

	public SysException(String message, Throwable cause) {
		super(message, cause);		
	}

	public SysException(String message) {
		super(message);		
	}

	public SysException(Throwable cause) {
		super(cause);
	}
	
}
