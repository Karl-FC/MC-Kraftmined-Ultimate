package net.mcreator.kraftmined.unplayable.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmined.unplayable.init.KmUnplayableModMobEffects;

public class MilkMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(KmUnplayableModMobEffects.MILKED, 60, 1, false, false));
	}
}
