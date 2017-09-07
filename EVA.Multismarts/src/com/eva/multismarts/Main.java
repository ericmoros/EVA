//PAQUETE_________________________________________________
package com.eva.multismarts;
//________________________________________________________

//DEPENDECIAS MODULOS_____________________________________
import com.eva.multismarts.ESpawn.CmdESpawn;
import com.eva.multismarts.Ejemplos.Ejemplo_hola;
import com.eva.multismarts.vconomy.commands.CmdVgive;
import com.eva.multismarts.vconomy.commands.CmdVreceive;
import com.eva.multismarts.vconomy.commands.CmdVmoney;
import com.eva.multismarts.vconomy.commands.CmdVpay;
import com.eva.multismarts.vconomy.commands.CmdVreset;
import com.eva.multismarts.vconomy.commands.CmdVtake;
import com.eva.multismarts.vscoreboard.Board;
import com.eva.multismarts.vscoreboard.PlayerListener;
//________________________________________________________

//DEPENDECIAS_____________________________________________
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.logging.Logger;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
//________________________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;
    
    //PARA EL LOG___________________________________________________
    private static final Logger log = Logger.getLogger("Minecraft");
    //______________________________________________________________
    
    
    //PARA LA CONFIGURACIÓN_________________________________________
      //CONFIGS___________________________________________________
        //MODULOS
        HashMap<File, String> Config_data = new HashMap<>();
        public FileConfiguration Config = new YamlConfiguration();
        File Config_file;

        //EJEMPLOS
        HashMap<File, String> Ejsconfig_data = new HashMap<>();
        public FileConfiguration Ejsconfig = new YamlConfiguration();
        File Ejsconfig_file;
        public static HashMap<File, String> Ejsconfig2_data = new HashMap<>();
        public static FileConfiguration Ejsconfig2 = new YamlConfiguration();
        public static File Ejsconfig2_file;
        
        //VSCOREBOARD
        HashMap<File, String> ConfigVscoreboard_data = new HashMap<>();
        public static FileConfiguration ConfigVscoreboard = new YamlConfiguration();
        public static File ConfigVscoreboard_file;
        //VSCOREBOARD KILLS 
        HashMap<File, String> ConfigVscoreboarddata_data = new HashMap<>();
        public static FileConfiguration ConfigVscoreboarddata = new YamlConfiguration();
        public static File ConfigVscoreboarddata_file;
        
        //ESPAWN
        HashMap<File, String> ESpawn_data = new HashMap<>();
        public static FileConfiguration ESpawn = new YamlConfiguration();
        public static File ESpawn_file;
        
        
      //__________________________________________________________
    
    public static HashMap<FileConfiguration, HashMap<File, String>> Configs = new HashMap<>();
  
    public void Precook_configs (HashMap Keyword_config, FileConfiguration Operable_config, String Plugin_file_destiny, File Operable_config_file, String Default_source){
        Operable_config_file = new File(getDataFolder(), Plugin_file_destiny);
        Keyword_config.put(Operable_config_file, Default_source);
        Configs.put(Operable_config, Keyword_config);
    }
    
    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadYamls() {
        try {
            for (FileConfiguration Configurations: Configs.keySet()) {
                for (File Configuration_files: (Configs.get(Configurations)).keySet()) {
                    Configurations.load(Configuration_files); //loads the contents of the File to its FileConfiguration
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void loadConfig(FileConfiguration Operable_config) {
        try {
            for (File Configuration_file: (Configs.get(Operable_config)).keySet()) {
                Operable_config.load(Configuration_file); //loads the contents of the File to its FileConfiguration
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveYamls() {
        try {
            for (FileConfiguration Configurations: Configs.keySet()) {
                for (File Configuration_files: (Configs.get(Configurations)).keySet()) {
                    Configurations.save(Configuration_files); //saves the FileConfiguration to its File
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveConfig (FileConfiguration Operable_config) {
        try {
            for (File Configuration_file: (Configs.get(Operable_config)).keySet()) {
                Operable_config.save(Configuration_file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void firstRun() throws Exception {
        for (FileConfiguration Configurations: Configs.keySet()) {
            for (File Configuration_files: (Configs.get(Configurations)).keySet()) {
                String Configuration_files_route = Configs.get(Configurations).get(Configuration_files);
                if(!Configuration_files.exists()){
                    Configuration_files.getParentFile().mkdirs();
                    copy(getResource(Configuration_files_route), Configuration_files);
                }
            }
        }
    }
    //_____________________________________________________________
    
    //INSTALADOR DEL ECONOMY_______________________________________
    public static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    
    
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
            return econ != null;
    }
    //_____________________________________________________________
     private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    public static Economy getEconomy() {
        return econ;
    } 
    public static Permission getPermissions() {
        return perms;
    } 
    public static Chat getChat() {
        return chat;
    } 
    
    @Override
    public void onEnable() {
        instance = this;
        
        //CONFIGURACIÓN MODULOS_______________________________________________________________
                          //2         //1       //0            //3          //4
        Precook_configs(Config_data, Config, "Config.yml", Config_file, "config.yml");
        Precook_configs(Ejsconfig_data, Ejsconfig, "Examples/Ejs_config.yml", Ejsconfig_file, "com/eva/multismarts/Ejemplos/ejsconfig.yml");
        Precook_configs(Ejsconfig2_data, Ejsconfig2, "Examples/Ejs_config_2.yml", Ejsconfig2_file, "com/eva/multismarts/Ejemplos/ejsconfig_2.yml");
        Precook_configs(ConfigVscoreboard_data, ConfigVscoreboard, "VScoreboard/config.yml", ConfigVscoreboard_file, "com/eva/multismarts/vscoreboard/config.yml");
        Precook_configs(ConfigVscoreboarddata_data, ConfigVscoreboarddata, "VScoreboard/data.yml", ConfigVscoreboarddata_file, "com/eva/multismarts/vscoreboard/data.yml");
        Precook_configs(ESpawn_data, ESpawn, "ESpawn/Esconfig.yml", ESpawn_file, "com/eva/multismarts/ESpawn/esconfig.yml");
        
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        loadYamls();
        //____________________________________________________________________________________
        
        
        //MODULOS_____________________________________________________________________________
        boolean Vconomy_estado = (boolean) Config.getBoolean("Multismarts.Modules.Vconomy");
        boolean VScoreboard_estado = (boolean) Config.getBoolean("Multismarts.Modules.VScoreboard");
        boolean Ejemplos_estado = (boolean) Config.getBoolean("Multismarts.Modules.Ejemplos");
        boolean Espawn_estado = (boolean) Config.getBoolean("Multismarts.Modules.Ejemplos");
            //VCONOMY
            if (Vconomy_estado == true && getServer().getPluginManager().getPlugin("Vault") != null) {
                setupEconomy();
                this.getCommand("vreset").setExecutor(new CmdVreset (this));
                this.getCommand("vreceive").setExecutor(new CmdVreceive (this));
                this.getCommand("vmoney").setExecutor(new CmdVmoney (this));
                this.getCommand("vtake").setExecutor(new CmdVtake(this));
                this.getCommand("vgive").setExecutor(new CmdVgive (this));
                this.getCommand("vpay").setExecutor(new CmdVpay (this));
            }
            //VSCOREBOARD
             if (VScoreboard_estado == true && getServer().getPluginManager().getPlugin("Vault") != null) {
                 this.getServer().getPluginManager().registerEvents(new PlayerListener(instance), instance);
               // this.getCommand("vscoreboard").setExecutor(new CmdVScoreboard (this));
             }
            
            //ESPAWN
             //if (Espawn_estado == true) {
                 //this.getCommand("espawn").setExecutor(new CmdESpawn (this));
                 this.getCommand("espawn").setExecutor(new CmdESpawn (this));
             //}
             
            //Ejemplos
             if (Ejemplos_estado == true) {
                 this.getCommand("hola").setExecutor(new Ejemplo_hola (this));
             }
        //____________________________________________________________________________________
        
        //MENSAJE ARRANQUE CONSOLA_________
        this.getLogger().info("Activado");
        //_________________________________
    }


    @Override
    public void onDisable(){
        //GUARDA LOS ARCHIVOS DE CONF________
        //saveYamls();
        //___________________________________
        //MENSAJE APAGADO CONSOLA____________
        this.getLogger().info("Desactivado");
        //___________________________________
        
        //LOG___________________________________________________________________________________________________________
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        //______________________________________________________________________________________________________________
    }
    
}

//____________________________________________________________________________________________________________________________