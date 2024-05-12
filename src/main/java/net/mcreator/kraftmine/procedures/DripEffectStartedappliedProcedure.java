package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class DripEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(KraftmineModMobEffects.JUMPSCARE_EFFECT.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(KraftmineModMobEffects.SUS.get());
	}
}
