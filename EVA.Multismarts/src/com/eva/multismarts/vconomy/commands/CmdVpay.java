

package com.eva.multismarts.vconomy.commands;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CmdVpay implements CommandExecutor {
    private final Main plugin;
    public CmdVpay (Main instance) {
            this.plugin = instance;
    }
    
    Useful_methods EVA = new Useful_methods();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        
        if (args.length != 2)
        {
            sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
            sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vpay <usuario> <cantidad>"));
            return true;
        }
        
        if (commandlabel.equalsIgnoreCase("vpay")) {
            double amountpaid = 0;
            
            try {
                amountpaid = Double.parseDouble(args[1]);
            }
            catch (Exception e) {
                sender.sendMessage(EVA.Text_formatter("&cDebes introducir un número válido."));
                return true;
            }
            
            Economy econ = Main.getEconomy();
            OfflinePlayer receiver = Bukkit.getOfflinePlayer(args[0]);
            
            if (amountpaid <= 0) {
                sender.sendMessage(EVA.Text_formatter("&cEl valor debe ser superior a 0."));
                return true;
            }
            
            if ((amountpaid <= econ.getBalance((OfflinePlayer) sender)) && (econ.hasAccount(receiver))) {
               econ.depositPlayer(receiver, amountpaid);
               econ.withdrawPlayer((OfflinePlayer) sender, amountpaid);
               sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2Has transferido &f"+EVA.Decimal_formatter.format(amountpaid)+" créditos &2a &f"+receiver.getName()+"&2."));
               
               if (receiver.isOnline()){
                   receiver.getPlayer().sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &f"+sender.getName()+"&2 te ha transferido &f"+EVA.Decimal_formatter.format(amountpaid)+" créditos&2."));
               }
           }
               else {
                   if (amountpaid > econ.getBalance((OfflinePlayer) sender)) {
                   sender.sendMessage(EVA.Text_formatter("&cNo tienes suficiente dinero para realizar la transferencia."));
                   }
                   if (!econ.hasAccount(receiver)) {
                   sender.sendMessage(EVA.Text_formatter("&cLa cuenta que has introducido no existe."));
                   }
                 }   
     }
    return true;
   }  
}
