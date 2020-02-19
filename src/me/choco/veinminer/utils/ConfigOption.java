package me.choco.veinminer.utils;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import me.choco.veinminer.VeinMiner;
import me.choco.veinminer.api.MineActivation;

/**
 * A list of all configurable values in VeinMiner
 */
public class ConfigOption {
	
	/** 
	 * Whether information should be sent to http://mcstats.org/plugin/VeinMiner/ or not
	 */
	public static boolean METRICS_ENABLED;
	
	/** 
	 * The mode that will cause VeinMiner to activate whilst mining.
	 */
	public static MineActivation ACTIVATION_MODE;
	
	/** 
	 * Whether vein mining will stop to allow for a tool repair or not
	 */
	public static boolean REPAIR_FRIENDLY_VEINMINER;

	/** 
	 * The faces that VeinMiner is going to search for when mining
	 */
	public static VBlockFace[] FACES_TO_MINE;
	
	/** 
	 * A list of all world names in which VeinMiner is disabled
	 */
	public static List<String> DISABLED_WORLDS;
	
	/** 
	 * The maximum vein size that a VeinMine from a pickaxe can destroy
	 */
	public static int PICKAXE_MAX_VEIN_SIZE;
	
	/** 
	 * Whether VeinMiner uses durability on a pickaxe or not
	 */
	public static boolean PICKAXE_USES_DURABILITY;
	
	/** 
	 * The maximum vein size that a VeinMine from an axe can destroy
	 */
	public static int AXE_MAX_VEIN_SIZE;
	
	/** 
	 * Whether VeinMiner uses durability on an axe or not
	 */
	public static boolean AXE_USES_DURABILITY;
	
	/** 
	 * The maximum vein size that a VeinMine from a shovel can destroy
	 */
	public static int SHOVEL_MAX_VEIN_SIZE;
	
	/** 
	 * Whether VeinMiner uses durability on a shovel or not
	 */
	public static boolean SHOVEL_USES_DURABILITY;
	
	/** 
	 * The maximum vein size that a VeinMine from a hoe can destroy
	 */
	public static int HOE_MAX_VEIN_SIZE;
	
	/** 
	 * Whether VeinMiner uses durability on a hoe or not
	 */
	public static boolean HOE_USES_DURABILITY;
	
	/** 
	 * The maximum vein size that a VeinMine from shears can destroy
	 */
	public static int SHEARS_MAX_VEIN_SIZE;
	
	/** 
	 * Whether VeinMiner uses durability on shears or not
	 */
	public static boolean SHEARS_USES_DURABILITY;
	
	/** 
	 * Load all values from the configuration file to the fields provided in this class
	 * 
	 * @param plugin the instance of the VeinMiner plugin
	 */
	public static void loadConfigurationValues(VeinMiner plugin){
		FileConfiguration config = plugin.getConfig();
		
		METRICS_ENABLED = config.getBoolean("MetricsEnabled", true);
		ACTIVATION_MODE = MineActivation.getByName(config.getString("ActivationMode", "SNEAK"));
		if (ACTIVATION_MODE == null) ACTIVATION_MODE = MineActivation.SNEAK;
		REPAIR_FRIENDLY_VEINMINER = config.getBoolean("RepairFriendlyVeinminer", false);
		FACES_TO_MINE = (!config.getBoolean("IncludeEdges") 
				? new VBlockFace[] {
					VBlockFace.UP, VBlockFace.DOWN, VBlockFace.NORTH, VBlockFace.SOUTH, VBlockFace.EAST, VBlockFace.WEST,
					VBlockFace.NORTH_EAST, VBlockFace.NORTH_WEST, VBlockFace.SOUTH_EAST, VBlockFace.SOUTH_WEST
				} : VBlockFace.values());
		DISABLED_WORLDS = config.getStringList("DisabledWorlds");
		
		PICKAXE_MAX_VEIN_SIZE = config.getInt("Tools.Pickaxe.MaxVeinSize", 64);
		PICKAXE_USES_DURABILITY = config.getBoolean("Tools.Pickaxe.UsesDurability", true);
		AXE_MAX_VEIN_SIZE = config.getInt("Tools.Axe.MaxVeinSize", 64);
		AXE_USES_DURABILITY = config.getBoolean("Tools.Axe.UsesDurability", true);
		SHOVEL_MAX_VEIN_SIZE = config.getInt("Tools.Shovel.MaxVeinSize", 64);
		SHOVEL_USES_DURABILITY = config.getBoolean("Tools.Shovel.UsesDurability", true);
		HOE_MAX_VEIN_SIZE = config.getInt("Tools.Hoe.MaxVeinSize", 64);
		HOE_USES_DURABILITY = config.getBoolean("Tools.Hoe.UsesDurability", true);
		SHEARS_MAX_VEIN_SIZE = config.getInt("Tools.Shears.MaxVeinSize", 64);
		SHEARS_USES_DURABILITY = config.getBoolean("Tools.Shears.UsesDurability", true);
	}
}