package com.eva.multismarts.ESpawn;

import com.eva.multismarts.Main;
import static com.eva.multismarts.Main.ESpawn;
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
    
    private static String espawn_dot                           = "ESpawn"     ;    // <- espawn_dot        |
    private static String     world_dot                        = "world_name" ;    // <- world_dot         |
    private static String         afterdie_dot                 = "Afterdie"   ;    // <- afterdie_dot      |
    private static String             playlist_key             = "Playlist"   ;    // <- playlist_key      |
    private static String             bucle_key                = "Bucle"      ;    // <- bucle_key         |
    private static String             getout_key               = "Getout"     ;    // <- getout_key        |
    private static String         spawns_dot                   = "Spawns"     ;    // <- spawns_dot        |
    private static String             normals_dot              = "Normals"    ;    // <- normals_dot       |
    private static String                 normal_dot           = "Normal"     ;    // <- normal_dot        |
    private static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     x_key            = "x"          ;    // <- x_key             |
    private static String                     y_key            = "y"          ;    // <- y_key             |
    private static String                     z_key            = "z"          ;    // <- z_key             |
    private static String                     p_key            = "p"          ;    // <- p_key             |
    private static String                     a_key            = "a"          ;    // <- a_key             |
    private static String             randoms_dot              = "Randoms"    ;    // <- randoms_dot       |
    private static String                 random_dot           = "random"     ;    // <- random_dot        |
    //ivate static String                     fixed_key        = "fixed"      ;    // <- fixed_key         |
    private static String                     Rx_maxandmin_key = "Rx_max&min" ;    // <- Rx_maxandmin_key  |
    private static String                     Ry_maxandmin_key = "Ry_max&min" ;    // <- Ry_maxandmin_key  |
    private static String                     Rz_maxandmin_key = "Rz_max&min" ;    // <- Rz_maxandmin_key  |
    private static String                     Rp_maxandmin_key = "Rp_max&min" ;    // <- Rp_maxandmin_key  |
    private static String                     Ra_maxandmin_key = "Ra_max&min" ;    // <- Ra_maxandmin_key  |
    
    private static String generated_config                     = "Generada"   ;
    
    private static class genSec {
        private static ArrayList afterdie(String world_name){
            String section = "";
            ArrayList<String> sectionkey = new ArrayList<>();
            
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        afterdie_dot                                );
                
            ArrayList<String> keys = new ArrayList<>();
                keys.add(            playlist_key                            );
                keys.add(            bucle_key                               );
                keys.add(            getout_key                              );
               
                
            for (String dot: dots) {
                section = section + (dot + ".");
            }
            
            for (String key: keys) {
                sectionkey.add(section + key  );
            }
            
            
            return sectionkey;
        }
        
        private static ArrayList spawn_normal(String world_name, String spawn_name){
            String section = "";
            ArrayList<String> sectionkey = new ArrayList<>();
            
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        spawns_dot                                  );
                dots.add(            normals_dot                             );
                dots.add(                normal_dot            = spawn_name  );
                
            ArrayList<String> keys = new ArrayList<>();
                keys.add(                    fixed_key                       );
                keys.add(                    x_key                           );
                keys.add(                    y_key                           );
                keys.add(                    z_key                           );
                keys.add(                    p_key                           );
                keys.add(                    a_key                           );
               
                
            for (String dot: dots) {
                section = section + (dot + ".");
            }
            
            for (String key: keys) {
                sectionkey.add(section + key  );
            }
            
            
            return sectionkey;
        }
        
        private static ArrayList spawn_random(String world_name, String spawn_name){
            String section = "";
            ArrayList<String> sectionkey = new ArrayList<>();
            
            ArrayList<String> dots = new ArrayList<>();
                dots.add(espawn_dot                                          );
                dots.add(    world_dot                         = world_name  );
                dots.add(        spawns_dot                                  );
                dots.add(            randoms_dot                             );
                dots.add(                random_dot            = spawn_name  );
                
            ArrayList<String> keys = new ArrayList<>();
                keys.add(                    fixed_key                       );
                keys.add(                    Rx_maxandmin_key                );
                keys.add(                    Ry_maxandmin_key                );
                keys.add(                    Rz_maxandmin_key                );
                keys.add(                    Rp_maxandmin_key                );
                keys.add(                    Ra_maxandmin_key                );
               
                
            for (String dot: dots) {
                section = section + (dot + ".");
            }
            
            for (String key: keys) {
                sectionkey.add(section + key  );
            }
            
            
            return sectionkey;
        }
    }
    
