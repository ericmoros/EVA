//PAQUETES________________________________
package com.eva.multismarts;
//________________________________________

//DEPENDECIAS_____________________________
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
//________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        
        //ARCHIVO CONFIGURACIÓN MODULOS_____________________________________________
        File config = new File(getDataFolder()+File.separator+"config.yml");
        
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        //__________________________________________________________________________
        
        
        //MENSAJE ARRANQUE CONSOLA_________
        this.getLogger().info("Activado");
        //_________________________________
    }


    @Override
    public void onDisable(){
        //MENSAJE APAGADO CONSOLA____________
        this.getLogger().info("Desactivado");
        //___________________________________
    }

}
//_______________________________________________________________________________________________________________________________