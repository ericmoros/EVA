package com.eva.multismarts.vscoreboard;


import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ConfigVscoreboard;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class PlayerListener implements Listener {
   
    private final Main plugin;
    

    public PlayerListener(Main instance) {
        this.plugin = instance;
    }
 
       
       public static void setBoard(Player p) {
           
        //Objetos y variables para un uso cómodo del código
             
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective obj = board.registerNewObjective("aaa", "bbb");
        
        Economy econ = Main.getEconomy();
        
        String playermoney = Useful_methods.Decimal_formatter.format(econ.getBalance(p));
      
        int numberplayers = getServer().getOnlinePlayers().size();

        String nameuser = p.getName();
   
         //Scores traidos desde config.yml y valores sustituidos en config por variables de la clase.
        
          String titlesc = ConfigVscoreboard.getString("VScoreboard.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String barsc = ConfigVscoreboard.getString("VScoreboard.Spacer").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String usersc = ConfigVscoreboard.getString("VScoreboard.Text1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String usernamesc =ConfigVscoreboard.getString("VScoreboard.Text1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);     
          String playersc = ConfigVscoreboard.getString("VScoreboard.Text2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String numberplayersc = ConfigVscoreboard.getString("VScoreboard.Text2b").replaceAll("<numberplayers>", Integer.toString(numberplayers));
          String moneysc = ConfigVscoreboard.getString("VScoreboard.Text3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String amountmoneysc = ConfigVscoreboard.getString("VScoreboard.Text3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String teamspeaksc = ConfigVscoreboard.getString("VScoreboard.Text4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
          String teamspeakipsc = ConfigVscoreboard.getString("VScoreboard.Text4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney);
      
        //Tipo de Scoreboard y su título.
        
        obj.setDisplayName(Useful_methods.Text_formatter(titlesc));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        //Resultados del marcador
        
               //Barra limitadora del título
        
                Score bar = obj.getScore(Useful_methods.Text_formatter(barsc));
        
               //Espacios
        
                Score space1 = obj.getScore(Useful_methods.Text_formatter("&4"));
                Score space2 = obj.getScore(Useful_methods.Text_formatter("&5"));
                Score space3 = obj.getScore(Useful_methods.Text_formatter("&6"));
                
               //Nombre de usuario
         
                 Score text1a = obj.getScore(Useful_methods.Text_formatter(usersc));
                 Score text1b = obj.getScore(Useful_methods.Text_formatter(usernamesc));
        
               //Número de jugadores conectados
         
                 Score text2a = obj.getScore(Useful_methods.Text_formatter(playersc));
                 Score text2b = obj.getScore(Useful_methods.Text_formatter(numberplayersc));
                 
               //Dinero del jugador
               
                 Score text3a = obj.getScore(Useful_methods.Text_formatter(moneysc));
                 Score text3b = obj.getScore(Useful_methods.Text_formatter(amountmoneysc));
                 
               //Dirección del servidor de TeamSpeak 3.
         
                 Score text4a = obj.getScore(Useful_methods.Text_formatter(teamspeaksc));
                 Score text4b = obj.getScore(Useful_methods.Text_formatter(teamspeakipsc));
        
        
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

