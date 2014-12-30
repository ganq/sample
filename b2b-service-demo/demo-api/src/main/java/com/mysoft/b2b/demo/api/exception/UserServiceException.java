package com.mysoft.b2b.demo.api.exception;

/**
 * 用户服务接口异常类
 * 
 * @author subh
 * 
 */
public class UserServiceException extends Exception {
	private static final long serialVersionUID = 2608386964408834216L;

	public UserServiceException() {
		super();
	}

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserServiceException(Throwable cause) {
		super(cause);
	}
}
