
package com.eva.multismarts.vscoreboard;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import static com.eva.multismarts.vscoreboard.Board.cfg;
import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;




public class CmdVScoreboard implements CommandExecutor {
    
    private final Main plugin;
    public CmdVScoreboard(Main instance) {
        this.plugin = instance;     
    }
    
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        Player p = (Player) sender;
        
        if (args.length != 1) {
            p.sendMessage(Useful_methods.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
            p.sendMessage(Useful_methods.Text_formatter("&2Sintaxis correcta:&f /setscoreboard on:off"));
            return true;
        }
        
        if (commandlabel.equalsIgnoreCase("setscoreboard")) {
            if (args[0].equalsIgnoreCase("on")) {
                long set = cfg.getLong("Timer.Set_time");
                long update = cfg.getLong("Timer.Refresh_time");
 
                Task2 task = new Task2(plugin, p.getPlayer());
                task.runTaskTimer(plugin, set*20, update*20);
                return true;
        }
            if (args[0].equalsIgnoreCase("off")) {
                
                 Task1 task = new Task1(plugin, p.getPlayer());
                 Bukkit.getScheduler().cancelTasks(plugin);
               
                Scoreboard removescoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                p.setScoreboard(removescoreboard);
                return true;
            }
            return true;
        }
        return true;
    }
    
} 
