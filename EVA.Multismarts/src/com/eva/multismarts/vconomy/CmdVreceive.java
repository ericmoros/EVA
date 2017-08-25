// PAQUETES
package com.eva.multismarts.vconomy;

// IMPORTACIONES    
import com.eva.multismarts.Main;
import java.text.DecimalFormat;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class CmdVreceive implements CommandExecutor {
//public class CmdVreceive implements CommandExecutor {
    private final Main plugin;
    public CmdVreceive(Main instance) {
        this.plugin = instance;
        
    }
  
    // EDITOR DEL FORMATO DE NÚMEROS DÉCIMALES
    DecimalFormat formateardec = new DecimalFormat("############################################.##"); 
    // EDITOR DEL FORMATO DE TEXTO
    public String formateartext(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    
   // COMANDO VRECEIVE
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        
        // SI EL NÚMERO DE ARGUMENTOS NO ES 1, SE LE MOSTRARÁ AL EMISOR(PERSONA QUE INTRODUCE EL COMANDO) LOS SIGUIENTES MENSAJES
        if(args.length != 1) {
             sender.sendMessage(formateartext("&cLa sintaxis del comando que has introducido es incorrecta."));
             sender.sendMessage(formateartext("&2Sintaxis correcta:&f /vreceive <cantidad>"));
             return true;
         }
          
        // AL INTRODUCIR EL COMANDO VRECEIVE
        if (commandLabel.equalsIgnoreCase("vreceive")) {
            
            // SE CREA LA VARIABLE CANTIDAD LA CUAL CORRESPONDE A LA CANTIDAD DE DINERO QUE EL EMISOR QUERRÁ RECIBIR
            double cantidad = 0;
        
         try 
         {
			// SE FUERZA A QUE LOS NÚMEROS QUE INTRODUZCA EL EMISOR SE CONVIERTAN A UNA VARIABLE DOUBLE(PARA PODER TRABAJAR CON DECIMALES)
			cantidad = Double.parseDouble(args[0]);
			
	 } catch(Exception e) // TIPO DE ERROR, EL CUAL ACTÚA SI EL EMISOR INTRODUCE UN VALOR QUE NO ES UN NÚMERO
          {
			
                    sender.sendMessage(formateartext("&cDebes introducir un número válido."));
			return true;
			
	  }
         Economy econ = Main.getEconomy();
         // EL VALOR(VALOR DADO POR EL EMISOR) QUE TIENE LA VARIABLE CANTIDAD, LA RECIBIRA EN SU CUENTA DE DINERO EL EMISOR
            EconomyResponse er = econ.depositPlayer((Player) sender, cantidad);
            // SI LA OPERACIÓN SE REALIZÓ CON ÉXITO, SE MOSTRARÁ EL SIGUIENTE MENSAJE AL EMISOR
            if (er.transactionSuccess()) {
                sender.sendMessage(formateartext("&2Has recibido &f" +formateardec.format(cantidad)+" &fcréditos."));
                return true;
            } else {
                sender.sendMessage(formateartext("&cEl valor debe ser superior a 0."));
                return true;
            }
        }
        return true;
    } 
}
  
    
