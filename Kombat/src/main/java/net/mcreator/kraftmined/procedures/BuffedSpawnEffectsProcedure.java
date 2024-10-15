package net.mcreator.kraftmined.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmined.init.KraftminedModAttributes;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.Effect;

@EventBusSubscriber
public class BuffedSpawnEffectsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double Effect = 0;
		double Enhancement = 0;
		if (Math.random() <= 0.1) {
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(KraftminedModAttributes.ENHANCED))
				_livingEntity0.getAttribute(KraftminedModAttributes.ENHANCED).setBaseValue(1);
			Effect = Mth.nextInt(RandomSource.create(), 1, 10);
			if (Math.random() >= 0.05) {
				if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(KraftminedModAttributes.ENHANCED))
					_livingEntity2.getAttribute(KraftminedModAttributes.ENHANCED).setBaseValue(2);
				if (Math.random() >= 0.05) {
					if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(KraftminedModAttributes.ENHANCED))
						_livingEntity3.getAttribute(KraftminedModAttributes.ENHANCED).setBaseValue(3);
				}
			}
			Enhancement = entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(KraftminedModAttributes.ENHANCED) ? _livingEntity4.getAttribute(KraftminedModAttributes.ENHANCED).getBaseValue() : 0;
			if (Effect == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9999, (int) Enhancement, false, false));
			}
			if (Effect == 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, (int) Enhancement, false, false));
			}
			if (Effect == 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 9999, (int) Enhancement, false, false));
			}
			if (Effect == 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9999, (int) Enhancement, false, true));
			}
			if (Effect == 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, (int) Enhancement, false, true));
			}
		}
	}
}
