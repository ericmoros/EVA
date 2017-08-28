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
    File configFile;
    FileConfiguration config;
    
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
            config.load(configFile); //loads the contents of the File to its FileConfiguration
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveYamls() {
        try {
            config.save(configFile); //saves the FileConfiguration to its File
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void firstRun() throws Exception {
        if(!configFile.exists()){
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
    }
    //_____________________________________________________________
    
    
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
        /*//CONFIGURACIÓN MODULOS_______________________________________________________________
        File config = new File(getDataFolder()+File.separator+"config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        boolean Vconomy_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Vconomy");
        boolean Ejemplos_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Ejemplos");
        //____________________________________________________________________________________*/
        //CONFIGURACIÓN MODULOS_______________________________________________________________
        configFile = new File(getDataFolder(), "config.yml");
        
        try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        config = new YamlConfiguration();
        
        loadYamls();
        boolean Vconomy_estado = (boolean) config.getBoolean("Multismarts.Módulos.Vconomy");
        boolean Ejemplos_estado = (boolean) config.getBoolean("Multismarts.Módulos.Ejemplos");
        //____________________________________________________________________________________       
        
        
        //MODULOS_____________________________________________________________________________
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
        saveYamls();
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