
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


public class CmdVtake implements CommandExecutor {
    
    private final Main plugin;
    
    public CmdVtake(Main instance) {
        this.plugin = instance;
    }
        
       Useful_methods EVA = new Useful_methods();
        
        
        @Override
        public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
            if (args.length != 2) {
                sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
                sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vtake <usuario> <cantidad>"));
                return true;
            }
            
            if (commandlabel.equalsIgnoreCase("vtake")) {
                
                double amounttaken = 0;
                
                try {
                    amounttaken = Double.parseDouble(args [1]);
                }
                
                catch(Exception e) {
                    sender.sendMessage(EVA.Text_formatter("&cDebes introducir un número válido."));
                    return true;
                     }
                
                if (Double.parseDouble(args[1]) <= 0) {
                    sender.sendMessage(EVA.Text_formatter("&cEl valor debe ser superior a 0."));
                    return true;
                }
                Economy econ = Main.getEconomy();
                OfflinePlayer receiver = Bukkit.getOfflinePlayer(args[0]);
                
                if ((econ.hasAccount(receiver)) && (amounttaken < econ.getBalance(receiver))) {
                     EconomyResponse er = econ.withdrawPlayer(receiver, amounttaken);
                     sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &f"+EVA.Decimal_formatter.format(amounttaken)+ " créditos &2han sido sacados de la cuenta de &f"+receiver.getName()+"&2.")); 
                     return true;        
                }
                else {
                    if ((econ.hasAccount(receiver)) && (amounttaken > econ.getBalance(receiver))) {
                         sender.sendMessage(EVA.Text_formatter("&cLa cantidad de dinero que has introducido es superior al dinero que actualmente tiene el usuario."));   
                         return true;
                        }
                    
                    if (!econ.hasAccount(receiver)) {
                         sender.sendMessage(EVA.Text_formatter("&cLa cuenta que has introducido no existe."));
                         return true;
                         }
                
                }
            }
                   
         return true;
     }
}
