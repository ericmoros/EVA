package com.eva.multismarts.Ejemplos;

import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;

import java.util.Arrays;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Ejemplo_hola implements CommandExecutor {
    private final Main plugin;
    Useful_methods EVA = new Useful_methods();
    public Ejemplo_hola(Main instance) {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender Emisor, Command Comando, String Etiqueta, String[] Argumentos) {
        //FileConfiguration config = plugin.getConfig();
        //boolean Hola_Estado = config.getBoolean("Hola.State");
        //String Hola_Mensaje = config.getString("Hola.Mensage");
        
        boolean Hola_Estado = true;
        String Hola_Mensaje = "&9Ey, bienvenido&9 Jugador_nombre";
        
        if (Etiqueta.equalsIgnoreCase("hola") && Hola_Estado == true) {
            if (Emisor instanceof Player) {
                Player Jugador = (Player)Emisor;
                Jugador.sendMessage(EVA.Text_formatter(Hola_Mensaje).replaceAll("Jugador_nombre", Jugador.getDisplayName()));
                if (Argumentos.length >= 1) {
                    Jugador.sendMessage("No voy a procesar "+Arrays.toString(Argumentos)+"...");
                }
            } else {
                Emisor.sendMessage("Buenos días usuario de la terminal");
                if (Argumentos.length >= 1) {
                    Emisor.sendMessage("No voy a procesar "+Arrays.toString(Argumentos)+"...");
                }
            }
        } else {
            Emisor.sendMessage("Este comando está desactivado");
        }
        return true;
    }
}