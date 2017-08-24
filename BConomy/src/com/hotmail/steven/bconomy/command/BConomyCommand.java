package com.hotmail.steven.bconomy.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BConomyCommand {
	
	public boolean isConsole(CommandSender sender) {
		
		return !(sender instanceof Player);
		
	}

}
