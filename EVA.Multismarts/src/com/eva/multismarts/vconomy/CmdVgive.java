
package com.eva.multismarts.vconomy;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CmdVgive implements CommandExecutor {
    
    private final Main plugin;
    public CmdVgive(Main instance) {
        this.plugin = instance;
    }
    
    Useful_methods EVA = new Useful_methods();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if (args.length !=2) {
            sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
            sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vgive <usuario> <cantidad>"));
            return true;
        }
        if (commandlabel.equalsIgnoreCase("vgive")) {
            
            double amountgiven = 0;
            
            try {
                amountgiven = Double.parseDouble(args[1]);
            }
            catch(Exception e) {
                sender.sendMessage(EVA.Text_formatter("&cDebes introducir un número válido."));
                return true;
            }
            
         if (amountgiven <= 0) {
             sender.sendMessage(EVA.Text_formatter("&cEl valor debe ser superior a 0."));
             return true;
         }
         
         Economy econ = Main.getEconomy();
         OfflinePlayer receiver = Bukkit.getOfflinePlayer(args [0]);
         
         if (econ.hasAccount(receiver)) {
             
             if (sender == receiver) {
                 sender.sendMessage(EVA.Text_formatter("&cNo puedes darte dinero a ti mismo con este comando."));
                 sender.sendMessage(EVA.Text_formatter("&2Comando correcto para esa acción: &f/vreceive <cantidad>"));
                  }
             else {
                  EconomyResponse er = econ.depositPlayer(receiver, amountgiven);
                  sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &f"+EVA.Decimal_formatter.format(amountgiven)+ " créditos &2han sido transferidos a la cuenta de &f"+receiver.getName()+"&2."));
                  if (receiver.isOnline()) {
                     receiver.getPlayer().sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2Has recibido &f" +EVA.Decimal_formatter.format(amountgiven)+" &fcréditos&2."));
                     return true;
                     }
                  return true;
            }
             return true;
         }
         else {
             sender.sendMessage(EVA.Text_formatter("&cLa cuenta que has introducido no existe."));
             return true;
         }
       }
        return true;
    }
    
}
