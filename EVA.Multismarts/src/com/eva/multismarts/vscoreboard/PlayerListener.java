
 
package com.eva.multismarts.vscoreboard;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.saveConfig;
import static com.eva.multismarts.vscoreboard.Board.cfg;
import static com.eva.multismarts.vscoreboard.Board.cfgdata;
import static com.eva.multismarts.vscoreboard.Board.setBoard;
import static com.eva.multismarts.vscoreboard.Events.addDeath;
import static com.eva.multismarts.vscoreboard.Events.addKDratio;
import static com.eva.multismarts.vscoreboard.Events.addKill;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener{
    
private final Main plugin;
  
    public PlayerListener (Main instance) {
        this.plugin = instance;
    }
   
    
    // EVENTOS
      
       //Al conectarse un jugador, si no había entrado antes, se le crea en la el archivo configdata su nombre y los datos de sus kills, deaths y kd.
    
       @EventHandler
       public void onJoin(PlayerJoinEvent e) throws IOException  {
           
           Player p = e.getPlayer();
         
           if (!cfgdata.contains(p.getName())) { 
               
               cfgdata.createSection(p.getName() + "." + "Kills");
               cfgdata.createSection(p.getName() + "." + "Deaths");
               cfgdata.createSection(p.getName() + "." + "Ratio");
               
               cfgdata.set(p.getName() + "." + "Kills", 0);
               cfgdata.set(p.getName() + "." + "Deaths", 0);
               cfgdata.set(p.getName() + "." + "Ratio", 0);
               
               saveConfig(cfgdata);
               } 
           
           //Task, inicia a partir de 1 segundo después de que el jugador se conecte, y se actualiza cada 2 segundos.
           long set = cfg.getLong("Timer.Set_time");
           long update = cfg.getLong("Timer.Refresh_time");
           
           Task1 task = new Task1(plugin, e.getPlayer());
        task.runTaskTimer(plugin, set*20, update*20).getTaskId();
          
       

     }

        //Al morirse un jugador, se adjudican el kill y muerte correspondiente a cada jugador del combate.
        
         @EventHandler
         public void onDeath(PlayerDeathEvent e)  {
             
             Player dead = e.getEntity();
             Player killer = dead.getKiller();
             
             addDeath(dead , 1);
             
             addKill(killer , 1);   
             
             addKDratio(dead);
             addKDratio(killer);
         }
    }