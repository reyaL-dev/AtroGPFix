package io.github.atrocty.atrogpfix;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;

public class atrogpfix extends JavaPlugin implements Cancellable
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
	
	public static Claim getClaimAtLocation(Location loc)
	{
		return GriefPrevention.instance.dataStore.getClaimAt(loc, true, null);
	}
	
	private boolean cancel = false;
	
	public class CreatureSpawnListener implements Listener
	{
		@EventHandler(ignoreCancelled = true)
		
		private void onCreatureSpawn(CreatureSpawnEvent e)
		{
			Claim claim = getClaimAtLocation(e.getLocation());
			
			if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) 
			{
				if (claim != null) 
				{
					e.setCancelled(true);
				}
			}
			return;
		}
	}

	@Override
	public boolean isCancelled() 
	{
		return cancel;
	}

	@Override
	public void setCancelled(boolean cancel) 
	{
		this.cancel = cancel;
	}
}
