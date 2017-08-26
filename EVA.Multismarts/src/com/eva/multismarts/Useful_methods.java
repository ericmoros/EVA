package com.eva.multismarts;

import java.text.DecimalFormat;
import org.bukkit.ChatColor;

public class Useful_methods {
    
    public DecimalFormat Decimal_formater = new DecimalFormat("###########################################.##");
    
    public String Text_formater(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
