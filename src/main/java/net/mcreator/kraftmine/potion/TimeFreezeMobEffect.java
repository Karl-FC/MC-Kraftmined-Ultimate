
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
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
	public String getDescriptionId() {
		return "effect.kraftmine.time_freeze";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TimeFreezeEffectStartedappliedProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeFreezeOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
