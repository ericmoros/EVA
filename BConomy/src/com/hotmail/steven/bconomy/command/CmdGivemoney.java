package com.hotmail.steven.bconomy.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.hotmail.steven.bconomy.BConomy;
import com.hotmail.steven.bconomy.Messages;
import com.hotmail.steven.bconomy.manager.AccountManager;
import com.hotmail.steven.bconomy.manager.account.AccountException;
import com.hotmail.steven.bconomy.manager.account.Holdings;

public class CmdGivemoney extends BConomyCommand implements CommandExecutor {

	private BConomy plugin;
	
	public CmdGivemoney(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length < 2) return false;
		
		int amount = 0;
		
		try {
			
			amount = Integer.parseInt(args[1]);
			
		} catch(NumberFormatException e) {
			
			return false;
			
		}
		
		OfflinePlayer reciever = Bukkit.getOfflinePlayer(args[0]);
		
		try {
			
			AccountManager.getAccount(reciever.getUniqueId().toString(), "default").getHoldings().add(amount);;
			
			sender.sendMessage(Messages.format("&aYou have given " + reciever.getName() + " &e" + Holdings.format(amount)));
			
		} catch (AccountException e) {
			
			sender.sendMessage(e.getMessage());
			
		}
		
		return true;
	
	}

}
