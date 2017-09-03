/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * Allows management of Anchor Destinations.
 */
public class GameruleCommand extends MultiverseCommand {

    public GameruleCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Set a Minecraft Game Rule for a World.");
        this.setCommandUsage("/mv gamerule " + ChatColor.GREEN + "{RULE} {VALUE}" + ChatColor.GOLD + " [WORLD]");
        this.setArgRange(2, 3);
        this.addKey("mv gamerule");
        this.addKey("mv rule");
        this.addKey("mvgamerule");
        this.addKey("mvrule");
        this.addCommandExample("/mv gamerule " + ChatColor.GREEN + "doMobLoot false");
        this.addCommandExample("/mvrule " + ChatColor.GREEN + "keepInventory true " + ChatColor.RED + "world_nether");
        this.setPermission("multiverse.core.gamerule.set", "Allows a player to set a gamerule.", PermissionDefault.OP);
    }


    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        // We NEED a world from the command line
        final Player p;
        if (sender instanceof Player) {
            p = (Player) sender;
        } else {
            p = null;
        }

        if (args.size() == 2 && p == null) {
            sender.sendMessage("From the command line, WORLD is required.");
            sender.sendMessage(this.getCommandDesc());
            sender.sendMessage(this.getCommandUsage());
            sender.sendMessage("Nothing changed.");
            return;
        }

        final String gameRule = args.get(0);
        final String value = args.get(1);
        final World world;
        if (args.size() == 2) {
            world = p.getWorld();
        } else {
            world = Bukkit.getWorld(args.get(2));
        }

        if (world.setGameRuleValue(gameRule, value)) {
            sender.sendMessage(ChatColor.GREEN + "Success!" + ChatColor.WHITE + " Gamerule " + ChatColor.AQUA + gameRule
                    + ChatColor.WHITE + " was set to " + ChatColor.GREEN + value);
        } else {
            sender.sendMessage(ChatColor.RED + "Failure!" + ChatColor.WHITE + " Gamerule " + ChatColor.AQUA + gameRule
                    + ChatColor.WHITE + " cannot be set to " + ChatColor.RED + value);
        }
    }
}
