package com.eva.multismarts.vscoreboard;


import static com.avaje.ebeaninternal.server.lib.sql.Prefix.e;
import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ConfigVscoreboard;
import static com.eva.multismarts.Main.ConfigVscoreboard_file;
import static com.eva.multismarts.Main.ConfigVscoreboarddata;
import static com.eva.multismarts.Main.ConfigVscoreboarddata_file;
import com.eva.multismarts.Useful_methods;
import java.io.IOException;
import java.util.HashMap;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class PlayerListener implements Listener {
   
    private final Main plugin;
    
    public static FileConfiguration cfg = ConfigVscoreboard;
    
    public static  FileConfiguration cfgdata = ConfigVscoreboarddata;
    

    public PlayerListener(Main instance) {
        this.plugin = instance;
    }
 
    
       
       
       public static void setBoard(Player p) {
           
        //Objetos y variables para un uso cómodo del código
        
        
        int numberplayers = getServer().getOnlinePlayers().size();
        
        int maxplayers = getServer().getMaxPlayers();
        
        String nameserver = getServer().getServerName();
        
        String nameuser = p.getName();
        
        Economy econ = Main.getEconomy();
        
        String playermoney = Useful_methods.Decimal_formatter.format(econ.getBalance(p));
        
        String worldname = getServer().getWorldType();    
        
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective obj = board.registerNewObjective("aaa", "bbb");
            
         //Scores traidos desde config.yml y valores sustituidos en config por variables de la clase.
        
          String titlecfg = cfg.getString("VScoreboard.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String barcfg = cfg.getString("VScoreboard.Spacer").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text1acfg = cfg.getString("VScoreboard.Text1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text1bcfg =cfg.getString("VScoreboard.Text1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text2acfg = cfg.getString("VScoreboard.Text2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text2bcfg = cfg.getString("VScoreboard.Text2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text3acfg = cfg.getString("VScoreboard.Text3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text3bcfg = cfg.getString("VScoreboard.Text3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text4acfg = cfg.getString("VScoreboard.Text4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
          String text4bcfg = cfg.getString("VScoreboard.Text4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers));
      
        //Tipo de Scoreboard y su título.
        
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfg));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        //Resultados del marcador
        
               //Barra limitadora del título
        
                Score bar = obj.getScore(Useful_methods.Text_formatter(barcfg));
        
               //Espacios
        
                Score space1 = obj.getScore(Useful_methods.Text_formatter("&4"));
                Score space2 = obj.getScore(Useful_methods.Text_formatter("&5"));
                Score space3 = obj.getScore(Useful_methods.Text_formatter("&6"));
                
               //Nombre de usuario
         
                 Score text1a = obj.getScore(Useful_methods.Text_formatter(text1acfg));
                 Score text1b = obj.getScore(Useful_methods.Text_formatter(text1bcfg));
        
               //Número de jugadores conectados
         
                 Score text2a = obj.getScore(Useful_methods.Text_formatter(text2acfg));
                 Score text2b = obj.getScore(Useful_methods.Text_formatter(text2bcfg));
                 
               //Dinero del jugador
               
                 Score text3a = obj.getScore(Useful_methods.Text_formatter(text3acfg));
                 Score text3b = obj.getScore(Useful_methods.Text_formatter(text3bcfg));
                 
               //Dirección del servidor de TeamSpeak 3.
         
                 Score text4a = obj.getScore(Useful_methods.Text_formatter(text4acfg));
                 Score text4b = obj.getScore(Useful_methods.Text_formatter(text4bcfg));
        
        
        //Orden de los marcadores
        
                bar.setScore(12);
                
                text1a.setScore(11);
                
                text1b.setScore(10);
                
                space1.setScore(9);
                
                text2a.setScore(8);
                
                text2b.setScore(7);
                
                space2.setScore(6);
                
                text3a.setScore(5);
                
                text3b.setScore(4);
                
                space3.setScore(3);
                
                text4a.setScore(2);
                
                text4b.setScore(1);
        
       //Añadirle el scoreboard al jugador
       
        p.setScoreboard(board);        
}       
     // EVENTOS
      
       //Al conectarse un jugador se adjudica el scoreboard actualizado a todos los jugadores
    
       @EventHandler
       public void onJoin(PlayerJoinEvent e) throws IOException {
           
           Player p = e.getPlayer();
         
           if (!cfgdata.contains(p.getName())) { 
               cfgdata.set(p.getName(), ":" + 0);
               cfgdata.save(ConfigVscoreboarddata_file);
               
           } else {
             return;
           }
          
             for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                setBoard(all);
                 }  
            }
      
       //Al desconectarse un jugador se adjudica el scoreboard actualizado a todos los jugadores
      
        @EventHandler
        public void onQuit(PlayerQuitEvent e){
        //Se tuvo que implementar un delay, ya que sino no daba tiempo a que cambiase el valor del numero de jugadores al actualizarlo.
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
        @Override
        public void run() {
             for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            setBoard(all);
             }
           }
     }, 1);       
  }
        
        public void addKill(Player p, int kills) throws IOException {
            
            int i = cfgdata.getInt(p.getName());
            int a = kills;
            cfgdata.set(p.getName(), "." + i+a);
            cfgdata.save(ConfigVscoreboarddata_file);  
        }
        
        @EventHandler
         public void onDeath(PlayerDeathEvent e) throws IOException {
             Player dead = e.getEntity();
             Player killer = dead.getKiller();
             
             addKill(killer , 1);
             
         }
        
         
       
}

