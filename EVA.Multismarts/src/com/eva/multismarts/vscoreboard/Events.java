/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eva.multismarts.vscoreboard;

import static com.eva.multismarts.Main.ConfigVscoreboarddata;
import static com.eva.multismarts.Main.saveConfig;
import static com.eva.multismarts.vscoreboard.Board.cfgdata;
import org.bukkit.entity.Player;


public class Events {
    //EVENTOS
    
      //Añade un asesinato(kill) en la configuración al asesino.
    
      public static void addKill(Player p, int kills) {
            
            int kill = cfgdata.getInt(p.getName() + "." + "Kills");
            int newkill = kills;
            
            cfgdata.set(p.getName() + "." + "Kills", kill+newkill);
            saveConfig(cfgdata);
        }
      
        //Añade una muerte(death) en la configuración al muerto.
      
        public static void addDeath(Player p, int deaths) {
            
            int death = cfgdata.getInt(p.getName() + "." + "Deaths");
            int newdeath = deaths;
            
            cfgdata.set(p.getName() + "." + "Deaths", death + newdeath);
            saveConfig(cfgdata);
        }
        
        //Añade un KD ratio al usuario asesino y al usuario muerto.
        public static void addKDratio(Player p) {
            
            double kills = cfgdata.getInt(p.getName() + "." + "Kills");
            double deaths = cfgdata.getInt(p.getName() + "." + "Deaths");
            
            if (deaths == 0) {
                cfgdata.set(p.getName() + "." + "Ratio", kills/1);
                saveConfig(ConfigVscoreboarddata);
            } else {
                ConfigVscoreboarddata.set(p.getName() + "." + "Ratio", kills/deaths);
                saveConfig(ConfigVscoreboarddata);
            }
            
        }
}
