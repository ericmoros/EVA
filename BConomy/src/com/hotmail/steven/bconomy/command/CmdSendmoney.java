package com.hotmail.steven.bconomy.command;

import static com.hotmail.steven.bconomy.Messages.tl;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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

public class CmdSendmoney extends BConomyCommand implements CommandExecutor {

	private BConomy plugin;
	
	public CmdSendmoney(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage(tl("playerOnly"));
			
			return true;
			
		}
		
		// Check if the second argument is a number
		if(args.length < 2) return false;
		
		int amount = 0;
			
		try {
			
			amount = Integer.parseInt(args[1]);
			
		} catch(NumberFormatException e) {
			
			return false;
			
		}
		//

		Player payer = (Player)sender;

		//Pay the reciever(s) some money!
		Holdings payerHoldings = new Account(payer.getUniqueId().toString(), "default", plugin).getHoldings();
		
		if(args[0].equalsIgnoreCase("all")) amount = (Bukkit.getOnlinePlayers().size()-1) * amount;
		
		try {
			
			payerHoldings.subtract(amount);
			
		} catch (AccountException e) {
			
			payer.sendMessage(e.getMessage());
			
			return true;
			
		}
		
		String formattedBal = Holdings.format(amount);
			
		OfflinePlayer reciever = Bukkit.getOfflinePlayer(args[0]);
		
		if(!reciever.hasPlayedBefore() || !AccountManager.hasAccount(reciever.getUniqueId().toString(), "default")) {
			
			sender.sendMessage(tl("accountNotExists"));
			
			return true;
			
		}
	
		new Account(reciever.getUniqueId().toString(), "default", plugin).getHoldings().add(amount);
		
		payer.sendMessage(Messages.format("&aYou have sent &e" + formattedBal + " &ato " + reciever.getName()));
		
		if(reciever.isOnline()) {
			
			reciever.getPlayer().sendMessage(Messages.format("&aYou have recieved &e" + formattedBal + " &afrom " + payer.getDisplayName()));
	
		}
		//
		
		return true;
		
	}

}
