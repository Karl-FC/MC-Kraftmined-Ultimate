package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ClaybottleContentProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
					.setHoverName(Component.literal(("Water Bottle" + " (" + (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("content") / 5) * 100) + "%)")));
		}
	}
}
