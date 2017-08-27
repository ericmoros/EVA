
package com.eva.multismarts.vconomy;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

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
        
       if ((args.length != 0) && (args.length != 1)) {
             sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
             sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vmoney"));
             return true;
         }
       
       if (commandlabel.equalsIgnoreCase("vmoney")) {
             Economy econ = Main.getEconomy();
             
             
            
             if (args.length == 0) {
                     double money = econ.getBalance((Player) sender);
                     sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2Tienes &f" +EVA.Decimal_formatter.format(money)+ " créditos&2."));
                     return true;
             }
             
             OfflinePlayer receiver = Bukkit.getOfflinePlayer(args[0]);
             if (args.length == 1) {
                 if(econ.hasAccount(receiver)) {
                     double money = econ.getBalance(receiver);
                     sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &f"+receiver.getName()+"&2 tiene &f"+EVA.Decimal_formatter.format(money)+" créditos&2."));
                     return true;
                     } 
                 else {
                     sender.sendMessage(EVA.Text_formatter("&cLa cuenta que has introducido no existe."));
                     return true;
                 }
              }                 
          }
       return true;
    }
}