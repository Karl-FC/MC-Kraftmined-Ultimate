package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

public class SwiftfootedProcedureProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)).isEnchanted()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SWIFTFOOTED.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			return true;
		}
		return false;
	}
}
