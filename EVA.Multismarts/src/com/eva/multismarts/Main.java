//PAQUETE_________________________________________________
package com.eva.multismarts;
//________________________________________________________

//DEPENDECIAS MODULOS_____________________________________
import com.eva.multismarts.Ejemplos.Ejemplo_hola;
import com.eva.multismarts.vconomy.CmdVgive;
import com.eva.multismarts.vconomy.CmdVreceive;
import com.eva.multismarts.vconomy.CmdVmoney;
import com.eva.multismarts.vconomy.CmdVtake;
//________________________________________________________

//DEPENDECIAS_____________________________________________
import java.io.File;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
//________________________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;
    private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
            return econ != null;
    }
    
    
    
    @Override
    public void onEnable() {
        instance = this;
        //CONFIGURACIÓN MODULOS_______________________________________________________________
        File config = new File(getDataFolder()+File.separator+"config.yml");
        
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        
        boolean Vconomy_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Vconomy");
        boolean Ejemplos_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Ejemplos");
        //____________________________________________________________________________________
        
        //MODULOS_____________________________________________________________________________
            //VCONOMY
            if (Vconomy_estado == true && getServer().getPluginManager().getPlugin("Vault") != null) {
                setupEconomy();
                this.getCommand("vreceive").setExecutor(new CmdVreceive (this));
                this.getCommand("vmoney").setExecutor(new CmdVmoney (this));
                this.getCommand("vtake").setExecutor(new CmdVtake(this));
                this.getCommand("vgive").setExecutor(new CmdVgive (this));
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
        //MENSAJE APAGADO CONSOLA____________
        this.getLogger().info("Desactivado");
        //___________________________________
        
        //LOG___________________________________________________________________________________________________________
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        //______________________________________________________________________________________________________________
    }
    
    public static Economy getEconomy() {
        return econ;
    }
}

//_______________________________________________________________________________________________________________________________