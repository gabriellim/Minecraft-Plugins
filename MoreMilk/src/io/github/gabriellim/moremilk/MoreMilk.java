package io.github.gabriellim.moremilk;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/*
 *  Allows player to obtain milk from chicken, horse, ocelot, pig, sheep and wolf
 */

public class MoreMilk extends JavaPlugin implements Listener
{
	Logger Log = getLogger();
	
	@EventHandler
	public void playerInteractEntity (PlayerInteractEntityEvent event)
	{
		Player P = event.getPlayer();
		Entity RC = event.getRightClicked();
		ItemStack ItemInHand = P.getItemInHand();
		
		
		if (P.hasPermission("moremilk.toggle") && ItemInHand.getType().equals(Material.BUCKET))
		{
			if (RC.getType() == EntityType.CHICKEN) 
			{
				ItemStack chickenmilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta chickenmilk_meta = chickenmilk.getItemMeta();
				chickenmilk_meta.setDisplayName(ChatColor.RESET + "Chicken Milk");
				
				List<String> chickenmilk_list = new ArrayList<String>();
				chickenmilk_list.add(ChatColor.GRAY + "'Yummy 100% non-mammalian bird milk");
				chickenmilk_meta.setLore(chickenmilk_list);
				chickenmilk.setItemMeta(chickenmilk_meta);
				
				P.setItemOnCursor(chickenmilk);;
			}
			
			if (RC.getType() == EntityType.HORSE)
			{
				ItemStack horsemilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta horsemilk_meta = horsemilk.getItemMeta();
				horsemilk_meta.setDisplayName(ChatColor.RESET + "Horse Milk");
			
				List<String> horsemilk_list = new ArrayList<String>();
				horsemilk_list.add(ChatColor.GOLD + "'Neighhhhh!'");
				horsemilk_meta.setLore(horsemilk_list);
				horsemilk.setItemMeta(horsemilk_meta);
				
				P.setItemOnCursor(horsemilk);
			}
			
			if (RC.getType() == EntityType.OCELOT)
			{
				ItemStack ocelotmilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta ocelotmilk_meta = ocelotmilk.getItemMeta();
				ocelotmilk_meta.setDisplayName(ChatColor.RESET + "Ocelot Milk");
				
				List<String> ocelotmilk_list = new ArrayList<String>();
				ocelotmilk_list.add(ChatColor.YELLOW + "You fed milk to cat now cat feeds you!");
				ocelotmilk_meta.setLore(ocelotmilk_list);
				ocelotmilk.setItemMeta(ocelotmilk_meta);
				
				P.setItemInHand(ocelotmilk);
				
			}
			
			if (RC.getType() == EntityType.PIG)
			{
				ItemStack pigmilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta pigmilk_meta = pigmilk.getItemMeta();
				pigmilk_meta.setDisplayName(ChatColor.RESET + "Pig Milk");
				
				List<String> pigmilk_list = new ArrayList<String>();
				pigmilk_list.add(ChatColor.RED + "Now with 500% more fat and bacon!");
				pigmilk_meta.setLore(pigmilk_list);
				pigmilk.setItemMeta(pigmilk_meta);
				
				P.setItemInHand(pigmilk);
			}
			
			if (RC.getType() == EntityType.SHEEP)
			{
				ItemStack sheepmilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta sheepmilk_meta = sheepmilk.getItemMeta();
				sheepmilk_meta.setDisplayName(ChatColor.RESET + "Sheep Milk");
				
				List<String> sheepmilk_list = new ArrayList<String>();
				sheepmilk_list.add(ChatColor.WHITE + "'It has a wooly texture'");
				sheepmilk_meta.setLore(sheepmilk_list);
				sheepmilk.setItemMeta(sheepmilk_meta);
				
				P.setItemInHand(sheepmilk);
			}
			
			if (RC.getType() == EntityType.WOLF)
			{
				ItemStack wolfmilk = new ItemStack(Material.MILK_BUCKET);
				ItemMeta wolfmilk_meta = wolfmilk.getItemMeta();
				wolfmilk_meta.setDisplayName(ChatColor.RESET + "Wolf Milk");
				
				List<String> wolfmilk_list = new ArrayList<String>();
				wolfmilk_list.add(ChatColor.LIGHT_PURPLE + "'Wolfy wants milky?'");
				wolfmilk_meta.setLore(wolfmilk_list);
				wolfmilk.setItemMeta(wolfmilk_meta);
				
				P.setItemInHand(wolfmilk);
			}
			
			if (P.hasPermission("moremilk.message")) 
			{
				P.sendMessage(ChatColor.AQUA + "SUCCESS! You milked 'em real good, you dirty farmer you.");
			}
		}
		
	}
	
	public void onEnable()
	{
		Server S = getServer();
		S.getPluginManager().registerEvents(this, this);
		
		Log.info("MoreMilk has been enabled!");
	}
	
	public void onDisable()
	{
		Log.info("MoreMilk has been disabled!");
	}
}

