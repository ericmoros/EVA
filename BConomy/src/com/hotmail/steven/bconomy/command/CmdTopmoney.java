package com.hotmail.steven.bconomy.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.hotmail.steven.bconomy.BConomy;
import com.hotmail.steven.bconomy.Messages;
import com.hotmail.steven.bconomy.manager.AccountManager;
import com.hotmail.steven.bconomy.manager.account.Account;
import com.hotmail.steven.bconomy.manager.account.AccountException;
import com.hotmail.steven.bconomy.manager.account.Holdings;

import static com.hotmail.steven.bconomy.Messages.tl;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CmdTopmoney extends BConomyCommand implements CommandExecutor {

	private BConomy plugin;
	
	public CmdTopmoney(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		List<Account> accounts = AccountManager.getTopAccounts();
		
		if(accounts.isEmpty()) {
			
			player.sendMessage(tl("noBalances"));
		
			return true;
			
		}
			
		String message = "&c&l-= Los más ricos =-\n";
		
		for(Account account : accounts) {
			
			message += "&a" + Bukkit.getOfflinePlayer(UUID.fromString(account.getUserId())).getName() + ": &e" + Holdings.format(account.getHoldings().getBalance()) + "\n";
			
		}
		
		player.sendMessage(Messages.format(message));
		
		return true;
		
	}

}
