package com.eva.multismarts.ESpawn;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ESpawn;
import static com.eva.multismarts.Main.loadConfig;
import static com.eva.multismarts.Main.saveConfig;
import java.util.ArrayList;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdESpawn implements CommandExecutor {
    private final Main plugin;
    public CmdESpawn(Main instance) {
        plugin = instance;
    }
    
    @SuppressWarnings("FieldMayBeFinal")
    private static String espawn_dot                           = "ESpawn"     ;    // <- espawn_dot        |
    private static String     world_dot                        = "world_name" ;    // <- world_dot         |
    private static String         afterdie_dot                 = "Afterdie"   ;    // <- afterdie_dot      |
    private static String             lock_key                 = "lock"       ;    // <- lock_key          |
    private static String             playlist_key             = "Playlist"   ;    // <- playlist_key      |
    private static String             bucle_key                = "Bucle"      ;    // <- bucle_key         |
    private static String             getout_key               = "Getout"     ;    // <- getout_key        |
    private static String         spawns_dot                   = "Spawns"     ;    // <- spawns_dot        |
    private static String             normals_dot              = "Normals"    ;    // <- normals_dot       |
    private static String                 normal_dot           = "Normal"     ;    // <- normal_dot        |
    //ivate static String                     lock_key         = "lock"       ;    // <- lock_key          |
    private static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     x_key            = "x"          ;    // <- x_key             |
    private static String                     y_key            = "y"          ;    // <- y_key             |
    private static String                     z_key            = "z"          ;    // <- z_key             |
    private static String                     p_key            = "p"          ;    // <- p_key             |
    private static String                     a_key            = "a"          ;    // <- a_key             |
    private static String             randoms_dot              = "Randoms"    ;    // <- randoms_dot       |
    private static String                 random_dot           = "Random"     ;    // <- random_dot        |
    //ivate static String                     lock_key         = "lock"       ;    // <- lock_key          |
    //ivate static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     rx_dot           = "rx"         ;    // <- rx_dot            |
    private static String                         max_key      = "max"        ;    // <- max_key           |
    private static String                         min_key      = "min"        ;    // <- min_key           |
    private static String                     ry_dot           = "ry"         ;    // <- ry_dot            |
    //ivate static String                         max_key      = "max_key"    ;    // <- max_key           |
    //ivate static String                         min_key      = "min_key"    ;    // <- min_key           |
    private static String                     rz_dot           = "rz"         ;    // <- rz_dot            |
    //ivate static String                         max_key      = "max_key"    ;    // <- max_key           |
    //ivate static String                         min_key      = "min_key"    ;    // <- min_key           |
    private static String                     rp_dot           = "rp"         ;    // <- rp_dot            |
    //ivate static String                         max_key      = "max_key"    ;    // <- max_key           |
    //ivate static String                         min_key      = "min_key"    ;    // <- min_key           |
    private static String                     ra_dot           = "ra"         ;    // <- ra_dot            |
    //ivate static String                         max_key      = "max_key"    ;    // <- max_key           |
    //ivate static String                         min_key      = "min_key"    ;    // <- min_key           |
    private static String                     l_location_dot   = "l_location" ;    // <- l_location_dot    |
    //ivate static String                         x_key        = "x"          ;    // <- x_key             |
    //ivate static String                         y_key        = "y"          ;    // <- y_key             |
    //ivate static String                         z_key        = "z"          ;    // <- z_key             |
    //ivate static String                         p_key        = "p"          ;    // <- p_key             |
    //ivate static String                         a_key        = "a"          ;    // <- a_key             |
    
    private static String generated_config      = "\n           ___________________________"
                                                + "\n             /¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\\"
                                                + "\n                           ESpawn"
                                                + "\n             \\_______________________/"
                                                + "\n             ¯¯¯¯|¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
                                                + "\n ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\\"
                                                + "\n  Config: Proporciona una configuración por defecto"
                                                + "\n           en tu mundo actual."
                                                + "\n  List:   Muestra la lista de spawns."
                                                + "\n           guración."
                                                + "\n  Normal: Almacena tu ubicación actual en la confi-"
                                                + "\n           guración."
                                                + "\n" ;
    
    
    private static class index {
        private static String section(ArrayList<String> dots){
            String section = "";
            
            for (String dot: dots) {
                section = section + (dot + ".");
            }
                
           return  section;
        }
        
        private static ArrayList<String> key(String section, ArrayList<String> keys){
            ArrayList<String> sectionkey = new ArrayList<>();

            keys.forEach((key) -> {
                sectionkey.add(section + key  );
            });
            
            return sectionkey;
        }
    }
    
    private static class indexSec {
        private static String afterdie(String world_name){
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        afterdie_dot                                );
                
            return index.section(dots);
        }
        
        private static String spawn_normal_list(String world_name){
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        spawns_dot                                  );
                dots.add(            normals_dot                             );
                
            return index.section(dots);
        }
        
        private static String spawn_normal(String world_name, String spawn_name){
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        spawns_dot                                  );
                dots.add(            normals_dot                             );
                dots.add(                normal_dot            = spawn_name  );
                
            return index.section(dots);
        }
        
        private static String spawn_random(String world_name, String spawn_name){
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        spawns_dot                                  );
                dots.add(            randoms_dot                             );
                dots.add(                random_dot            = spawn_name  );
                
            return index.section(dots);
        }
    }
    
    private static class indexKeys {
        private static ArrayList<String> afterdie(String world_name){
            String section = indexSec.afterdie(world_name);
            
            ArrayList<String> keys = new ArrayList<>();
                keys.add(            lock_key                                );
                keys.add(            playlist_key                            );
                keys.add(            bucle_key                               );
                keys.add(            getout_key                              );
                
            return index.key(section, keys);
        }
        
        private static ArrayList<String> spawn_normal(String world_name, String spawn_name){
            String section = indexSec.spawn_normal(world_name, spawn_name);
            
            ArrayList<String> keys = new ArrayList<>();
                keys.add(                    lock_key                        );
                keys.add(                    fixed_key                       );
                keys.add(                    x_key                           );
                keys.add(                    y_key                           );
                keys.add(                    z_key                           );
                keys.add(                    p_key                           );
                keys.add(                    a_key                           );
                
            return index.key(section, keys);
        }
        
        private static ArrayList<String> spawn_random(String world_name, String spawn_name){
            String section = indexSec.spawn_random(world_name, spawn_name);
            
            ArrayList<String> keys = new ArrayList<>();
                keys.add(                    lock_key                        );
                keys.add(                    fixed_key                       );
                keys.add(                    rx_dot + "." + max_key          );    // <- rx_dot            |
                keys.add(                    rx_dot + "." + min_key          );
                keys.add(                    ry_dot + "." + max_key          );    // <- ry_dot            |
                keys.add(                    ry_dot + "." + min_key          );
                keys.add(                    rz_dot + "." + max_key          );    // <- rz_dot            |
                keys.add(                    rz_dot + "." + min_key          );
                keys.add(                    rp_dot + "." + max_key          );    // <- rp_dot            |
                keys.add(                    rp_dot + "." + min_key          );
                keys.add(                    ra_dot + "." + max_key          );    // <- ra_dot            |
                keys.add(                    ra_dot + "." + min_key          );
                keys.add(                    l_location_dot + "." + x_key    );    // <- l_location_dot    |
                keys.add(                    l_location_dot + "." + y_key    );
                keys.add(                    l_location_dot + "." + z_key    );
                keys.add(                    l_location_dot + "." + p_key    );
                keys.add(                    l_location_dot + "." + a_key    );
                
                
            return index.key(section, keys);
        }
    }
    
    private static class genSec {
        private static void generator(ArrayList<String> keys) {
            keys.forEach((sec) -> {
                ESpawn.createSection((String) sec);
            });

            saveConfig(ESpawn);
        }
        
        private static void afterdie(String world_name){
            loadConfig(ESpawn);

                String lock = indexSec.afterdie(world_name) + lock_key  ;
                ArrayList<String> keys = indexKeys.afterdie(world_name) ;
                
                if (ESpawn.getBoolean(lock) == false){
                    generator(keys);
                    
                        generated_config = "\n Generado afterdie de " + world_name
                                         + "\n [AVISO] Genera spawns con la siguiente estructura:"
                                         + "\n  /espawn <normal/random> <spawn_name>";
                        
                        ESpawn.set(lock, true);
                            
                        saveConfig(ESpawn);
                }
        }
        
        private static void spawn_normal(Player player, String world_name, String spawn_name){
            loadConfig(ESpawn);

                String lock = indexSec.spawn_normal(world_name, spawn_name) + lock_key  ;
                ArrayList<String> keys = indexKeys.spawn_normal(world_name, spawn_name) ;

                if (ESpawn.getBoolean(lock) == false){
                    generator(keys);
                        
                    String section = indexSec.spawn_normal(world_name, spawn_name); 
                    
                        ESpawn.set(section + x_key, player.getLocation().getX())     ;
                        ESpawn.set(section + y_key, player.getLocation().getY())     ;
                        ESpawn.set(section + z_key, player.getLocation().getZ())     ;
                        ESpawn.set(section + p_key, player.getLocation().getPitch()) ;
                        ESpawn.set(section + a_key, player.getLocation().getYaw())   ;
                        
                            generated_config = "\n Generado afterdie de " + world_name
                                         + "\n  y spawn normal con el nombre " + spawn_name;
                            
                            ESpawn.set(lock, true);
                            
                            saveConfig(ESpawn);
                }
        }
        
        private static void spawn_random(String world_name, String spawn_name){
            loadConfig(ESpawn);

                String lock = indexSec.spawn_random(world_name, spawn_name) + lock_key  ;
                ArrayList<String> keys = indexKeys.spawn_random(world_name, spawn_name) ;
                
                if (ESpawn.getBoolean(lock) == false){
                    generator(keys);
                    
                    String section = indexSec.spawn_random(world_name, spawn_name); 
                    
                        ESpawn.set(section + l_location_dot + "." + x_key, Math.random() * 1000);
                        ESpawn.set(section + l_location_dot + "." + y_key, Math.random() * 1000);
                        ESpawn.set(section + l_location_dot + "." + z_key, Math.random() * 1000);
                        ESpawn.set(section + l_location_dot + "." + p_key, Math.random() * 1000);
                        ESpawn.set(section + l_location_dot + "." + a_key, Math.random() * 1000);
                    
                    
                        generated_config = "\n Generado afterdie de " + world_name
                                         + "\n  y spawn random con el nombre " + spawn_name ;
                        
                        ESpawn.set(lock, false);
                        
                        saveConfig(ESpawn);
                }
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("espawn")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                World world = player.getLocation().getWorld();
                String world_name = world.getName();
//                String arg1;
//                String arg2;
                String original_generated_config = generated_config;
                
                for (String arg : args) {
                    if (arg.equalsIgnoreCase("Config")) {
                        genSec.afterdie(world_name);
                        generated_config = "\n Configuración de " + world_name + " generada!\n" ;
                    } else if (arg.equalsIgnoreCase("Normal")) {
                        if (args.length == 2) {
                            String spawnName = args[1];
                            genSec.spawn_normal(player, world_name, spawnName);
                        } else {
                            generated_config = "\n [ERROR] El formato del comando es incorrecto"
                                             + "\n  (Info) Para usar \"Normal\" correctamente:"
                                             + "\n      /Espawn Normal <Spawn_name>"  ;
                        }
                    } else if (arg.equalsIgnoreCase("List")) {
                        String section = indexSec.spawn_normal_list(world_name);
                        generated_config = "";
                        ESpawn.getConfigurationSection(section).getKeys(false).forEach((spawn) -> {
                            generated_config += " - " + spawn + "\n";
                        });
                    }
                }
//                switch (n_args) {
//                    case 0:
//                        genSec.afterdie(world_name);
//			break;
//                    case 1:
//                        arg1 = args[0];
//                        String section = indexSec.spawn_normal(world_name, arg1);
//                            double x = ESpawn.getDouble(section + x_key)         ;
//                            double y = ESpawn.getDouble(section + y_key)         ;
//                            double z = ESpawn.getDouble(section + z_key)         ;
//                            float  p = (float) ESpawn.getDouble(section + p_key) ;
//                            float  a = (float) ESpawn.getDouble(section + a_key) ;
//                            
//                            
//                                Location spawn = new Location(world, x, y, z);
//                                
//                                    spawn.setPitch(p);
//                                    spawn.setYaw(a)  ;
//                                    
//                                        player.teleport(spawn);
//                                    
//                        //genSec.afterdie(world_name);
//			break;
//                    case 2:
//                        genSec.afterdie(world_name);
//                        
//                        arg1 = args[0];
//                        arg2 = args[1];
//                        
//                            if (arg1.equalsIgnoreCase("normal")){
//                                genSec.spawn_normal(player, world_name, arg2);
//                            } else if (arg1.equalsIgnoreCase("random")){
//                                genSec.spawn_random(world_name, arg2);
//                            } else {
//                                generated_config = "\n Generado afterdie de " + world_name
//                                                 + "\n [ERROR] El argumento " + arg1 + " no está contemplado"
//                                                 + "\n  Debes usar: <normal/random>"    ;
//                            }
//			break;
//                    default:
//			generated_config = "\n[ERROR] No se admiten tantos argumentos"
//                                         + "\n ¿Seguro que sabes lo que estás haciendo?";
//		}
                
                player.sendMessage(generated_config);
                generated_config = original_generated_config;
                
            } else {
                sender.sendMessage("Desde la terminal has de especificar el mundo para el que quieres generar la configuración");
                sender.sendMessage("[En desarrollo] No tengas en cuenta el anterior mensaje");
            }
        }
        return true;
    }
}
