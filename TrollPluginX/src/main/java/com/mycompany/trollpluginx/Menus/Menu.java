package main.java.com.mycompany.trollpluginx.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu {
    
    public static void abrirMenu(Player p) {
        
        ItemStack item0 = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta0 = item0.getItemMeta();
        meta0.setDisplayName("Rayo");
        item0.setItemMeta(meta0);
        
        ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta1 = item1.getItemMeta();
        meta0.setDisplayName("Kill");
        item0.setItemMeta(meta1);
        
        Inventory inventario = Bukkit.createInventory(null, 27, "Menu Troll");
        
        inventario.setItem(3, item0);
        inventario.setItem(5, item1);
        
        p.openInventory(inventario);
    }
    
}
