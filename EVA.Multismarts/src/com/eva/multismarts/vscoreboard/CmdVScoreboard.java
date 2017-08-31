/*
package com.eva.multismarts.vscoreboard;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;



public class CmdVScoreboard implements CommandExecutor {
    
    private final Main plugin;
    public CmdVScoreboard(Main instance) {
        this.plugin = instance;     
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        Player p = (Player) sender;
        Objective obj = Bukkit.getScoreboardManager().getNewScoreboard().registerNewObjective("aaa", "bbb");
        
        if (args.length != 1) {
            p.sendMessage(Useful_methods.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta.\""));
            p.sendMessage(Useful_methods.Text_formatter("&2Sintaxis correcta:&f /vscoreboard off:on"));
        }
        
        if (commandlabel.equalsIgnoreCase("vscoreboard")) {
            if (args[0].equalsIgnoreCase("off")) {
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                return true;
        }
        }
        return true;
    }
    
} */
