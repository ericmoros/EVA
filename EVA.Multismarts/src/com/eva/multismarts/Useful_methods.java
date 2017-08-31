package com.eva.multismarts;

import java.text.DecimalFormat;
import org.bukkit.ChatColor;

public class Useful_methods {

    public static DecimalFormat Decimal_formatter = new DecimalFormat("###########################################.##");
    
    public static String Text_formatter(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

}
