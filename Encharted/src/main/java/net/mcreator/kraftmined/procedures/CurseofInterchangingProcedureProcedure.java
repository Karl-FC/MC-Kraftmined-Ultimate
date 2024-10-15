package net.mcreator.kraftmined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CurseofInterchangingProcedureProcedure {
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
		double targetZ = 0;
		double targetY = 0;
		double userY = 0;
		double targetX = 0;
		double userZ = 0;
		double userX = 0;
		Entity user = null;
		Entity target = null;
		user = sourceentity;
		target = entity;
		if (!(target == user)) {
			userX = user.getX();
			userY = user.getY();
			userZ = user.getZ();
			targetX = target.getX();
			targetY = target.getY();
			targetZ = target.getZ();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(user.getX(), user.getY(), user.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((user.getX()), (user.getY()), (user.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				Entity _ent = user;
				_ent.teleportTo(targetX, targetY, targetZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(targetX, targetY, targetZ, _ent.getYRot(), _ent.getXRot());
			}
			{
				Entity _ent = target;
				_ent.teleportTo(userX, userY, userZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(userX, userY, userZ, _ent.getYRot(), _ent.getXRot());
			}
			if (target instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 1, false, false));
		} else if (target == user) {
			target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 5);
		}
	}
}
