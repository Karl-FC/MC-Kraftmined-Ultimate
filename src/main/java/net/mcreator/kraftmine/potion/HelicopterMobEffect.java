
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.HelicopterOnEffectActiveTickProcedure;

public class HelicopterMobEffect extends MobEffect {
	public HelicopterMobEffect() {
		super(MobEffectCategory.HARMFUL, -7960954);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		HelicopterOnEffectActiveTickProcedure.execute(entity);
	}
}
