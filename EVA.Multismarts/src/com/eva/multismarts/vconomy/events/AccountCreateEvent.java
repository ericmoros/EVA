
package com.eva.multismarts.vconomy.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class AccountCreateEvent extends Event{
    
    private static final HandlerList handler = new HanderList();
    
    private String AccountName;
    
    private String UserId;
    
    private double Balance;
    
    private boolean Cancel;
    
    public AccountCreateEvent(String UserId, String AccountName, double Balance) {
        this.UserId = UserId;
        this.AccountName = AccountName;
        this.setBalance(Balance);
                
    }
    public void setBalance(double Balance) {
		
		this.Balance = Balance;
		
	}
}
