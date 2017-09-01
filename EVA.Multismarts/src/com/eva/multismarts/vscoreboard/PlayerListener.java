package com.eva.multismarts.vscoreboard;


import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ConfigVscoreboard;
import static com.eva.multismarts.Main.instance;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import static sun.security.krb5.SCDynamicStoreConfig.getConfig;


public class PlayerListener implements Listener {
   
    private final Main plugin;
    

    public PlayerListener(Main instance) {
        this.plugin = instance;
    }
 
       
       public static void setBoard(Player p) {
           
        //Objetos para un uso cómodo del código
      
        String symbolscore = ("&f» ");
                
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective obj = board.registerNewObjective("aaa", "bbb");
        
        Economy econ = Main.getEconomy();
        
        double playermoney = econ.getBalance(p);
      
        int numberplayers = getServer().getOnlinePlayers().size();
        
        
        String nameuser = p.getName();
   
        //Scores traidos desde config.yml
        
             String titlesc = ConfigVscoreboard.getString("VScoreboard.Title");
             String usersc = ConfigVscoreboard.getString("VScoreboard.User");
             String usernamesc = ConfigVscoreboard.getString("VScoreboard.Username");
             String playersc = ConfigVscoreboard.getString("VScoreboard.Players");
             String numberplayersc = ConfigVscoreboard.getString("VScoreboard.Numberplayers");
             String moneysc = ConfigVscoreboard.getString("VScoreboard.Money");
             String amountmoneysc = ConfigVscoreboard.getString("VScoreboard.Amountmoney");
             String teamspeaksc = ConfigVscoreboard.getString("VScoreboard.Teamspeak");
             String teamspeakipsc = ConfigVscoreboard.getString("VScoreboard.Teamspeakip");
             
             
        //Tipo de Scoreboard y su título.
        
        obj.setDisplayName(Useful_methods.Text_formatter(titlesc));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        //Resultados del marcador
               //Barra limitadora del título
        
                Score bar = obj.getScore(Useful_methods.Text_formatter("&4-------------------"));
        
               //Espacios
        
                Score space1 = obj.getScore(Useful_methods.Text_formatter("&4"));
                Score space2 = obj.getScore(Useful_methods.Text_formatter("&5"));
                Score space3 = obj.getScore(Useful_methods.Text_formatter("&6"));
                
               //Nombre de usuario
         
                 Score user = obj.getScore(Useful_methods.Text_formatter(symbolscore+usersc));
                 Score username = obj.getScore(Useful_methods.Text_formatter(symbolscore+nameuser));
        
               //Número de jugadores conectados
         
                 Score players = obj.getScore(Useful_methods.Text_formatter(symbolscore+playersc));
                 Score playersscore = obj.getScore(Useful_methods.Text_formatter(symbolscore+numberplayers+numberplayersc));
                 
               //Dinero del jugador
               
                 Score money = obj.getScore(Useful_methods.Text_formatter(symbolscore+moneysc));
                 Score displaymoney = obj.getScore(Useful_methods.Text_formatter(symbolscore+Useful_methods.Decimal_formatter.format(playermoney)+" créditos."));
                 
               //Dirección del servidor de TeamSpeak 3.
         
                Score teamspeak = obj.getScore(Useful_methods.Text_formatter(symbolscore+teamspeaksc));
                Score teamspeaksv = obj.getScore(Useful_methods.Text_formatter(symbolscore+teamspeakipsc));
        
        
        //Orden de los marcadores
        
                bar.setScore(12);
                
                user.setScore(11);
                
                username.setScore(10);
                
                space1.setScore(9);
                
                players.setScore(8);
                
                playersscore.setScore(7);
                
                space2.setScore(6);
                
                money.setScore(5);
                
                displaymoney.setScore(4);
                
                space3.setScore(3);
                
                teamspeak.setScore(2);
                
                teamspeaksv.setScore(1);
        
       //Añadirle el scoreboard al jugador
       
        p.setScoreboard(board);        
}       
       //Al conectarse un jugador se adjudica el scoreboard actualizado a todos los jugadores
       
       @EventHandler
       public void onJoin(PlayerJoinEvent e) {
 
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
}

