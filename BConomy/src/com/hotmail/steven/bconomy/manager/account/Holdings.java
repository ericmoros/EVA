package com.hotmail.steven.bconomy.manager.account;

import static com.hotmail.steven.bconomy.Messages.tl;

import org.bukkit.Bukkit;

import com.hotmail.steven.bconomy.BConomy;
import com.hotmail.steven.bconomy.Settings.Nodes;
import com.hotmail.steven.bconomy.event.HoldingsChangeEvent;

public class Holdings {

	private String accountName;
	
	private String userId;
	
	private BConomy plugin;
	
	public Holdings(String userId, String accountName, BConomy plugin) {
		
		this.userId = userId;
		
		this.accountName = accountName;
		
		this.plugin = plugin;
		
	}
	
	public String getAccountName() {
		
		return accountName;
		
	}
	
	public void setBalance(int newBal) {
		
		HoldingsChangeEvent event = new HoldingsChangeEvent(userId, accountName, getBalance(), newBal);
		
		Bukkit.getServer().getPluginManager().callEvent(event);
		
		if(!event.isCancelled())
			AccountData.setAccountBalance(userId, accountName, event.getNewBal());
			
	}
	
	public int getBalance() {
		
		return AccountData.getAccountBalance(userId, accountName);
		
	}
	
	public static String format(int amount) {
		
		String symbol = amount == 1 ? Nodes.SINGLE.getString() : Nodes.MULTIPLE.getString();
		
		String formatted = amount + " " + symbol;
		
		if(Nodes.BEFORE.getBoolean()) formatted = symbol + " " + amount;
		
		return formatted;
		
	}
	
	public void subtract(int amount) throws AccountException {
		
		int balance = getBalance();
		
		if((balance - amount) < Nodes.BALANCEMIN.getInt()) 
			throw new AccountException(tl("notEnoughMoney"));
		
		setBalance(getBalance() - amount);
		
	}
	
	public void add(int amount) {
		
		setBalance(getBalance() + amount);
		
	}
	
	public boolean hasEnough(int amount) {
		
		if(amount <= getBalance()) {
			
			return true;
			
		}
		
		return false;
		
	}

}
