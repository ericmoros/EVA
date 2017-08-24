package com.hotmail.steven.bconomy;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {

	private static FileConfiguration cfg;
	
	private static BConomy plugin;
	
	public Settings(BConomy plugin, FileConfiguration cfg) {

		this.plugin = plugin;
		
		this.cfg = cfg;
		
		load();
		
	}
	
	public static enum Nodes {
		
		SINGLE("Currency.Single", "Coin"),
		MULTIPLE("Currency.Multiple", "Coins"),
		
		NAME("Account.Name", "default"),
		BALANCE("Account.Balance", 30),
		BALANCEMIN("Account.Min-Balance", 0),
		
		LOGGING("Logging.Enabled", false),
		PURGING("Purging.Enabled", false),
		PURGEINTERVAL("Purging.Interval", 30),
		
		INTEREST("Interest.Enabled", false),
		INTERESTONLINE("Interest.Online", false),
		INTERESTCUTOFF("Interest.Amount.Cutoff", 0),
		INTERESTMIN("Interest.Amount.Min", 0),
		INTERESTMAX("Interest.Amount.Max", 10),
		INTERESTINTERVAL("Interest.Interval.Seconds", 20),
		INTERESTANNOUNCE("Interest.Announce.Enabled", true),
		
		FULLNAMES("formatting.fullnames", true),
		BEFORE("formatting.before", false),
		
		MODULESIGNS("modules.signs.enabled", false),
		MODULESHOWCASE("modules.showcases.enabled", false),
		
		DATABASEMYSQL("Database.Mysql.Enabled", false),
		DATABASETABLE("Database.Mysql.Table", "_bcon"),
		DATABASEHOST("Database.Mysql.Host", "localhost"),
		DATABASEUSER("Database.Mysql.User", "root"),
		DATABASEPASS("Database.Mysql.Pass", "");
		
		String node;
		Object value;
		
		private Nodes(String node, Object value) {
			
			this.node = node;
			
			this.value = value;
			
		}
		
		public int getInt() {
			
			return (Integer)value;
			
		}
		
		public boolean getBoolean() {
			
			return (Boolean)value;
			
		}
		
		public String getString() {
			
			return (String)value;
			
		}
		
		public List<String> getList() {
			
			return (List<String>)value;
			
		}
		
		public String getNode() {
			
			return node;
			
		}
		
		public Object getValue() {
			
			return value;
			
		}
		
		public void setValue(Object value) {
			
			this.value = value;
			
		}
		
	}
	
	public static int getInt(String path) {
		
		return cfg.getInt(path);
		
	}
	
	public static void setInt(String path, int value) {
		
		cfg.set(path, value);
		
		plugin.saveConfig();
		
	}
	
	public static void load() {
		
		for(Nodes n : Nodes.values()) {
			
			if(cfg.get(n.getNode()) != null)
				
				n.setValue(cfg.get((n.getNode())));
			
		}
		
	}
	
}
