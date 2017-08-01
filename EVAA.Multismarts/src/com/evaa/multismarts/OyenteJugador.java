package com.evaa.multismarts;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OyenteJugador implements Listener{
    private final Main plugin;
    public OyenteJugador (Main instance) {
        plugin = instance;
    }
    @EventHandler (priority = EventPriority.LOWEST)
    public void Jugador_acceso(PlayerJoinEvent event) {
        FileConfiguration config = plugin.getConfig();
        boolean Jugador_acceso_Estado = config.getBoolean("Jugador_acceso.Estado");
        String Jugador_acceso_Mensaje = config.getString("Jugador_acceso.Mensaje");
        if (Jugador_acceso_Estado == true) {
            Player Jugador = event.getPlayer();
            Jugador.sendMessage(plugin.Formatear_texto(Jugador_acceso_Mensaje).replaceAll("Jugador_nombre", Jugador.getDisplayName()));
        }
    }
    @EventHandler
    public void Jugador_movimiento (PlayerMoveEvent event) {
        FileConfiguration config = plugin.getConfig();
        boolean Jugador_movimiento_Estado = config.getBoolean("Jugador_movimiento.Estado");
        Integer Jugador_movimiento_Experiencia = config.getInt("Jugador_movimiento.Experiencia");
        if (Jugador_movimiento_Estado == true) {
            Player Jugador = event.getPlayer();
            Jugador.giveExp(Jugador_movimiento_Experiencia);
        }
    }
}
