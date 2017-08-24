package com.hotmail.steven.bconomy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.hotmail.steven.bconomy.BConomy;
import com.hotmail.steven.bconomy.manager.AccountManager;
import com.hotmail.steven.bconomy.manager.account.AccountException;

public class PlayerListener implements Listener {

	private BConomy plugin;
	
	public PlayerListener(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent evt) {
		
		try {
			
			AccountManager.createAccount(evt.getPlayer().getUniqueId().toString(), "default");
		
		} catch (AccountException e) {
			
			
			
		}
		
	}
	
}
