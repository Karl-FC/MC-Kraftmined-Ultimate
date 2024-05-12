package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CocaColaGrenadeRangedItemUsedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
	}
}
