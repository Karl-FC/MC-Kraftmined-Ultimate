
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.BurnhealOnEffectActiveTickProcedure;
import net.mcreator.kraftmine.procedures.BurnhealActiveTickConditionProcedure;

public class BurnhealMobEffect extends MobEffect {
	public BurnhealMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -52480);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return BurnhealActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BurnhealOnEffectActiveTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
