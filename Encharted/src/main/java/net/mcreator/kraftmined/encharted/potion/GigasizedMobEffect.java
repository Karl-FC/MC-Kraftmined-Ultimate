
package net.mcreator.kraftmined.encharted.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmined.encharted.procedures.GigasizedEffectStartedappliedProcedure;

public class GigasizedMobEffect extends MobEffect {
	public GigasizedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6750157);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GigasizedEffectStartedappliedProcedure.execute(entity);
	}
}
