package com.hotmail.steven.bconomy.manager.account;

public class AccountException extends Exception {

	private String message;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountException(String message) {
		
		this.message = message;
		
	}
	
	public String getMessage() {
		
		return message;
		
	}

}
