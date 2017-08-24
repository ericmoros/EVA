package com.hotmail.steven.bconomy.command;

import static com.hotmail.steven.bconomy.Messages.tl;

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

public class CmdMoney extends BConomyCommand implements CommandExecutor {

	private BConomy plugin;
	
	public CmdMoney(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(isConsole(sender)) {
			
			sender.sendMessage(tl("playerOnly"));
			
			return true;
			
		}
		
		Player player = (Player)sender;
		
		String userId = player.getUniqueId().toString();
		
		if(args.length > 0) userId = Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString();
			
		Account acc = null;
		
		try {
			
			acc = AccountManager.getAccount(userId, "default");
			
		} catch(AccountException e) {
			
			player.sendMessage(e.getMessage());
			
		}
		
		player.sendMessage(Messages.format("&2Money: &e" + Holdings.format(acc.getHoldings().getBalance())));
		
		return true;
	
	}

}
