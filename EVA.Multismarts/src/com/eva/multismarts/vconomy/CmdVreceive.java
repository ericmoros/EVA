// PAQUETE
package com.eva.multismarts.vconomy;

// DEPENDENCIAS    
import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CmdVreceive implements CommandExecutor {
   
    private final Main plugin;
    
    public CmdVreceive(Main instance) {
        this.plugin = instance;
        
    }
    
    Useful_methods EVA = new Useful_methods();
    
   // COMANDO VRECEIVE
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        
        // SI EL NÚMERO DE ARGUMENTOS NO ES 1, SE LE MOSTRARÁ AL EMISOR(PERSONA QUE INTRODUCE EL COMANDO) LOS SIGUIENTES MENSAJES
        if(args.length != 1) {
             sender.sendMessage(EVA.Text_formatter("&cLa sintaxis del comando que has introducido es incorrecta."));
             sender.sendMessage(EVA.Text_formatter("&2Sintaxis correcta:&f /vreceive <cantidad>"));
             return true;
         }
          
        // AL INTRODUCIR EL COMANDO VRECEIVE
        if (commandLabel.equalsIgnoreCase("vreceive")) {
            
            // SE CREA LA VARIABLE CANTIDAD LA CUAL CORRESPONDE A LA CANTIDAD DE DINERO QUE EL EMISOR QUERRÁ RECIBIR
            double amount = 0;
        
             try 
                 {
			// SE FUERZA A QUE LOS NÚMEROS QUE INTRODUZCA EL EMISOR SE CONVIERTAN A UNA VARIABLE DOUBLE(PARA PODER TRABAJAR CON DECIMALES)
			amount = Double.parseDouble(args[0]);
			
                 }      catch(Exception e) // TIPO DE ERROR, EL CUAL ACTÚA SI EL EMISOR INTRODUCE UN VALOR QUE NO ES UN NÚMERO
                          {
			
                         sender.sendMessage(EVA.Text_formatter("&cDebes introducir un número válido."));
                            return true;
			
                          }
         // TRAE EL MÉTODO GETECONOMY DE LA CLASE MAIN (IMPRESCINDIBLE PARA USAR MÉTODOS DE VAULT)
         Economy econ = Main.getEconomy();
         // SI SE INTRODUCE UN NÚMERO INFERIOR O IGUAL A 0, SALTARÁ EL SIGUITE MENSAJE, ADEMÁS NO SE REALIZARÁ LA TRANSFERENCIA
         if (Double.parseDouble(args[0]) <= 0){
             sender.sendMessage(EVA.Text_formatter("&cEl valor debe ser superior a 0."));
             return true;
         }
         // EL VALOR(VALOR DADO POR EL EMISOR) QUE TIENE LA VARIABLE CANTIDAD, LA RECIBIRÁ EN SU CUENTA DE DINERO EL EMISOR
            EconomyResponse er = econ.depositPlayer((Player) sender, amount);
            // SI LA OPERACIÓN SE REALIZÓ CON ÉXITO, SE MOSTRARÁ EL SIGUIENTE MENSAJE AL EMISOR
            if (er.transactionSuccess()) {
                sender.sendMessage(EVA.Text_formatter("&a[&fEconomía&a] &2Has recibido &f" +EVA.Decimal_formatter.format(amount)+" &fcréditos&2."));
                return true;
            } else {
                sender.sendMessage(EVA.Text_formatter("&cEl valor debe ser superior a 0."));
                return true;
            }
        }
        return true;
    } 
}
  
    
