package main.java.com.mycompany.trollpluginx;

import main.java.com.mycompany.trollpluginx.Eventos.Interaccionar;
import main.java.com.mycompany.trollpluginx.Menus.Menu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin implements Listener{
    
    public static Plugin instance;
    
    @Override
    public void onEnable() {
        instance = this;
        System.out.println("El plugin se ha cargado correctamente");
        new Interaccionar();
    }
    @Override
    public void onDisable() {
        System.out.println("El plugin se ha desactivado correctamente");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("troll")) {
            if(sender instanceof Player) {
                Player p = (Player)sender;
                Menu.abrirMenu(p);
            }
            return true;
        }
        return true;
    }
}
