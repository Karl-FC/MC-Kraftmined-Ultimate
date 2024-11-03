package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmined.kombat.init.KmKombatModMobEffects;
import net.mcreator.kraftmined.kombat.init.KmKombatModItems;

public class RedstoneArmorReddedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ArmorLevel = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KmKombatModItems.REDSTONE_ARMOR_HELMET.get()) {
			ArmorLevel = ArmorLevel + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KmKombatModItems.REDSTONE_ARMOR_CHESTPLATE.get()) {
			ArmorLevel = ArmorLevel + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KmKombatModItems.REDSTONE_ARMOR_LEGGINGS.get()) {
			ArmorLevel = ArmorLevel + 1;
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KmKombatModItems.REDSTONE_ARMOR_BOOTS.get()) {
			ArmorLevel = ArmorLevel + 1;
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(KmKombatModMobEffects.REDED, 60, (int) ArmorLevel, false, false));
	}
}
