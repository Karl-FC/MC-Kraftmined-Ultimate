package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModItems;

public class CondensedArmorProcedureTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double chancemultiplier = 0;
		double seconds = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.CONDENSED_ARMOR_HELMET.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.CONDENSED_ARMOR_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.CONDENSED_ARMOR_LEGGINGS.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.CONDENSED_ARMOR_BOOTS.get()) {
			if (entity.isOnFire()) {
				entity.clearFire();
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.isFallFlying() : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 1, (false), (false)));
			}
		}
	}
}
