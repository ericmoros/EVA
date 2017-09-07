package com.eva.multismarts.ESpawn;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ESpawn;
import static com.eva.multismarts.Main.saveConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdESpawn implements CommandExecutor {
    private final Main plugin;
    public CmdESpawn(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("espawn")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                String world_name = player.getLocation().getWorld().getName();
                String generated_config;
                
                String espawn_dot                           = "ESpawn"     ;               // <- espawn_dot        |
                String     world_dot                        = world_name   ;               // <- world_dot         |
                String         afterdie_dot                 = "Afterdie"   ;               // <- afterdie_dot      |
                String             playlist_key             = "Playlist"   ;               // <- playlist_key      |
                String             bucle_key                = "Bucle"      ;               // <- bucle_key         |
                String             getout_key               = "Getout"     ;               // <- getout_key        |
                String         spawns_dot                   = "Spawns"     ;               // <- spawns_dot        |
                String             statics_dot              = "Statics"    ;               // <- statics_dot       |
                String                 static1_dot          = "Static1"    ; // <- Variabilizar
                String                     fixed_key        = "fixed"      ;               // <- fixed_key         |
                String                     x_key            = "x"          ;               // <- x_key             |
                String                     y_key            = "y"          ;               // <- y_key             |
                String                     z_key            = "z"          ;               // <- z_key             |
                String                     p_key            = "p"          ;               // <- p_key             |
                String                     a_key            = "a"          ;               // <- a_key             |
                String             randoms_dot              = "Randoms"    ;               // <- randoms_dot       |
                String                 random1_dot          = "random1"    ; // <- Variabilizar
             // String                     fixed_key        = "fixed"      ;               // <- fixed_key         |
                String                     Rx_maxandmin_key = "Rx_max&min" ;               // <- Rx_maxandmin_key  |
                String                     Ry_maxandmin_key = "Ry_max&min" ;               // <- Ry_maxandmin_key  |
                String                     Rz_maxandmin_key = "Rz_max&min" ;               // <- Rz_maxandmin_key  |
                String                     Rp_maxandmin_key = "Rp_max&min" ;               // <- Rp_maxandmin_key  |
                String                     Ra_maxandmin_key = "Ra_max&min" ;               // <- Ra_maxandmin_key  |
                
                String espawn_sec                   = (espawn_dot                 + ".") ; // <- espawn_sec        |
                String     world_sec                = (espawn_sec  + world_dot    + ".") ; // <- world_sec         |
                String          afterdie_sec        = (world_sec   + afterdie_dot + ".") ; // <- afterdie_sec      |
                String          spawns_sec          = (world_sec   + spawns_dot   + ".") ; // <- spawns_sec        |
                String              statics_sec     = (spawns_sec  + statics_dot  + ".") ; // <- statics_sec       |
                String                  static1_sec = (statics_sec + static1_dot  + ".") ; // <- static1_sec       |
                String              randoms_sec     = (spawns_sec  + randoms_dot  + ".") ; // <- randoms_sec       |
                String                  random1_sec = (randoms_sec + random1_dot  + ".") ; // <- random1_sec       |
                
                
                switch (args.length) {
                    case 0: 
                        ESpawn.createSection(world_sec + afterdie_dot);
                        ESpawn.createSection(spawns_sec + statics_dot);
                        ESpawn.createSection(spawns_sec + randoms_dot);
                        generated_config = "Generada configuración incompleta de " + world_name;
			break; 
                    case 1:
                        generated_config = "Por ahora no se puede generar esta configuración";
			break;
                    case 2:
                        generated_config = "Por ahora no se puede generar esta configuración";
			break;
                    default:
			generated_config = "[ERROR] No se admiten tantos argumentos";
		}
//                ESpawn.createSection(afterdie_sec + playlist_key);
//                ESpawn.createSection(afterdie_sec + bucle_key);
//                ESpawn.createSection(afterdie_sec + getout_key);
//                
//                ESpawn.createSection(static1_sec + fixed_key);
//                ESpawn.createSection(static1_sec + x_key);
//                ESpawn.createSection(static1_sec + y_key);
//                ESpawn.createSection(static1_sec + z_key);
//                ESpawn.createSection(static1_sec + p_key);
//                ESpawn.createSection(static1_sec + a_key);
//                
//                ESpawn.createSection(random1_sec + fixed_key);
//                ESpawn.createSection(random1_sec + Rx_maxandmin_key);
//                ESpawn.createSection(random1_sec + Ry_maxandmin_key);
//                ESpawn.createSection(random1_sec + Rz_maxandmin_key);
//                ESpawn.createSection(random1_sec + Rp_maxandmin_key);
//                ESpawn.createSection(random1_sec + Ra_maxandmin_key);
                
                
                saveConfig(ESpawn);
                
                player.sendMessage(generated_config);
                
            } else {
                sender.sendMessage("Desde la terminal has de especificar el mundo para el que quieres generar la configuración");
            }
        }
        return true;
    }
}
