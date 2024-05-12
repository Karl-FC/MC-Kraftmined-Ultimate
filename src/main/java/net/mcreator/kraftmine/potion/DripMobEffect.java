
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.DripEffectStartedappliedProcedure;

public class DripMobEffect extends MobEffect {
	public DripMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.drip";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		DripEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
