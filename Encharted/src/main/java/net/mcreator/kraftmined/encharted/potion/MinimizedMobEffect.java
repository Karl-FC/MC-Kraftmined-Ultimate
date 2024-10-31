
package net.mcreator.kraftmined.encharted.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmined.encharted.procedures.MinimizedEffectStartedappliedProcedure;

public class MinimizedMobEffect extends MobEffect {
	public MinimizedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737946);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MinimizedEffectStartedappliedProcedure.execute(entity);
	}
}
