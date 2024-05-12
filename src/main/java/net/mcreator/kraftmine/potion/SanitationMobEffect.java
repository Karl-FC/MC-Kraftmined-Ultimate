
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.SanitationOnEffectActiveTickProcedure;
import net.mcreator.kraftmine.procedures.SanitationActiveTickConditionProcedure;

public class SanitationMobEffect extends MobEffect {
	public SanitationMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16724737);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.sanitation";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SanitationOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return SanitationActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
