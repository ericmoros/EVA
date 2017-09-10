package com.eva.multismarts;

import java.text.DecimalFormat;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Useful_methods {

    public static DecimalFormat Decimal_formatter = new DecimalFormat("###########################################.##");
    
    public static String Text_formatter(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    
    public static String Cfg_replacer(FileConfiguration cfg, String variable, String path, String replaced, String replacer) {
        
        
         variable = cfg.getString(path).replaceAll(replaced, replacer);
         
         return variable;
        
        
         
    }
}