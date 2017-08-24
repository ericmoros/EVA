package com.hotmail.steven.bconomy;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Data {

	private static FileConfiguration cfg;
	
	private static File persistanceFile;
	
	private BConomy plugin;
	
	public Data(BConomy plugin) {
		
		this.plugin = plugin;
		
		persistanceFile = new File(plugin.getDataFolder().getAbsolutePath() + File.separator + "persistance.yml");
		
		if(!persistanceFile.exists()) {
				
			plugin.saveResource("data.yml", false);
			
		}
		
		cfg = YamlConfiguration.loadConfiguration(persistanceFile);
		
	}
	
	public static long getLong(String node) {
		
		return cfg.getLong(node);
		
	}
	
	public static void setLong(String node, long value) {
		
		cfg.set(node, value);
		
		save();
		
	}
	
	private static void save() {
		
		try {
			
			cfg.save(persistanceFile);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
}
