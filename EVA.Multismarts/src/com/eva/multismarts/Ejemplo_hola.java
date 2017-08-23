/*
package com.eva.multismarts;
// klk bro
import java.util.Arrays;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Ejemplo_hola implements CommandExecutor {
    private final Ejemplo_Main plugin;
    public Ejemplo_hola(Ejemplo_Main instance)  {
        plugin = instance;
    }
    @Override
    public boolean onCommand(CommandSender Emisor, Command Comando, String Etiqueta, String[] Argumentos) {
        FileConfiguration config = plugin.getConfig();
        boolean Hola_Estado = config.getBoolean("Hola.Estado");
        String Hola_Mensaje = config.getString("Hola.Mensaje");
        if (Etiqueta.equalsIgnoreCase("hola") && Hola_Estado == true) {
            if (Emisor instanceof Player) {
                Player Jugador = (Player)Emisor;
                Jugador.sendMessage(plugin.Formatear_texto(Hola_Mensaje).replaceAll("Jugador_nombre", Jugador.getDisplayName()));
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
*/