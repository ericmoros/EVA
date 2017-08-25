//PAQUETE________________________________
package com.eva.multismarts;
//________________________________________

//DEPENDECIAS_____________________________
import com.eva.multismarts.Test_area.Vago;
import java.io.File;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
//________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

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
        
        boolean Vago_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Vago");
        //boolean Vconomy_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.Vconomy");
        //boolean NUEVOMODULO_estado = (boolean) getConfig().getBoolean("Multismarts.Módulos.NUEVOMODULO");
        //____________________________________________________________________________________
        
        //MODULOS_____________________________________________________________________________
            //VAGO
            if (Vago_estado == true) {
                this.getCommand("vago").setExecutor(new Vago (this));
            }
            //VCONOMY
            //if (Vconomy_estado == true && getServer().getPluginManager().getPlugin("Vault") != null) {
            //    setupEconomy();
            //    this.getCommand("vreceive").setExecutor(new vreceive (this));
            //}
            //NUEVOMODULO
            //if (NUEVOMODULO_estado == true) {
            //    this.getCommand("COMANDO").setExecutor(new COMANDO (this));
            //}
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

}
//_______________________________________________________________________________________________________________________________