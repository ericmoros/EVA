
package com.eva.multismarts.vscoreboard;

import com.eva.multismarts.Main;
import static com.eva.multismarts.vscoreboard.Board.setBoard;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Task extends BukkitRunnable {
 
    private final Main plugin;
    private final Player p;
    
    public Task(Main instance, Player player) {
        plugin = instance;
        p = player;
    }
    
    @Override
    public void run() {
        //Si el jugador no esta conectado, se cancela el task (Importante para no producir lag innecesario.
        if (!p.isOnline()) cancel();
        
        setBoard(p);
    }
}
