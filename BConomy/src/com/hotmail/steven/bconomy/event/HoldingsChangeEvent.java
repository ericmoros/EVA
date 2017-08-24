package com.hotmail.steven.bconomy.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HoldingsChangeEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	
	private String accountName;
	
	private String userId;
	
	private boolean cancel;
	
	private int oldBal;
	
	private int newBal;
	
	public HoldingsChangeEvent(String userId, String accountName, int oldBal, int newBal) {
		
		this.accountName = accountName;
		
		this.userId = userId;
		
		this.oldBal = oldBal;
		
		this.newBal = newBal;
		
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

	public String getAccountName() {
		
		return accountName;
		
	}
	
	public String getUserId() {
		
		return userId;
		
	}
	
	public int getOldBal() {
		
		return oldBal;
		
	}

	public int getNewBal() {
		
		return newBal;
		
	}

}
