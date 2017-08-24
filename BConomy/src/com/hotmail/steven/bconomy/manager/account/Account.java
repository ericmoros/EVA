package com.hotmail.steven.bconomy.manager.account;

import com.hotmail.steven.bconomy.BConomy;

public class Account {
	
	private String accountName;
	
	private String userId;
	
	private BConomy plugin;
	
	public Account(String userId, String accountName, BConomy plugin) {
		
		this.accountName = accountName;
		
		this.userId = userId;
		
		this.plugin = plugin;
		
	}
	
	public Holdings getHoldings() {
		
		return new Holdings(userId, accountName, plugin);
		
	}
	
	public String getAccountName() {
		
		return accountName;
		
	}
	
	public String getUserId() {
		
		return userId;
		
	}

}
