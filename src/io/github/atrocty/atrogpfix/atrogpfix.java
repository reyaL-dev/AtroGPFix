package io.github.atrocty.atrogpfix;

import me.ryanhamshire.GriefPrevention.Claim;

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
	
	public class CreatureSpawnListener implements Listener
	{
		@EventHandler(ignoreCancelled = true)
		private void onCreatureSpawn(CreatureSpawnEvent e)
		{
			Claim claim = ClaimManager.getClaimAtLocation(e.getLocation());
			World world = e.getEntity().getWorld();
			Flag flag = new Flag(Type.SpawnMob);
	
			if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) 
			{
				if (claim == null) {
				e.setCancelled(!flag.isUnclaimedAllowed(world));
			} 
			else 
			{
				e.setCancelled(!flag.isAllowed(claim));
			}
			return;
		}
}
