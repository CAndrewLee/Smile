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