//    private static class Generate {
//        private static String basic_esconfig(String world_name){
//            String index = null;
//            
//            ArrayList<String> secs = new ArrayList<>();
//                secs.add(espawn_dot                                          );
//                secs.add(    world_dot                         = world_name  );
//                secs.add(        afterdie_dot                                );
//                secs.add(            playlist_key                            );
//                secs.add(            bucle_key                               );
//                secs.add(            getout_key                              );
//                secs.add(        spawns_dot                                  );
//                secs.add(            normals_dot                             );
//                secs.add(            randoms_dot                             );
//            
//            for (String sec: secs) {
//                index = index + (sec + ".");
//            }
//            
//            return index;
//                        
//        }
//        private static String spawnStatic(String world_name, String normal) {
//            String index = null;
//            secs.add(espawn_dot                                              );
//            secs.add(    world_dot                             = world_name  );
//            secs.add(        spawns_dot                                      );
//            secs.add(            normals_dot                                 );
//            secs.add(                normal_dot                              );
//            secs.add(                    fixed_key                           );
//            secs.add(                    x_key                               );
//            secs.add(                    y_key                               );
//            secs.add(                    z_key                               );
//            secs.add(                    p_key                               );
//            secs.add(                    a_key                               );
//                                    
//            return index;
//        }
//        private static void spawnRandom(String world_name, String random) {
//                espawn_dot                                     = "ESpawn"     ;
//                    world_dot                                  = world_name   ;
//                        spawns_dot                             = "Spawns"     ;
//                            randoms_dot                        = "Randoms"    ;
//                                random_dot                     = random       ;
//                                    fixed_key                  = "fixed"      ;
//                                    Rx_maxandmin_key           = "Rx_max&min" ;
//                                    Ry_maxandmin_key           = "Ry_max&min" ;
//                                    Rz_maxandmin_key           = "Rz_max&min" ;
//                                    Rp_maxandmin_key           = "Rp_max&min" ;
//                                    Ra_maxandmin_key           = "Ra_max&min" ;
//        }
//        private static String index() {
//            String index = null;
//            ArrayList<String> secs = new ArrayList<>();
//                secs.add(espawn_dot      );
//                secs.add(world_dot       );
//                secs.add(afterdie_dot    );
//                secs.add(playlist_key    );
//                secs.add(bucle_key       );
//                secs.add(getout_key      );
//                secs.add(spawns_dot      );
//                secs.add(normals_dot     );
//                secs.add(normal_dot      );
//                secs.add(fixed_key       );
//                secs.add(x_key           );
//                secs.add(y_key           );
//                secs.add(z_key           );
//                secs.add(p_key           );
//                secs.add(a_key           );
//                secs.add(randoms_dot     );
//                secs.add(random_dot      );
//                //secs.add(fixed_key     );
//                secs.add(Rx_maxandmin_key);
//                secs.add(Ry_maxandmin_key);
//                secs.add(Rz_maxandmin_key);
//                secs.add(Rp_maxandmin_key);
//                secs.add(Ra_maxandmin_key);
//            
//            secs.forEach((Configuration_inc) -> {
//                            ESpawn.createSection(Configuration_inc);
//                        });
//            
//            return index;
//        }
//    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("espawn")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                String world_name = player.getLocation().getWorld().getName();
                Integer n_args = args.length;
                String arg1 = null;
                String arg2 = null;
                
                
                switch (n_args) {
                    case 0:
                        ArrayList sectionkeys = genSec.afterdie(world_name);
                        sectionkeys.forEach((sec) -> {
                            ESpawn.createSection((String) sec);
                        });
                        generated_config = "Generado afterdie de " + world_name + "\n [AVISO] Genera spawns con la siguiente estructura \n  /espawn <normal/random> <spawn_name>";
			break;
                    case 1:
                        generated_config = "Generado afterdie de " + world_name + "\n [AVISO] Genera spawns con la siguiente estructura \n  /espawn <normal/random> <spawn_name>";
			break;
                    case 2:
                        arg1 = args[0];
                        arg2 = args[1];
                            if (arg1.equalsIgnoreCase("normal")){
                                ArrayList sectionkeys_spawn_normal = genSec.spawn_normal(world_name, arg2);
                                sectionkeys_spawn_normal.forEach((sec) -> {
                                    ESpawn.createSection((String) sec);
                                });
                                generated_config = "Generado afterdie de " + world_name + " y spawn " + arg1 + " con el nombre " + arg2;
                            } else if (arg1.equalsIgnoreCase("random")){
                                ArrayList sectionkeys_spawn_random = genSec.spawn_random(world_name, arg2);
                                sectionkeys_spawn_random.forEach((sec) -> {
                                    ESpawn.createSection((String) sec);
                                });
                                generated_config = "Generado afterdie de " + world_name + " y spawn " + arg1 + " con el nombre " + arg2;
                            } else {
                                ArrayList sectionkeys2 = genSec.afterdie(world_name);
                                sectionkeys2.forEach((sec) -> {
                                    ESpawn.createSection((String) sec);
                                });
                                generated_config = "Generado afterdie de " + world_name + "\n [ERROR] El argumento " + arg1 + " no está contemplado" + "\n  Debes usar: <normal/random>";
                            }
			break;
                    default:
			generated_config = "[ERROR] No se admiten tantos argumentos\n ¿Seguro que sabes lo que estás haciendo?";
		}
                
