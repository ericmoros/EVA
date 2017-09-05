package com.eva.multismarts.ESpawn;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdESpawn implements CommandExecutor {
    private final Main plugin;
    public CmdESpawn(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("espawn")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                player.sendMessage(Useful_methods.Text_formatter("Generating configuration <player>").replaceAll("<player>", player.getDisplayName()));
                
            } else {
                sender.sendMessage("Desde la terminal has de especificar el mundo para el que quieres generar la configuración");
            }
        }
        return true;
    }
    
    
    private genDataWorld() {
        
    }
}
