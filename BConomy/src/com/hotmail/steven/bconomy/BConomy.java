package com.hotmail.steven.bconomy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.steven.bconomy.Settings.Nodes;
import com.hotmail.steven.bconomy.command.CmdBconomy;
import com.hotmail.steven.bconomy.command.CmdGivemoney;
import com.hotmail.steven.bconomy.command.CmdMoney;
//import com.hotmail.steven.bconomy.command.CmdSendallmoney;
import com.hotmail.steven.bconomy.command.CmdSendmoney;
import com.hotmail.steven.bconomy.command.CmdSetmoney;
import com.hotmail.steven.bconomy.command.CmdTakemoney;
import com.hotmail.steven.bconomy.command.CmdTopmoney;
import com.hotmail.steven.bconomy.listener.PlayerListener;
import com.hotmail.steven.bconomy.manager.AccountManager;
import com.hotmail.steven.bconomy.manager.account.AccountData;
import com.hotmail.steven.bconomy.manager.account.Interest;

//import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;

public class BConomy extends JavaPlugin {

	/**
	 * Represents an instance of the main config file
	 */
	private FileConfiguration cfg;
	
	/**
	 * The interest timer class
	 */
	private Interest interest;
	
	/**
	 * Start BConomy!
	 */
	public void onEnable() {
		
		/**
		 * Register all commands
		 */
		this.getCommand("money").setExecutor(new CmdMoney(this));
		
		this.getCommand("topmoney").setExecutor(new CmdTopmoney(this));
		
		this.getCommand("sendmoney").setExecutor(new CmdSendmoney(this));
		
		//this.getCommand("sendallmoney").setExecutor(new CmdSendallmoney(this));
		
		this.getCommand("bconomy").setExecutor(new CmdBconomy(this));
		
		this.getCommand("givemoney").setExecutor(new CmdGivemoney(this));
		
		this.getCommand("setmoney").setExecutor(new CmdSetmoney(this));
		
		this.getCommand("takemoney").setExecutor(new CmdTakemoney(this));
		
		//this.getCommand("purgemoney").setExecutor(null);
		
		/**
		 * Save the default config
		 */
		this.saveDefaultConfig();
		
		/**
		 * Set the config variable
		 */
		this.cfg = this.getConfig();
		
		/**
		 * Create an instance of settings manager
		 */
		new Settings(this, cfg);
		
		/**
		 * Create an instance of persistance data
		 */
		//new Data(this);
		
		/**
		 * Initialize language files
		 */
		initializeMessages();
		
		/**
		 * Initialize account manager
		 */
		initializeAccounts();
		
		/**
		 * Initialize account data
		 */
		initializeAccountData();
		
		/**
		 * Register BConomy player listener
		 */
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
		
		/**
		 * Initialize interest timer
		 */
		initializeInterest();
		
		/**
		 * Initialize vault hooks
		 */
		//getServer().getServicesManager().register(Economy.class, new com.hotmail.steven.bconomy.Vault(), (Vault)Bukkit.getPluginManager().getPlugin("Vault"), ServicePriority.Normal);

	}
	
	public void onDisable() {
		
		if(interest != null)
			interest.saveState();
		
	}

	/**
	 * Create an instance of the messages class
	 * Used for translating and grabbing messages from the config
	 */
	private void initializeMessages() {
		
		new Messages(this);
		
	}
	
	/**
	 * Initialize accounts
	 */
	private void initializeAccounts() {
		
		new AccountManager(this);
		
	}
	
	/**
	 * Create an instance of the account data class
	 * used for underlying data structures
	 */
	private void initializeAccountData() {
		
		new AccountData(this);
		
	}
	
	private void initializeInterest() {
		
		if(Nodes.INTEREST.getBoolean() == false) return;
		
		interest = new Interest(this);
		
		interest.runTaskTimer(this, interest.getTimeUntilExecute() * 20L, Nodes.INTERESTINTERVAL.getInt() * 20L);
		
	}

}
