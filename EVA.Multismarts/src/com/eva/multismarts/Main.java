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
    File configFile, ejsconfigFile;
    public FileConfiguration config, ejsconfig;
    
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
            config.load(configFile);
            ejsconfig.load(ejsconfigFile);//loads the contents of the File to its FileConfiguration
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
        if(!configFile.exists()){
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
        if(!ejsconfigFile.exists()){
            ejsconfigFile.getParentFile().mkdirs();
            copy(getResource("com/eva/multismarts/Ejemplos/ejsconfig.yml"), ejsconfigFile);
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
        
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }

        config = new YamlConfiguration();
        ejsconfig = new YamlConfiguration();

        loadYamls();
        //____________________________________________________________________________________       
        
        
        //MODULOS_____________________________________________________________________________
        boolean Vconomy_estado = (boolean) config.getBoolean("Multismarts.Módulos.Vconomy");
        boolean Ejemplos_estado = (boolean) config.getBoolean("Multismarts.Módulos.Ejemplos");
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