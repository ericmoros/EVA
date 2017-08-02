package com.eva.multismarts;
//test
//test 2
//test 3
//test 4
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    public static Main instance;

    static void getBoolean(String activadoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void onEnable() {
        instance = this;
        File config = new File(getDataFolder()+File.separator+"config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        this.getServer().getPluginManager().registerEvents(new OyenteJugador(instance), instance);
        this.getCommand("hola").setExecutor(new Hola (this));
        boolean Activado_Estado = (boolean) getConfig().getBoolean("Activado.Estado");
        if (Activado_Estado == true) {
            this.getLogger().info(getConfig().getString("Activado.Mensaje"));
        }
    }
    @Override
    public void onDisable(){
        boolean Desctivado_Estado = getConfig().getBoolean("Desactivado.Estado");
        if (Desctivado_Estado == true) {
            this.getLogger().info(getConfig().getString("Desactivado.Mensaje"));
        }
    }
    
    public String Formatear_texto(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}