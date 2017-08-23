//PAQUETES________________________________
package com.eva.multismarts;
//________________________________________

//DEPENDECIAS_____________________________
import org.bukkit.plugin.java.JavaPlugin;
//________________________________________

//MAIN___________________________________________________________________________________________________________________________
public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
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