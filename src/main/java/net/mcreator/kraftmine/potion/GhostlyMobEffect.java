
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.GhostlyEffectStartedappliedProcedure;

public class GhostlyMobEffect extends MobEffect {
	public GhostlyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6684724);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GhostlyEffectStartedappliedProcedure.execute(entity);
	}
}
