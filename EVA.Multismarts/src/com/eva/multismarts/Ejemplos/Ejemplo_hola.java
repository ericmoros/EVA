package com.eva.multismarts.Ejemplos;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.Configs;
import static com.eva.multismarts.Main.Ejsconfig2;
import static com.eva.multismarts.Main.Ejsconfig2_data;
import static com.eva.multismarts.Main.loadConfig;
import static com.eva.multismarts.Main.saveConfig;
import com.eva.multismarts.Useful_methods;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Ejemplo_hola implements CommandExecutor {
    private final Main plugin;
    private File Ejsconfig2_file;
    public Ejemplo_hola(Main instance) {
        plugin = instance;
    }
    
    @Override
    public boolean onCommand(CommandSender Emisor, Command Comando, String Etiqueta, String[] Argumentos) {
        //FileConfiguration config = plugin.getConfig();
//        plugin.loadYamls();
        //boolean Hola_Estado = (boolean) plugin.Ejsconfig.getBoolean("Hola.State");
        //String Hola_Mensaje = plugin.config.getString("Multismarts.Módulos.Ejemplos");
        String Hola_Mensaje = plugin.Ejsconfig2.getString("ejemplo.test");
        
        
        boolean Hola_Estado = true;
        //String Hola_Mensaje = "&9Ey, bienvenido&9 Jugador_nombre";
        
        if (Etiqueta.equalsIgnoreCase("hola") && Hola_Estado == true) {
            if (Emisor instanceof Player) {
                Player Jugador = (Player)Emisor;
                Jugador.sendMessage(Useful_methods.Text_formatter(Hola_Mensaje).replaceAll("Jugador_nombre", Jugador.getDisplayName()));
                if (Argumentos.length >= 1) {
                    Jugador.sendMessage("No voy a procesar "+Arrays.toString(Argumentos)+"...");
                }
            } else {
                Emisor.sendMessage("Buenos días usuario de la terminal");
                if (Argumentos.length >= 1) {
                    Emisor.sendMessage("No voy a procesar "+Arrays.toString(Argumentos)+"...");
                }
            }
            //_______________
            Emisor.sendMessage(Hola_Mensaje);
            Ejsconfig2.set("ejemplo.test", "Iluminati en la configuración confirmed");
            saveConfig(Ejsconfig2);
            loadConfig(Ejsconfig2);
            Hola_Mensaje = plugin.Ejsconfig2.getString("ejemplo.test");
            Emisor.sendMessage(Hola_Mensaje);
            //_______________
        } else {
            Emisor.sendMessage("Este comando está desactivado");
        }
        return true;
    }
}