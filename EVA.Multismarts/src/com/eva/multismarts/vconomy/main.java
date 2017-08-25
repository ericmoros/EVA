package com.eva.multismarts.vconomy;
        
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onEnable() {
         if (getServer().getPluginManager().getPlugin("Vault") != null) {
            setupEconomy();
        } else {
             this.getServer().getPluginManager().disablePlugin(this);
         }
    }
    
    private boolean setupEconomy() {
       
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
   
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        
        if(args.length != 1) {
             sender.sendMessage("La sintaxis del comando que has introducido es incorrecta.");
             sender.sendMessage("Sintaxis correcta: /vreceive <cantidad>");
             return true;
         }
          
        if (commandLabel.equalsIgnoreCase("vreceive")) {
            
            double cantidad = 0;
        
         try 
         {
			
			cantidad = Double.parseDouble(args[0]);
			
	 } catch(Exception e) 
          {
			
                    sender.sendMessage("Debes introducir un número válido");
			return true;
			
	  }
            EconomyResponse er = econ.depositPlayer((Player) sender, cantidad);
            if (er.transactionSuccess()) {
                sender.sendMessage("Has recibido 10 créditos");
            } else {
                sender.sendMessage("Eres un usuario de mierda, ponte a trabajar vago");
            }
        }
        
        Player player = (Player) sender;
        
        if(command.getLabel().equals("test-economy")) {
            // Lets give the player 1.05 currency (note that SOME economic plugins require rounding!)
            sender.sendMessage(String.format("You have %s", econ.format(econ.getBalance(player.getName()))));
            EconomyResponse r = econ.depositPlayer(player, 1.05);
            if(r.transactionSuccess()) {
                sender.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
            } else {
                sender.sendMessage(String.format("An error occured: %s", r.errorMessage));
            }
            return true;
        } else if(command.getLabel().equals("test-permission")) {
            // Lets test if user has the node "example.plugin.awesome" to determine if they are awesome or just suck
            if(perms.has(player, "example.plugin.awesome")) {
                sender.sendMessage("You are awesome!");
            } else {
                sender.sendMessage("You suck!");
            }
            return true;
        } else {
            return false;
        }
    }
    
    public static Economy getEcononomy() {
        return econ;
    }
    
    
}
