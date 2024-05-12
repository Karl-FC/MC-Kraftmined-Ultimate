package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NoUAttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.NO_U.get()) : false) && !(sourceentity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.NO_U.get()) : false)) {
			damage = amount * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.NO_U.get()) ? _livEnt.getEffect(KraftmineModMobEffects.NO_U.get()).getAmplifier() : 0) * 0.25;
			sourceentity.hurt(DamageSource.MAGIC, (float) damage);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.MYCELIUM, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 1, 2, 3, 3, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, (entity.getX()), (entity.getY()), (entity.getZ()), 2, 2, 3, 3, 1);
		}
	}
}
