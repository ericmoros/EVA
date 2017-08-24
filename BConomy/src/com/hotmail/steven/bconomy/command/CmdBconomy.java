package com.hotmail.steven.bconomy.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

import com.hotmail.steven.bconomy.BConomy;
import com.hotmail.steven.bconomy.Messages;

public class CmdBconomy extends BConomyCommand implements CommandExecutor {

	private BConomy plugin;
	
	public CmdBconomy(BConomy plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		sender.sendMessage(Messages.format("&c&l-= BConomy Commands =-"));
		
		for(String cmdName : plugin.getDescription().getCommands().keySet()) {
			
			PluginCommand pCmd = Bukkit.getPluginCommand(cmdName);
			
			if(sender.hasPermission(pCmd.getPermission()))
				sender.sendMessage(Messages.format("&2" + cmdName + " - &a" + pCmd.getDescription()));
			
		}
		
		return true;
	
	}

}
