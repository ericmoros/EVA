
package com.eva.multismarts.vconomy;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CmdVreset implements CommandExecutor {
    
    private final Main plugin;
    
    public CmdVreset(Main instance){
        this.plugin = instance;
    }
    
    Useful_methods EVA = new Useful_methods();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labelcommand, String[] args) {
        
        if (args.length != 1) {
            sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
            sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vreset <usuario>"));
            return true;
        }
        
        Economy econ = Main.getEconomy();
        OfflinePlayer receiver = Bukkit.getOfflinePlayer(args[0]);
        
        if (labelcommand.equalsIgnoreCase("vreset"))
        {
            if ((econ.hasAccount(receiver)) && (econ.getBalance(receiver) > 0)){
                econ.withdrawPlayer(receiver, econ.getBalance(receiver));
                sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2La cantidad de dinero que tenía&f "+receiver.getName()+" &2ha sido reseteada."));     
                if (receiver.isOnline())
                {
                    receiver.getPlayer().sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2La cantidad de dinero que tenías ha sido reseteada."));
                }
            }
            
            else {
                
                if (!econ.hasAccount(receiver)) {
                    sender.sendMessage(EVA.Text_formatter("&cLa cuenta que has introducido no existe."));  
                    return true;
                }
                if ((econ.getBalance(receiver) <= 0) && (econ.hasAccount(receiver))) {
                    sender.sendMessage(EVA.Text_formatter("&cEl usuario &4"+receiver.getName()+" &cya tiene 0 créditos."));
                    return true;
                }
            }
        }
      return true;
    }
  }
