package com.hotmail.steven.bconomy;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Messages {

	private static FileConfiguration messagesCfg;

	public Messages(BConomy bcon) {
		
		File messagesFile = new File(bcon.getDataFolder().getAbsolutePath() + File.separator + "messages.yml");
		
		if(!messagesFile.exists()) {
			
			bcon.saveResource("messages.yml", false);
			
		}
		
		messagesCfg = YamlConfiguration.loadConfiguration(messagesFile);
		
	}

	public static String tl(String identifier, Object[]... replacers) {

		String message = messagesCfg.getString(format(identifier));
		/*
		for(Object[] array : replacers) {
			
			if(message.contains("&" + array[1].toString() + "&")) {
				
				message = message.replaceAll("&" + array[1].toString() + "&", array[1].toString());
				
			}
			
		}
		*/
		return format(message);

	}
	
	public static String format(String string) {
		
		return ChatColor.translateAlternateColorCodes('&', string);
		
	}

}
