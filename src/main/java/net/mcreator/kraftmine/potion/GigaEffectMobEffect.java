
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.GigaEffectEffectStartedappliedProcedure;

public class GigaEffectMobEffect extends MobEffect {
	public GigaEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GigaEffectEffectStartedappliedProcedure.execute(entity.level(), entity);
	}
}