//                if (n_args >= 1 ) {
//                    arg1 = args[0];
//                }
//                if (n_args >= 2 ) {
//                    arg2 = args[1];
//                }
//                Generate.data();
//                player.sendMessage("Hasta aquí va");
//                if (arg1.equalsIgnoreCase("Static")) {
//                    static1_dot = arg2;
//                    arg1_check = "Static";
//                } else if (arg1.equalsIgnoreCase("Random")){
//                    random1_dot = arg2;
//                    arg1_check = "Random";
//                } else {
//                    arg1_check = null;
//                }
//                
//                
//                String espawn_sec                   = (espawn_dot                 + ".") ; // <- espawn_sec        |
//                String     world_sec                = (espawn_sec  + world_dot    + ".") ; // <- world_sec         |
//                String          afterdie_sec        = (world_sec   + afterdie_dot + ".") ; // <- afterdie_sec      |
//                String          spawns_sec          = (world_sec   + spawns_dot   + ".") ; // <- spawns_sec        |
//                String              statics_sec     = (spawns_sec  + normals_dot  + ".") ; // <- statics_sec       |
//                String                  static1_sec = (statics_sec + normal_dot   + ".") ; // <- static1_sec       |
//                String              randoms_sec     = (spawns_sec  + randoms_dot  + ".") ; // <- randoms_sec       |
//                String                  random1_sec = (randoms_sec + random_dot   + ".") ; // <- random1_sec       |
//                
//                
//                ArrayList<String> Incomplete_gen = new ArrayList<>();
//                String afterdie_inc = world_sec + afterdie_dot;
//                String statics_inc = spawns_sec + statics_dot;
//                String randoms_inc = spawns_sec + randoms_dot;
//                Incomplete_gen.add(afterdie_inc);
//                Incomplete_gen.add(statics_inc);
//                Incomplete_gen.add(randoms_inc);
//                
//                ArrayList<String> Semicomplete_gen = new ArrayList<>();
//                Semicomplete_gen.add(afterdie_inc);
//                if ("String".equals(arg1_check)) {
//                    String static1_inc = statics_sec + static1_dot;
//                    Semicomplete_gen.add(static1_inc);
//                    Semicomplete_gen.add(randoms_inc);
//                } else if ("Random".equals(arg1_check)){
//                    String random1_inc = randoms_sec + random1_dot;
//                    Semicomplete_gen.add(random1_inc);
//                    Semicomplete_gen.add(statics_inc);
//                }
//
//
//                
//                
//                switch (n_args) {
//                    case 0:
//                        Incomplete_gen.forEach((Configuration_inc) -> {
//                            ESpawn.createSection(Configuration_inc);
//                        });
//                        generated_config = "Generada configuración incompleta de " + world_name + "\n [AVISO] Para generar la configuración al completo deberás usar la siguiente estructura \n /espawn <static/random> <spawn_name>";
//			break;
//                    case 1:
//                        Incomplete_gen.forEach((Configuration_inc) -> {
//                            ESpawn.createSection(Configuration_inc);
//                        });
//                        generated_config = "Generada configuración incompleta de " + world_name + "\n [AVISO] Para generar la configuración al completo deberás usar la siguiente estructura:\n /espawn <static/random> <spawn_name>";
//			break;
//                    case 2:
//                        if ("Static".equals(arg1_check) | "Random".equals(arg1_check)){
//                            Semicomplete_gen.forEach((Configuration_sic) -> {
//                                ESpawn.createSection(Configuration_sic);
//                            });
//                            generated_config = "Por ahora no se puede generar esta configuración";
//                        } else {
//                            generated_config = "[ERROR] el argumento " + arg1 + "No está contemplado, debes usar\n <Static/Random>";
//                        }
//			break;
//                    default:
//			generated_config = "[ERROR] No se admiten tantos argumentos\n ¿Seguro que sabes lo que estás haciendo?";
//		}
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
