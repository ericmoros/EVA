package com.eva.multismarts.vscoreboard;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ConfigVscoreboard;
import static com.eva.multismarts.Main.ConfigVscoreboarddata;
import static com.eva.multismarts.Main.ConfigVscoreboardmultiworld;
import com.eva.multismarts.Useful_methods;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;



public class Board {
   
    private final Main plugin;
  
    public Board(Main instance) {
        this.plugin = instance;
    }
        static FileConfiguration cfg = ConfigVscoreboard;
        
        static FileConfiguration cfgdata = ConfigVscoreboarddata;
        
        static FileConfiguration cfgmultiworld = ConfigVscoreboardmultiworld;
 
        
       public static void setBoard(Player p) {
           
        //Objetos y variables para un uso cómodo del código
        Permission perm = Main.getPermissions();
        
      //  String rank = perm.getPrimaryGroup(p);
        
        int numberplayers = getServer().getOnlinePlayers().size();
            
        int maxplayers = getServer().getMaxPlayers();
          
        String nameserver = getServer().getServerName();
        
        String nameuser = p.getName();
        
        Economy econ = Main.getEconomy();
        
        String playermoney = Useful_methods.Decimal_formatter.format(econ.getBalance(p));
        
        String worldname = p.getWorld().getName();
        
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective obj = board.registerNewObjective("aaa", "bbb");
            
        //Valores traidos desde los diferentes archivos yml del módulo.
          //cfgdata
          
          int kills = ConfigVscoreboarddata.getInt(p.getName() + "." + "Kills");
          int deaths = ConfigVscoreboarddata.getInt(p.getName() + "." + "Deaths");
          double kd = ConfigVscoreboarddata.getDouble(p.getName() + "." + "Ratio");
          
          //multiworld
           
          boolean multiworldstatus = cfgmultiworld.getBoolean("Multiworld_status");
          String  multiworldname1 = cfgmultiworld.getString("Worlds.World1.Worldname");
          String  multiworldname2 = cfgmultiworld.getString("Worlds.World2.Worldname");
          String  multiworldname3 = cfgmultiworld.getString("Worlds.World3.Worldname");
          String  multiworldname4 = cfgmultiworld.getString("Worlds.World4.Worldname");
          String  multiworldname5 = cfgmultiworld.getString("Worlds.World5.Worldname");
          
          int worldstructure1 = cfgmultiworld.getInt("Worlds.World1.Structure"); 
          int worldstructure2 = cfgmultiworld.getInt("Worlds.World2.Structure"); 
          int worldstructure3 = cfgmultiworld.getInt("Worlds.World3.Structure"); 
          int worldstructure4 = cfgmultiworld.getInt("Worlds.World4.Structure"); 
          int worldstructure5 = cfgmultiworld.getInt("Worlds.World5.Structure"); 
          
            //World1
            
            String titlecfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer1cfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1acfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1bcfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer2cfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2acfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2bcfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer3cfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3acfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3bcfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer4cfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4acfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4bcfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer5cfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5acfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5bcfgw1 = cfgmultiworld.getString("Worlds.World1.Sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            //World2
            String titlecfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer1cfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1acfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1bcfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer2cfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2acfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2bcfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer3cfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3acfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3bcfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer4cfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4acfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4bcfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer5cfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5acfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5bcfgw2 = cfgmultiworld.getString("Worlds.World2.Sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            //World3
            String titlecfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer1cfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1acfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1bcfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer2cfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2acfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2bcfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer3cfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3acfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3bcfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer4cfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4acfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4bcfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer5cfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5acfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5bcfgw3 = cfgmultiworld.getString("Worlds.World3.Sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            //World4
            String titlecfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer1cfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1acfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1bcfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer2cfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2acfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2bcfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer3cfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3acfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3bcfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer4cfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4acfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4bcfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer5cfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5acfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5bcfgw4 = cfgmultiworld.getString("Worlds.World4.Sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            //World5
            String titlecfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer1cfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1acfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section1bcfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer2cfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2acfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section2bcfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer3cfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3acfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section3bcfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer4cfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4acfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section4bcfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String spacer5cfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5acfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
            String section5bcfgw5 = cfgmultiworld.getString("Worlds.World5.Sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));

          
          //cfg
          int scoreboardstructure = cfg.getInt("Scoreboard_structure.Structure");       
          String titlecfg = cfg.getString("Scoreboard_sections.Title").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String spacer1cfg = cfg.getString("Scoreboard_sections.Sectionspacer1").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section1acfg = cfg.getString("Scoreboard_sections.Section1a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));     
          String section1bcfg = cfg.getString("Scoreboard_sections.Section1b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String spacer2cfg = cfg.getString("Scoreboard_sections.Sectionspacer2").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section2acfg = cfg.getString("Scoreboard_sections.Section2a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section2bcfg = cfg.getString("Scoreboard_sections.Section2b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String spacer3cfg = cfg.getString("Scoreboard_sections.Sectionspacer3").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section3acfg = cfg.getString("Scoreboard_sections.Section3a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section3bcfg = cfg.getString("Scoreboard_sections.Section3b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String spacer4cfg = cfg.getString("Scoreboard_sections.Sectionspacer4").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section4acfg = cfg.getString("Scoreboard_sections.Section4a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section4bcfg = cfg.getString("Scoreboard_sections.Section4b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String spacer5cfg = cfg.getString("Scoreboard_sections.Sectionspacer5").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section5acfg = cfg.getString("Scoreboard_sections.Section5a").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
          String section5bcfg = cfg.getString("Scoreboard_sections.Section5b").replaceAll("<player>", p.getName()).replaceAll("<numberplayers>", Integer.toString(numberplayers)).replaceAll("<balance>", playermoney).replaceAll("<servername>", nameserver).replaceAll("<worldname>", worldname).replaceAll("<maxplayers>", Integer.toString(maxplayers)).replaceAll("<kills>", Integer.toString(kills)).replaceAll("<deaths>", Integer.toString(deaths)).replaceAll("<kdratio>", Useful_methods.Decimal_formatter.format(kd));
       
        //Tipo de Scoreboard y su título.
        //UNIWORLD
        if (multiworldstatus == false)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfg));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        //MULTIWORLD - MUNDO 1
        if (worldname.equalsIgnoreCase(multiworldname1) && multiworldstatus == true)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfgw1));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        //MULTIWORLD - MUNDO 2
        if (worldname.equalsIgnoreCase(multiworldname2) && multiworldstatus == true)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfgw2));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        //MULTIWORLD - MUNDO 3
        if (worldname.equalsIgnoreCase(multiworldname3) && multiworldstatus == true)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfgw3));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        //MULTIWORLD - MUNDO 4
        if (worldname.equalsIgnoreCase(multiworldname4) && multiworldstatus == true)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfgw4));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        //MULTIWORLD - MUNDO 5
        if (worldname.equalsIgnoreCase(multiworldname5) && multiworldstatus == true)
        {
        obj.setDisplayName(Useful_methods.Text_formatter(titlecfgw5));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        
        //Resultados del marcador
        
         //UNIWORLD
         
               //Barra limitadora del título
        
                Score bar = obj.getScore(Useful_methods.Text_formatter(spacer1cfg));
        
               //Espacios
        
                Score space1 = obj.getScore(Useful_methods.Text_formatter(spacer2cfg));
                Score space2 = obj.getScore(Useful_methods.Text_formatter(spacer3cfg));
                Score space3 = obj.getScore(Useful_methods.Text_formatter(spacer4cfg));
                Score space4 = obj.getScore(Useful_methods.Text_formatter(spacer5cfg));
                
               //Nombre de usuario
         
                 Score text1a = obj.getScore(Useful_methods.Text_formatter(section1acfg));
                 Score text1b = obj.getScore(Useful_methods.Text_formatter(section1bcfg));
        
               //Número de jugadores conectados
         
                 Score text2a = obj.getScore(Useful_methods.Text_formatter(section2acfg));
                 Score text2b = obj.getScore(Useful_methods.Text_formatter(section2bcfg));
                 
               //Dinero del jugador
               
                 Score text3a = obj.getScore(Useful_methods.Text_formatter(section3acfg));
                 Score text3b = obj.getScore(Useful_methods.Text_formatter(section3bcfg));
                 
               //Dirección del servidor de TeamSpeak 3.
         
                 Score text4a = obj.getScore(Useful_methods.Text_formatter(section4acfg));
                 Score text4b = obj.getScore(Useful_methods.Text_formatter(section4bcfg));
               //Text5
               
                 Score text5a = obj.getScore(Useful_methods.Text_formatter(section5acfg));
                 Score text5b = obj.getScore(Useful_methods.Text_formatter(section5bcfg));
                 
        //WORLD1
               Score barw1 = obj.getScore(Useful_methods.Text_formatter(spacer1cfgw1)); 
               
               Score space1w1 = obj.getScore(Useful_methods.Text_formatter(spacer2cfgw1));
               Score space2w1 = obj.getScore(Useful_methods.Text_formatter(spacer3cfgw1));
               Score space3w1 = obj.getScore(Useful_methods.Text_formatter(spacer4cfgw1));
               Score space4w1 = obj.getScore(Useful_methods.Text_formatter(spacer5cfgw1));
               
               Score text1aw1 = obj.getScore(Useful_methods.Text_formatter(section1acfgw1));
               Score text1bw1 = obj.getScore(Useful_methods.Text_formatter(section1bcfgw1));
               
               Score text2aw1 = obj.getScore(Useful_methods.Text_formatter(section2acfgw1));
               Score text2bw1 = obj.getScore(Useful_methods.Text_formatter(section2bcfgw1));
               
               Score text3aw1 = obj.getScore(Useful_methods.Text_formatter(section3acfgw1));
               Score text3bw1 = obj.getScore(Useful_methods.Text_formatter(section3bcfgw1));
               
               Score text4aw1 = obj.getScore(Useful_methods.Text_formatter(section4acfgw1));
               Score text4bw1 = obj.getScore(Useful_methods.Text_formatter(section4bcfgw1));
               
               Score text5aw1 = obj.getScore(Useful_methods.Text_formatter(section5acfgw1));
               Score text5bw1 = obj.getScore(Useful_methods.Text_formatter(section5bcfgw1));
               
        //WORLD2
               Score barw2 = obj.getScore(Useful_methods.Text_formatter(spacer1cfgw2)); 
               
               Score space1w2 = obj.getScore(Useful_methods.Text_formatter(spacer2cfgw2));
               Score space2w2 = obj.getScore(Useful_methods.Text_formatter(spacer3cfgw2));
               Score space3w2 = obj.getScore(Useful_methods.Text_formatter(spacer4cfgw2));
               Score space4w2 = obj.getScore(Useful_methods.Text_formatter(spacer5cfgw2));
               
               Score text1aw2 = obj.getScore(Useful_methods.Text_formatter(section1acfgw2));
               Score text1bw2 = obj.getScore(Useful_methods.Text_formatter(section1bcfgw2));
               
               Score text2aw2 = obj.getScore(Useful_methods.Text_formatter(section2acfgw2));
               Score text2bw2 = obj.getScore(Useful_methods.Text_formatter(section2bcfgw2));
               
               Score text3aw2 = obj.getScore(Useful_methods.Text_formatter(section3acfgw2));
               Score text3bw2 = obj.getScore(Useful_methods.Text_formatter(section3bcfgw2));
               
               Score text4aw2 = obj.getScore(Useful_methods.Text_formatter(section4acfgw2));
               Score text4bw2 = obj.getScore(Useful_methods.Text_formatter(section4bcfgw2));
               
               Score text5aw2= obj.getScore(Useful_methods.Text_formatter(section5acfgw2));
               Score text5bw2 = obj.getScore(Useful_methods.Text_formatter(section5bcfgw2));
        //WORLD3
               Score barw3 = obj.getScore(Useful_methods.Text_formatter(spacer1cfgw3)); 
               
               Score space1w3 = obj.getScore(Useful_methods.Text_formatter(spacer2cfgw3));
               Score space2w3 = obj.getScore(Useful_methods.Text_formatter(spacer3cfgw3));
               Score space3w3 = obj.getScore(Useful_methods.Text_formatter(spacer4cfgw3));
               Score space4w3 = obj.getScore(Useful_methods.Text_formatter(spacer5cfgw3));
               
               Score text1aw3 = obj.getScore(Useful_methods.Text_formatter(section1acfgw3));
               Score text1bw3 = obj.getScore(Useful_methods.Text_formatter(section1bcfgw3));
               
               Score text2aw3 = obj.getScore(Useful_methods.Text_formatter(section2acfgw3));
               Score text2bw3 = obj.getScore(Useful_methods.Text_formatter(section2bcfgw3));
               
               Score text3aw3 = obj.getScore(Useful_methods.Text_formatter(section3acfgw3));
               Score text3bw3 = obj.getScore(Useful_methods.Text_formatter(section3bcfgw3));
               
               Score text4aw3 = obj.getScore(Useful_methods.Text_formatter(section4acfgw3));
               Score text4bw3 = obj.getScore(Useful_methods.Text_formatter(section4bcfgw3));
               
               Score text5aw3 = obj.getScore(Useful_methods.Text_formatter(section5acfgw3));
               Score text5bw3 = obj.getScore(Useful_methods.Text_formatter(section5bcfgw3));
        //WORLD4
               Score barw4 = obj.getScore(Useful_methods.Text_formatter(spacer1cfgw4)); 
               
               Score space1w4 = obj.getScore(Useful_methods.Text_formatter(spacer2cfgw4));
               Score space2w4 = obj.getScore(Useful_methods.Text_formatter(spacer3cfgw4));
               Score space3w4 = obj.getScore(Useful_methods.Text_formatter(spacer4cfgw4));
               Score space4w4 = obj.getScore(Useful_methods.Text_formatter(spacer5cfgw4));
               
               Score text1aw4 = obj.getScore(Useful_methods.Text_formatter(section1acfgw4));
               Score text1bw4 = obj.getScore(Useful_methods.Text_formatter(section1bcfgw4));
               
               Score text2aw4 = obj.getScore(Useful_methods.Text_formatter(section2acfgw4));
               Score text2bw4 = obj.getScore(Useful_methods.Text_formatter(section2bcfgw4));
               
               Score text3aw4 = obj.getScore(Useful_methods.Text_formatter(section3acfgw4));
               Score text3bw4 = obj.getScore(Useful_methods.Text_formatter(section3bcfgw4));
               
               Score text4aw4 = obj.getScore(Useful_methods.Text_formatter(section4acfgw4));
               Score text4bw4 = obj.getScore(Useful_methods.Text_formatter(section4bcfgw4));
               
               Score text5aw4 = obj.getScore(Useful_methods.Text_formatter(section5acfgw4));
               Score text5bw4 = obj.getScore(Useful_methods.Text_formatter(section5bcfgw4));
        //WORLD5
               Score barw5 = obj.getScore(Useful_methods.Text_formatter(spacer1cfgw5)); 
               
               Score space1w5 = obj.getScore(Useful_methods.Text_formatter(spacer2cfgw5));
               Score space2w5 = obj.getScore(Useful_methods.Text_formatter(spacer3cfgw5));
               Score space3w5 = obj.getScore(Useful_methods.Text_formatter(spacer4cfgw5));
               Score space4w5 = obj.getScore(Useful_methods.Text_formatter(spacer5cfgw5));
               
               Score text1aw5 = obj.getScore(Useful_methods.Text_formatter(section1acfgw5));
               Score text1bw5 = obj.getScore(Useful_methods.Text_formatter(section1bcfgw5));
               
               Score text2aw5 = obj.getScore(Useful_methods.Text_formatter(section2acfgw5));
               Score text2bw5 = obj.getScore(Useful_methods.Text_formatter(section2bcfgw5));
               
               Score text3aw5 = obj.getScore(Useful_methods.Text_formatter(section3acfgw5));
               Score text3bw5 = obj.getScore(Useful_methods.Text_formatter(section3bcfgw5));
               
               Score text4aw5 = obj.getScore(Useful_methods.Text_formatter(section4acfgw5));
               Score text4bw5 = obj.getScore(Useful_methods.Text_formatter(section4bcfgw5));
               
               Score text5aw5 = obj.getScore(Useful_methods.Text_formatter(section5acfgw5));
               Score text5bw5 = obj.getScore(Useful_methods.Text_formatter(section5bcfgw5));
        //Orden de los marcadores
        
        //Uniworld
        
        if (scoreboardstructure == 1 && multiworldstatus == false)
        {
                bar.setScore(15);
                
                text1a.setScore(14);
                
                text1b.setScore(13);
              
                space1.setScore(12);
                
                text2a.setScore(11);
                
                text2b.setScore(10);
                
                space2.setScore(9);
                
                text3a.setScore(8);
                
                text3b.setScore(7);
                
                space3.setScore(6);
                
                text4a.setScore(5);
                
                text4b.setScore(4);
                
                space4.setScore(3);
                
                text5a.setScore(2);
                
                text5b.setScore(1);     
                
                p.setScoreboard(board); 
         }
        
        if (scoreboardstructure == 4 && multiworldstatus == false)
            
        {
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
            
            p.setScoreboard(board); 
        }
        
        if ((scoreboardstructure == 3 || scoreboardstructure <= 0 || scoreboardstructure >= 6) && multiworldstatus == false)
            
        {
            bar.setScore(9);
                
            text1a.setScore(8);
                
            text1b.setScore(7);
              
            space1.setScore(6);
                
            text2a.setScore(5);
                
            text2b.setScore(4);
                
            space2.setScore(3);
                
            text3a.setScore(2);
                
            text3b.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (scoreboardstructure == 2 && multiworldstatus == false)
            
        {
            bar.setScore(6);
                
            text1a.setScore(5);
                
            text1b.setScore(4);
              
            space1.setScore(3);
                
            text2a.setScore(2);
                
            text2b.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (scoreboardstructure == 1 && multiworldstatus == false)
            
        {      
            text1a.setScore(2);
                
            text1b.setScore(1);
            
            p.setScoreboard(board); 
        }
        
       
       //Multiworld
       
          //MUNDO1
       if (worldname.equalsIgnoreCase(multiworldname1) && multiworldstatus == true)
       {
           if (worldstructure1 == 5)
        {
                barw1.setScore(15);
                
                text1aw1.setScore(14);
                
                text1bw1.setScore(13);
              
                space1w1.setScore(12);
                
                text2aw1.setScore(11);
                
                text2bw1.setScore(10);
                
                space2w1.setScore(9);
                
                text3aw1.setScore(8);
                
                text3bw1.setScore(7);
                
                space3w1.setScore(6);
                
                text4aw1.setScore(5);
                
                text4bw1.setScore(4);
                
                space4w1.setScore(3);
                
                text5aw1.setScore(2);
                
                text5bw1.setScore(1);     
                
                p.setScoreboard(board); 
         }
        
        if (worldstructure1 == 4)
            
        {
            barw1.setScore(12);
                
            text1aw1.setScore(11);
                
            text1bw1.setScore(10);
              
            space1w1.setScore(9);
                
            text2aw1.setScore(8);
                
            text2bw1.setScore(7);
                
            space2w1.setScore(6);
                
            text3aw1.setScore(5);
                
            text3bw1.setScore(4);
                
            space3w1.setScore(3);
                
            text4aw1.setScore(2);
                
            text4bw1.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure1 == 3 || worldstructure1 <= 0 || worldstructure1 >= 6)
            
        {
            barw1.setScore(9);
                
            text1aw1.setScore(8);
                
            text1bw1.setScore(7);
              
            space1w1.setScore(6);
                
            text2aw1.setScore(5);
                
            text2bw1.setScore(4);
                
            space2w1.setScore(3);
                
            text3aw1.setScore(2);
                
            text3bw1.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure1 == 2)
            
        {
            barw1.setScore(6);
                
            text1aw1.setScore(5);
                
            text1bw1.setScore(4);
              
            space1w1.setScore(3);
                
            text2aw1.setScore(2);
                
            text2bw1.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure1 == 1)
            
        {      
            text1aw1.setScore(2);
                
            text1bw1.setScore(1);
            
            p.setScoreboard(board); 
        }
        
       }
       //MUNDO2
       if (worldname.equalsIgnoreCase(multiworldname2) && multiworldstatus == true)
       {
        if (worldstructure2 == 5)
        {
                barw2.setScore(15);
                
                text1aw2.setScore(14);
                
                text1bw2.setScore(13);
              
                space1w2.setScore(12);
                
                text2aw2.setScore(11);
                
                text2bw2.setScore(10);
                
                space2w2.setScore(9);
                
                text3aw2.setScore(8);
                
                text3bw2.setScore(7);
                
                space3w2.setScore(6);
                
                text4aw2.setScore(5);
                
                text4bw2.setScore(4);
                
                space4w2.setScore(3);
                
                text5aw2.setScore(2);
                
                text5bw2.setScore(1);     
                
                p.setScoreboard(board); 
         }
        
        if (worldstructure2 == 4)
            
        {
            barw2.setScore(12);
                
            text1aw2.setScore(11);
                
            text1bw2.setScore(10);
              
            space1w2.setScore(9);
                
            text2aw2.setScore(8);
                
            text2bw2.setScore(7);
                
            space2w2.setScore(6);
                
            text3aw2.setScore(5);
                
            text3bw2.setScore(4);
                
            space3w2.setScore(3);
                
            text4aw2.setScore(2);
                
            text4bw2.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure2 == 3 || worldstructure2 <= 0 || worldstructure2 >= 6)
            
        {
            barw2.setScore(9);
                
            text1aw2.setScore(8);
                
            text1bw2.setScore(7);
              
            space1w2.setScore(6);
                
            text2aw2.setScore(5);
                
            text2bw2.setScore(4);
                
            space2w2.setScore(3);
                
            text3aw2.setScore(2);
                
            text3bw2.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure2 == 2)
            
        {
            barw2.setScore(6);
                
            text1aw2.setScore(5);
                
            text1bw2.setScore(4);
              
            space1w2.setScore(3);
                
            text2aw2.setScore(2);
                
            text2bw2.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure2 == 1)
            
        {      
            text1aw2.setScore(2);
                
            text1bw2.setScore(1);
            
            p.setScoreboard(board); 
        }
       }
       //MUNDO3
       if (worldname.equalsIgnoreCase(multiworldname3) && multiworldstatus == true)
       {
        if (worldstructure3 == 5)
        {
                barw3.setScore(15);
                
                text1aw3.setScore(14);
                
                text1bw3.setScore(13);
              
                space1w3.setScore(12);
                
                text2aw3.setScore(11);
                
                text2bw3.setScore(10);
                
                space2w3.setScore(9);
                
                text3aw3.setScore(8);
                
                text3bw3.setScore(7);
                
                space3w3.setScore(6);
                
                text4aw3.setScore(5);
                
                text4bw3.setScore(4);
                
                space4w3.setScore(3);
                
                text5aw3.setScore(2);
                
                text5bw3.setScore(1);     
                
                p.setScoreboard(board); 
         }
        
        if (worldstructure3 == 4)
            
        {
            barw3.setScore(12);
                
            text1aw3.setScore(11);
                
            text1bw3.setScore(10);
              
            space1w3.setScore(9);
                
            text2aw3.setScore(8);
                
            text2bw3.setScore(7);
                
            space2w3.setScore(6);
                
            text3aw3.setScore(5);
                
            text3bw3.setScore(4);
                
            space3w3.setScore(3);
                
            text4aw3.setScore(2);
                
            text4bw3.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure3 == 3 || worldstructure3 <= 0 || worldstructure3 >= 6)
            
        {
            barw3.setScore(9);
                
            text1aw3.setScore(8);
                
            text1bw3.setScore(7);
              
            space1w3.setScore(6);
                
            text2aw3.setScore(5);
                
            text2bw3.setScore(4);
                
            space2w3.setScore(3);
                
            text3aw3.setScore(2);
                
            text3bw3.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure3 == 2)
            
        {
            barw3.setScore(6);
                
            text1aw3.setScore(5);
                
            text1bw3.setScore(4);
              
            space1w3.setScore(3);
                
            text2aw3.setScore(2);
                
            text2bw3.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure3 == 1)
            
        {      
            text1aw3.setScore(2);
                
            text1bw3.setScore(1);
            
            p.setScoreboard(board); 
        }
       }
       //MUNDO4
       if (worldname.equalsIgnoreCase(multiworldname4) && multiworldstatus == true)
       {
         if (worldstructure4 == 5)
          {
                barw4.setScore(15);
                
                text1aw4.setScore(14);
                
                text1bw4.setScore(13);
              
                space1w4.setScore(12);
                
                text2aw4.setScore(11);
                
                text2bw4.setScore(10);
                
                space2w4.setScore(9);
                
                text3aw4.setScore(8);
                
                text3bw4.setScore(7);
                
                space3w4.setScore(6);
                
                text4aw4.setScore(5);
                
                text4bw4.setScore(4);
                
                space4w4.setScore(3);
                
                text5aw4.setScore(2);
                
                text5bw4.setScore(1);     
                
                p.setScoreboard(board); 
           }
        
        if (worldstructure4 == 4)
            
        {
            barw4.setScore(12);
                
            text1aw4.setScore(11);
                
            text1bw4.setScore(10);
              
            space1w4.setScore(9);
                
            text2aw4.setScore(8);
                
            text2bw4.setScore(7);
                
            space2w4.setScore(6);
                
            text3aw4.setScore(5);
                
            text3bw4.setScore(4);
                
            space3w4.setScore(3);
                
            text4aw4.setScore(2);
                
            text4bw4.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure4 == 3 || worldstructure4 <= 0 || worldstructure4 >= 6)
            
        {
            barw4.setScore(9);
                
            text1aw4.setScore(8);
                
            text1bw4.setScore(7);
              
            space1w4.setScore(6);
                
            text2aw4.setScore(5);
                
            text2bw4.setScore(4);
                
            space2w4.setScore(3);
                
            text3aw4.setScore(2);
                
            text3bw4.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure4 == 2)
            
        {
            barw4.setScore(6);
                
            text1aw4.setScore(5);
                
            text1bw4.setScore(4);
              
            space1w4.setScore(3);
                
            text2aw4.setScore(2);
                
            text2bw4.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure4 == 1)
            
        {      
            text1aw4.setScore(2);
                
            text1bw4.setScore(1);
            
            p.setScoreboard(board); 
        } 
       }
       //Mundo5
       if (worldname.equalsIgnoreCase(multiworldname5) && multiworldstatus == true)
        {
          if (worldstructure5 == 5)
          {
                barw5.setScore(15);
                
                text1aw5.setScore(14);
                
                text1bw5.setScore(13);
              
                space1w5.setScore(12);
                
                text2aw5.setScore(11);
                
                text2bw5.setScore(10);
                
                space2w5.setScore(9);
                
                text3aw5.setScore(8);
                
                text3bw5.setScore(7);
                
                space3w5.setScore(6);
                
                text4aw5.setScore(5);
                
                text4bw5.setScore(4);
                
                space4w5.setScore(3);
                
                text5aw5.setScore(2);
                
                text5bw5.setScore(1);     
                
                p.setScoreboard(board); 
         }
        
        if (worldstructure5 == 4)
            
        {
            barw5.setScore(12);
                
            text1aw5.setScore(11);
                
            text1bw5.setScore(10);
              
            space1w5.setScore(9);
                
            text2aw5.setScore(8);
                
            text2bw5.setScore(7);
                
            space2w5.setScore(6);
                
            text3aw5.setScore(5);
                
            text3bw5.setScore(4);
                
            space3w5.setScore(3);
                
            text4aw5.setScore(2);
                
            text4bw5.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure5 == 3 || worldstructure5 <= 0 || worldstructure5 >= 6)
            
        {
            barw5.setScore(9);
                
            text1aw5.setScore(8);
                
            text1bw5.setScore(7);
              
            space1w5.setScore(6);
                
            text2aw5.setScore(5);
                
            text2bw5.setScore(4);
                
            space2w5.setScore(3);
                
            text3aw5.setScore(2);
                
            text3bw5.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure5 == 2)
            
        {
            barw5.setScore(6);
                
            text1aw5.setScore(5);
                
            text1bw5.setScore(4);
              
            space1w5.setScore(3);
                
            text2aw5.setScore(2);
                
            text2bw5.setScore(1);
            
            p.setScoreboard(board); 
        }
        
        if (worldstructure5 == 1)
            
        {      
            text1aw5.setScore(2);
                
            text1bw5.setScore(1);
            
            p.setScoreboard(board); 
        }
       }
              
     }       
}

