package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BuffedPassiveMobsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true && entity instanceof Animal) {
			if (Math.random() <= 0.1) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 3, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (Math.random() <= 0.05) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 9999, 3, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (Math.random() <= 0.05) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9999, 2, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (Math.random() <= 0.05) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9999, 3, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (Math.random() >= 0.9) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 2, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
		}
	}
}
