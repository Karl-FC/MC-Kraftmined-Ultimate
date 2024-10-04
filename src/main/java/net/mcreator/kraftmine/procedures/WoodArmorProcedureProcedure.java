package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class WoodArmorProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double chancemultiplier = 0;
		double seconds = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_HELMET.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_LEGGINGS.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_BOOTS.get()) {
			chancemultiplier = 0;
			seconds = seconds + 1;
			if (seconds >= 4) {
				seconds = 0;
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_HELMET.get()) {
					chancemultiplier = chancemultiplier + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_CHESTPLATE.get()) {
					chancemultiplier = chancemultiplier + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_LEGGINGS.get()) {
					chancemultiplier = chancemultiplier + 1;
				}
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_BOOTS.get()) {
					chancemultiplier = chancemultiplier + 1;
				}
				if (Math.random() <= 0.02 * chancemultiplier) {
					for (int index0 = 0; index0 < 2; index0++) {
						entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SPLINTERED, 100, 1, false, false));
				}
			}
		}
	}
}
