/*
package com.eva.multismarts.vconomy.commands;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CmdVtopmoney implements CommandExecutor{
    private final Main plugin;
    
    public CmdVtopmoney(Main instance) {
        this.plugin = instance;
    }
    
    Useful_methods EVA = new Useful_methods();
    
    @Override
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if (args.length != 0) {
            sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
            sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vtopmoney."));
        }
        
        List<Account> accounts = AccountManager.getTopAccounts();
        if (commandlabel.equalsIgnoreCase("vtopmoney")) {
            
        }
    }
    
    
}
*/