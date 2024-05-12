package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class GigaPotionFinishesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.GIGA_EFFECT.get(), 2100, 0, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 4, (false), (true)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2400, 0, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.DRIP.get(), 2400, 0, (false), (false)));
	}
}
