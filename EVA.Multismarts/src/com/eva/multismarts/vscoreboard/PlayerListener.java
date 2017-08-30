package com.eva.multismarts.vscoreboard;


import com.eva.multismarts.Main;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;


public class PlayerListener implements Listener {
   
    private final Main plugin;
    
    public PlayerListener(Main instance) {
        this.plugin = instance;
    }

    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
       Scoreboard board = Main.getScoreboard();
       Objective objetivo = Main.getObjetivo();
        e.getPlayer().setScoreboard(board);
    }
   
    private final HashMap<Player, Integer> bloquesRotos = new HashMap<>();
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Objective objetivo = Main.getObjetivo();
        Scoreboard board = Main.getScoreboard();
        int bloques = 0;
        if (bloquesRotos.containsKey(e.getPlayer())) {
            bloques = bloquesRotos.get(e.getPlayer());
        }
        bloques++;
        bloquesRotos.put(e.getPlayer(), bloques);
        board.getObjective(DisplaySlot.SIDEBAR).getScore(e.getPlayer().getName()).setScore(bloques);
    }
}
