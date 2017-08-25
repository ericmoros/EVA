
package com.eva.multismarts.vconomy;

import com.eva.multismarts.Main;
import java.text.DecimalFormat;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class CmdVmoney implements CommandExecutor {
    
    private final Main plugin;
    
    public CmdVmoney(Main instance) {
        this.plugin = instance;
    }
    DecimalFormat formateardec = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.##");
    
    public String formateartext(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
        
       if (args.length != 0) {
             sender.sendMessage(formateartext("&cLa sintaxis del comando que has introducido es incorrecta."));
             sender.sendMessage(formateartext("&2Sintaxis correcta:&f /vmoney"));
             return true;
         }
       
       if (commandlabel.equalsIgnoreCase("vmoney"));
             Economy econ = Main.getEconomy();
             
        double dinero = econ.getBalance((Player) sender);
        
        sender.sendMessage(formateartext("&a[&fEconomía&a] &2Tienes &f" +formateardec.format(dinero)+ " créditos&2."));
        
        return true;
    }
    
    
    
    
    
    
}
