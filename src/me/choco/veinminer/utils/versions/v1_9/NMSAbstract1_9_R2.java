package me.choco.veinminer.utils.versions.v1_9;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.choco.veinminer.utils.versions.NMSAbstract;
import net.minecraft.server.v1_9_R2.BlockPosition;

/**
 * The Minecraft 1.9.4 implementation of {@link NMSAbstract}. This class should
 * not be instantiated anywhere other than VeinMiner's main class
 */
public class NMSAbstract1_9_R2 implements NMSAbstract {

	@Override
	public void breakBlock(Player player, Block block) {
		((CraftPlayer) player).getHandle().playerInteractManager.breakBlock(new BlockPosition(block.getX(), block.getY(), block.getZ()));
	}

	@Override
	public ItemStack getItemInHand(Player player) {
		return player.getInventory().getItemInMainHand();
	}
}