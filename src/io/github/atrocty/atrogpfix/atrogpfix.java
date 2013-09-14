package io.github.atrocty.atrogpfix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class atrogpfix extends JavaPlugin 
{
	@Override
	public void onEnable()
	{
		getLogger().info("onEnable wurde ausgeführt!");
	}
	 
	@Override
	public void onDisable() 
	{
		getLogger().info("onDisable wurde ausgeführt!");
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("basic"))
    	{ // If the player typed /basic then do the following...
    		// do something...
    		return true;
    	} 
    	else if (cmd.getName().equalsIgnoreCase("basic2")) 
    	{
    		if (!(sender instanceof Player)) 
    		{
    			sender.sendMessage("This command can only be run by a player.");
    		} 
    		else 
    		{
    			Player player = (Player) sender;
    			// do something
    		}
    		return true;
    	}
    	return false;
    }



}
