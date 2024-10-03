
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.TimeFreezeOnEffectActiveTickProcedure;
import net.mcreator.kraftmine.procedures.TimeFreezeEffectStartedappliedProcedure;

public class TimeFreezeMobEffect extends MobEffect {
	public TimeFreezeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10354847);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		TimeFreezeEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		TimeFreezeOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
