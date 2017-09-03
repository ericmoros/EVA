/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import java.util.ArrayList;
import java.util.List;

/**
 * Deletes worlds.
 */
public class DeleteCommand extends MultiverseCommand {

    public DeleteCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Delete World");
        this.setCommandUsage("/mv delete" + ChatColor.GREEN + " {WORLD}");
        this.setArgRange(1, 1);
        this.addKey("mvdelete");
        this.addKey("mv delete");
        this.addCommandExample("/mv delete " + ChatColor.GOLD + "MyWorld");
        this.setPermission("multiverse.core.delete", "Deletes a world on your server. " + ChatColor.RED + "PERMANENTLY.", PermissionDefault.OP);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        Class<?>[] paramTypes = {String.class};
        List<Object> objectArgs = new ArrayList<Object>(args);
        this.plugin.getCommandHandler().queueCommand(sender, "mvdelete", "deleteWorld", objectArgs,
                paramTypes, ChatColor.GREEN + "World Deleted!", ChatColor.RED + "World could NOT be deleted!");
    }
}
