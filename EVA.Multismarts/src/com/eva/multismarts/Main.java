//PAQUETE_________________________________________________
package com.eva.multismarts;
//________________________________________________________

//DEPENDECIAS MODULOS_____________________________________
import com.eva.multismarts.Ejemplos.Ejemplo_hola;
import com.eva.multismarts.vconomy.commands.CmdVgive;
import com.eva.multismarts.vconomy.commands.CmdVreceive;
import com.eva.multismarts.vconomy.commands.CmdVmoney;
import com.eva.multismarts.vconomy.commands.CmdVpay;
import com.eva.multismarts.vconomy.commands.CmdVreset;
import com.eva.multismarts.vconomy.commands.CmdVtake;
import com.eva.multismarts.vscoreboard.PlayerListener;
//________________________________________________________

//DEPENDECIAS_____________________________________________
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
//________________________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;
    
    //PARA EL LOG___________________________________________________
    private static final Logger log = Logger.getLogger("Minecraft");
    //______________________________________________________________
    
    
    //PARA LA CONFIGURACIÓN_________________________________________
    HashMap<FileConfiguration, HashMap<File, String>> Configs = new HashMap<FileConfiguration, HashMap<File, String>>();
    public File configFile, ejsconfigFile, Ejsconfig2_file;
    public FileConfiguration config, ejsconfig, Ejsconfig2;
    
    HashMap<File, String> Ejsconfig2_ext = new HashMap<File, String>();
    
    public void Precook_configs (){
        Ejsconfig2_file = new File(getDataFolder(), "Examples/config2.yml");
        Ejsconfig2_ext.put(Ejsconfig2_file, "com/eva/multismarts/Ejemplos/ejsconfig_2.yml");
        Ejsconfig2 = new YamlConfiguration(); 
        Configs.put(Ejsconfig2, Ejsconfig2_ext);
    }
    
    /*/DO NOT WORKS__________________________________________________
    public void Precook_configs2 (HashMap Keyword_config, File Keyword_file, String Plugin_file_destiny, String Default_source, FileConfiguration Operable_config){
        Keyword_file = new File(getDataFolder(), Plugin_file_destiny);
        Keyword_config.put(Keyword_file, Default_source);
        Operable_config = new YamlConfiguration(); 
        Configs.put(Operable_config, Keyword_config);
    }
    //______________________________________________________________/*/
    
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
                for (File ConfigurationFiles: (Configs.get(Configurations)).keySet()) {
                    config.load(configFile);
                    ejsconfig.load(ejsconfigFile);//loads the contents of the File to its FileConfiguration
                    Configurations.load(ConfigurationFiles);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveYamls() {
        try {
            config.save(configFile); //saves the FileConfiguration to its File
            ejsconfig.save(ejsconfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void firstRun() throws Exception {
        for (FileConfiguration Configurations: Configs.keySet()) {
            for (File ConfigurationFiles: (Configs.get(Configurations)).keySet()) {
                if(!configFile.exists()){
                    configFile.getParentFile().mkdirs();
                    copy(getResource("config.yml"), configFile);
                }
                if(!ejsconfigFile.exists()){
                    ejsconfigFile.getParentFile().mkdirs();
                    copy(getResource("com/eva/multismarts/Ejemplos/ejsconfig.yml"), ejsconfigFile);
                }
                
                String ConfigurationFilesRoute = Configs.get(Configurations).get(ConfigurationFiles);

                if(!ConfigurationFiles.exists()){
                    ConfigurationFiles.getParentFile().mkdirs();
                    copy(getResource(ConfigurationFilesRoute), ConfigurationFiles);
                }
                
            }
        }
    }
    //INSTALADOR DEL SCOREBOARD
    public static Scoreboard board;
    public static Objective objetivo;
    
    public static Scoreboard getScoreboard() {
        return board;
    }
    
    public static Objective getObjetivo() {
        return objetivo;
    }
    
    public static void setupScoreboard() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
        
        objetivo = board.registerNewObjective("bloques", "dummy");
        objetivo.setDisplayName("Bloques Rotos");
        objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
    }
    
    
    //INSTALADOR DEL ECONOMY_______________________________________
    public static Economy econ = null;
    public static Economy getEconomy() {
        return econ;
    }
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
            return econ != null;
    }
    //_____________________________________________________________
    
    
    @Override
    public void onEnable() {
        instance = this;
        
        //CONFIGURACIÓN MODULOS_______________________________________________________________
        
        
        configFile = new File(getDataFolder(), "Config.yml");
        ejsconfigFile = new File(getDataFolder(), "Examples/Ejs_config.yml");
        
<<<<<<< HEAD
=======
        
        config = new YamlConfiguration();
        ejsconfig = new YamlConfiguration();
        //Configs_ext.add("Ejsconfig_ext");
        
        Precook_configs();
        //DO NOT WORKS -> Precook_configs2(Ejsconfig2_ext, Ejsconfig2_file, "Examples/config2.yml", "com/eva/multismarts/Ejemplos/ejsconfig_2.yml", Ejsconfig2);
        
>>>>>>> b0c9deae88854b92388c67ef9f1d2941e27ebbb2
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        loadYamls();
        //____________________________________________________________________________________
        
        
        //MODULOS_____________________________________________________________________________
        boolean Vconomy_estado = (boolean) config.getBoolean("Multismarts.Módulos.Vconomy");
        boolean Ejemplos_estado = (boolean) config.getBoolean("Multismarts.Módulos.Ejemplos");
        String Hola_Mensaje = Ejsconfig2.getString("ejemplo.test");
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
            setupScoreboard();
            this.getServer().getPluginManager().registerEvents(new PlayerListener(instance), instance);
            //Ejemplos
            if (Ejemplos_estado == true) {
                this.getCommand("hola").setExecutor(new Ejemplo_hola (this));
            }
        //____________________________________________________________________________________
        
        //MENSAJE ARRANQUE CONSOLA_________
        this.getLogger().info("Activado");
        this.getLogger().info(Hola_Mensaje);
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

//_______________________________________________________________________________________________________________________________