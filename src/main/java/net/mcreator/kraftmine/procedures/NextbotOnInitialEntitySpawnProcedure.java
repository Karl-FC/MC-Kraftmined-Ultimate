package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.kraftmine.entity.Nextbot9Entity;
import net.mcreator.kraftmine.entity.Nextbot8Entity;
import net.mcreator.kraftmine.entity.Nextbot7Entity;
import net.mcreator.kraftmine.entity.Nextbot6Entity;
import net.mcreator.kraftmine.entity.Nextbot5Entity;
import net.mcreator.kraftmine.entity.Nextbot4Entity;
import net.mcreator.kraftmine.entity.Nextbot3Entity;
import net.mcreator.kraftmine.entity.Nextbot2Entity;
import net.mcreator.kraftmine.entity.Nextbot1Entity;
import net.mcreator.kraftmine.entity.Nextbot11Entity;
import net.mcreator.kraftmine.entity.Nextbot10Entity;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

import java.lang.reflect.Type;

@Mod.EventBusSubscriber
public class NextbotOnInitialEntitySpawnProcedure {
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
		double Type = 0;
		double Variance = 0;
		if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:nextbot_tags")))) {
			if (entity instanceof Nextbot1Entity) {
				entity.getPersistentData().putDouble("BotVariant", 1);
			} else if (entity instanceof Nextbot2Entity) {
				entity.getPersistentData().putDouble("BotVariant", 2);
			} else if (entity instanceof Nextbot3Entity) {
				entity.getPersistentData().putDouble("BotVariant", 3);
			} else if (entity instanceof Nextbot4Entity) {
				entity.getPersistentData().putDouble("BotVariant", 4);
			} else if (entity instanceof Nextbot5Entity) {
				entity.getPersistentData().putDouble("BotVariant", 5);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 1, (false), (false)));
			} else if (entity instanceof Nextbot6Entity) {
				entity.getPersistentData().putDouble("BotVariant", 6);
			} else if (entity instanceof Nextbot7Entity) {
				entity.getPersistentData().putDouble("BotVariant", 7);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999, 0, (false), (false)));
			} else if (entity instanceof Nextbot8Entity) {
				entity.getPersistentData().putDouble("BotVariant", 8);
			} else if (entity instanceof Nextbot9Entity) {
				entity.getPersistentData().putDouble("BotVariant", 9);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999, 1, (false), (false)));
			} else if (entity instanceof Nextbot10Entity) {
				entity.getPersistentData().putDouble("BotVariant", 10);
			} else if (entity instanceof Nextbot11Entity) {
				entity.getPersistentData().putDouble("BotVariant", 11);
			}
			KraftmineMod.queueServerWork(5, () -> {
				if (Math.random() >= 0.7 && !(entity.getPersistentData().getDouble("BotVariant") == 8)) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 9999, Mth.nextInt(RandomSource.create(), 1, 5), (false), (false)));
				}
			});
		}
	}
}
