package io.github.gabriellim.novillagertrade;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Prevents players from trading with villagers
 */

public class NoVillagerTrade extends JavaPlugin implements Listener
{
	Logger Log = getLogger();
	
	@EventHandler
	public void playerInteractEntity(PlayerInteractEntityEvent event)
	{
		Player P = event.getPlayer();
		Entity RC = event.getRightClicked();
		
		if (P.hasPermission("novillagertrade.toggle") && RC.getType() == EntityType.VILLAGER)
		{
			event.setCancelled(true);
		}
	}
	
	public void onEnable()
	{
		Server S = getServer();
		S.getPluginManager().registerEvents(this, this);
		
		Log.info("NoVillagerTrade has been enabled!");
	}
	
	public void onDisable()
	{
		Log.info("NoVillagerTrade has been disabled!");
	}
}
