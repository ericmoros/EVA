package com.eva.multismarts.ESpawn;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ESpawn;
import static com.eva.multismarts.Main.loadConfig;
import static com.eva.multismarts.Main.saveConfig;
import java.util.ArrayList;
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
    private static String             lock_key                 = "Lock"       ;    // <- lock_key          |
    private static String             playlist_key             = "Playlist"   ;    // <- playlist_key      |
    private static String             bucle_key                = "Bucle"      ;    // <- bucle_key         |
    private static String             getout_key               = "Getout"     ;    // <- getout_key        |
    private static String         spawns_dot                   = "Spawns"     ;    // <- spawns_dot        |
    private static String             normals_dot              = "Normals"    ;    // <- normals_dot       |
    private static String                 normal_dot           = "Normal"     ;    // <- normal_dot        |
    //ivate static String                     lock_key         = "Lock"       ;    // <- lock_key          |
    private static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     x_key            = "x"          ;    // <- x_key             |
    private static String                     y_key            = "y"          ;    // <- y_key             |
    private static String                     z_key            = "z"          ;    // <- z_key             |
    private static String                     p_key            = "p"          ;    // <- p_key             |
    private static String                     a_key            = "a"          ;    // <- a_key             |
    private static String             randoms_dot              = "Randoms"    ;    // <- randoms_dot       |
    private static String                 random_dot           = "random"     ;    // <- random_dot        |
    //ivate static String                     lock_key         = "Lock"       ;    // <- lock_key          |
    //ivate static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     Rx_maxandmin_key = "Rx_max&min" ;    // <- Rx_maxandmin_key  |
    private static String                     Ry_maxandmin_key = "Ry_max&min" ;    // <- Ry_maxandmin_key  |
    private static String                     Rz_maxandmin_key = "Rz_max&min" ;    // <- Rz_maxandmin_key  |
    private static String                     Rp_maxandmin_key = "Rp_max&min" ;    // <- Rp_maxandmin_key  |
    private static String                     Ra_maxandmin_key = "Ra_max&min" ;    // <- Ra_maxandmin_key  |
    
    private static String generated_config                     = "Generada"   ;
    
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
                keys.add(                    Rx_maxandmin_key                );
                keys.add(                    Ry_maxandmin_key                );
                keys.add(                    Rz_maxandmin_key                );
                keys.add(                    Rp_maxandmin_key                );
                keys.add(                    Ra_maxandmin_key                );
                
            return index.key(section, keys);
        }
    }
    
    private static class genSec {
        private static void generator(String lock, ArrayList<String> keys) {
            if (ESpawn.getBoolean(lock) == false){
                keys.forEach((sec) -> {
                    ESpawn.createSection((String) sec);
                });

                ESpawn.set(lock, true);

                saveConfig(ESpawn);
            }
        }
        
        private static void afterdie(String world_name){
            loadConfig(ESpawn);

                String lock = indexSec.afterdie(world_name) + lock_key                      ;
                ArrayList<String> keys = indexKeys.afterdie(world_name)                     ;

                    generator(lock, keys);
                    
                        generated_config = "\n Generado afterdie de " + world_name
                                         + "\n [AVISO] Genera spawns con la siguiente estructura:"
                                         + "\n  /espawn <normal/random> <spawn_name>"       ;
        }
        
        private static void spawn_normal(String world_name, String spawn_name){
            loadConfig(ESpawn);

                String lock = indexSec.spawn_normal(world_name, spawn_name) + lock_key      ;
                ArrayList<String> keys = indexKeys.spawn_normal(world_name, spawn_name)     ;

                    generator(lock, keys);
                        
                        generated_config = "\n Generado afterdie de " + world_name
                                         + "\n  y spawn normal con el nombre " + spawn_name ;
        }
        
        private static void spawn_random(String world_name, String spawn_name){
            loadConfig(ESpawn);

                String lock = indexSec.spawn_random(world_name, spawn_name) + lock_key      ;
                ArrayList<String> keys = indexKeys.spawn_random(world_name, spawn_name)     ;

                    generator(lock, keys);
                    
                        generated_config = "\n Generado afterdie de " + world_name
                                         + "\n  y spawn random con el nombre " + spawn_name ;
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("espawn")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                String world_name = player.getLocation().getWorld().getName();
                Integer n_args = args.length;
                String arg1;
                String arg2;
                
                
                switch (n_args) {
                    case 0:
                        genSec.afterdie(world_name);
			break;
                    case 1:
                        genSec.afterdie(world_name);
			break;
                    case 2:
                        genSec.afterdie(world_name);
                        
                        arg1 = args[0];
                        arg2 = args[1];
                        
                            if (arg1.equalsIgnoreCase("normal")){
                                genSec.spawn_normal(world_name, arg2);
                            } else if (arg1.equalsIgnoreCase("random")){
                                genSec.spawn_random(world_name, arg2);
                            } else {
                                generated_config = "\n Generado afterdie de " + world_name
                                                 + "\n [ERROR] El argumento " + arg1 + " no está contemplado"
                                                 + "\n  Debes usar: <normal/random>"    ;
                            }
			break;
                    default:
			generated_config = "\n[ERROR] No se admiten tantos argumentos"
                                         + "\n ¿Seguro que sabes lo que estás haciendo?";
		}
                
                player.sendMessage(generated_config);
            } else {
                sender.sendMessage("Desde la terminal has de especificar el mundo para el que quieres generar la configuración");
                sender.sendMessage("[En desarrollo] No tengas en cuenta el anterior mensaje");
            }
        }
        return true;
    }
}
