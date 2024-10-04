
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.DripEffectStartedappliedProcedure;

public class DripMobEffect extends MobEffect {
	public DripMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16777216);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		DripEffectStartedappliedProcedure.execute(entity);
	}
}
