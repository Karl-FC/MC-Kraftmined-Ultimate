package net.mcreator.kraftmined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmined.init.KraftminedModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ArmorReflectDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftminedModItems.TITANIUM_ARMOR_HELMET.get()) {
			if (Math.random() < (1 / 4) * 0.15) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), Mth.nextInt(RandomSource.create(), 1, 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftminedModItems.TITANIUM_ARMOR_CHESTPLATE.get()) {
			if (Math.random() < (3 / 4) * 0.15) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), Mth.nextInt(RandomSource.create(), 1, 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftminedModItems.TITANIUM_ARMOR_LEGGINGS.get()) {
			if (Math.random() < (2 / 4) * 0.15) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), Mth.nextInt(RandomSource.create(), 1, 4));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftminedModItems.TITANIUM_ARMOR_BOOTS.get()) {
			if (Math.random() < (1 / 4) * 0.15) {
				sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), Mth.nextInt(RandomSource.create(), 1, 4));
			}
		}
	}
}
