package com.somnus.support.exceptions;

/**
 * BizException
 *
 * @author levis
 * @version 1.0 2013-4-17
 */
public class BizException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BizException() {
		super();
	}
	
	public BizException(String message) {
		super(message);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}
	
	
}
