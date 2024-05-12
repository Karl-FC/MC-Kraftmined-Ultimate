package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BuffedMobsPotionProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (y - 1), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (y - 1), z, _ent.getYRot(), _ent.getXRot());
				}
				if (Math.random() < 0.1) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9999, 0, (false), (false)));
				}
				if (Math.random() < 0.1) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 0, (false), (false)));
					entity.getPersistentData().putBoolean("isBuffed", (true));
				}
				if (Math.random() < 0.1) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 9999, 2, (false), (true)));
				}
				if (Math.random() < 0.05) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 2, (false), (true)));
				}
				if (Math.random() < 0.01) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 1, (false), (false)));
				}
				if (Math.random() < 0.001) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 2, (false), (true)));
				}
				if (Math.random() < 0.001) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 3, (false), (true)));
				}
			}
		}
	}
}
