package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModItems;

public class ClayWaterBottleItemIsCraftedsmeltedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == KraftmineModItems.CLAY_WATER_BOTTLE.get()) {
			itemstack.getOrCreateTag().putDouble("content", 5);
			ClaybottleContentProcedure.execute(entity, itemstack);
		}
	}
}
