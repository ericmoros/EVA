package main.java.com.mycompany.trollpluginx.Eventos;

import main.java.com.mycompany.trollpluginx.Principal;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Interaccionar implements Listener{
    
    public Interaccionar() {
        Principal.instance.getServer().getPluginManager().registerEvents(this,Principal.instance);
    }
    
    @EventHandler
    public void onInteract(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inv = e.getInventory();
        if(inv.getName().equals("Menu Troll")) {
            if(clicked.getType() == Material.BLAZE_ROD) {
                p.sendMessage("Rayo");
                e.setCancelled(true);
                p.closeInventory();
            } else if(clicked.getType() == Material.DIAMOND_SWORD) {
                p.setHealth(0);
                e.setCancelled(true);
                p.closeInventory();
            }
        }
    }
}
