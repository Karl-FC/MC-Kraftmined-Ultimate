package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class RockPotionPlayerFinishesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 2, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 600, 0, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 1, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 2, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 1, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.DRIP.get(), 3600, 0, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 1, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SUS.get(), 3600, 1, (false), (true)));
	}
}
