package com.hotmail.steven.bconomy.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AccountDeleteEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	
	private String accountName;
	
	private String userId;
	
	private boolean cancel;
	
	public AccountDeleteEvent(String userId, String accountName) {
		
		this.accountName = accountName;
		
		this.userId = userId;
		
	}
	
	public HandlerList getHandlers() {
		
	    return handlers;
	    
	}
	 
	public static HandlerList getHandlerList() {
		
	    return handlers;
	    
	}
	
	public boolean isCancelled() {
		
		return cancel;
		
	}
	
	public void setCancelled(boolean cancel) {
		
		this.cancel = cancel;
		
	}

	public String getUserId() {
		
		return userId;
		
	}

	public String getAccountName() {
		
		return accountName;
		
	}
	
}
