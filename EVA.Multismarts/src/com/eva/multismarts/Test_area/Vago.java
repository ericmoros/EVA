package com.eva.multismarts.Test_area;

import com.eva.multismarts.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vago implements CommandExecutor {
    private final Main plugin;
    public Vago(Main instance) {
        this.plugin = instance;
    }
    
    
    @Override
    public boolean onCommand(CommandSender Emisor, Command Comando, String Etiqueta, String[] Argumentos) {
        if (Etiqueta.equalsIgnoreCase("Vago")) {
            if (Emisor instanceof Player) {
                Player Jugador = (Player)Emisor;
                Jugador.sendMessage("[ERROR] Mala suerte jugador, este comando es demasiado vago como para hacer algo útil...");
            } else {
                Emisor.sendMessage("[ERROR] Mala suerte usuario de la consola, este comando es demasiado vago como para hacer algo util...");
            }
        }
        return true;
    }
    
}
