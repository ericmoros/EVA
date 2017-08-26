
package com.eva.multismarts.vconomy;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdVmoney implements CommandExecutor {
    
    private final Main plugin;
   
    public CmdVmoney(Main instance) {
        this.plugin = instance;
    }
    
    Useful_methods EVA = new Useful_methods();
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
        
       if (args.length != 0) {
             sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
             sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vmoney"));
             return true;
         }
       
       if (commandlabel.equalsIgnoreCase("vmoney")) {
             Economy econ = Main.getEconomy();
             
        double money = econ.getBalance((Player) sender);
        
        sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2Tienes &f" +EVA.Decimal_formatter.format(money)+ " créditos&2."));
        
        return true;
    }
      return true;
    }
}