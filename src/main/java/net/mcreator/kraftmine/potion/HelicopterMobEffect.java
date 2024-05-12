
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.HelicopterOnEffectActiveTickProcedure;

public class HelicopterMobEffect extends MobEffect {
	public HelicopterMobEffect() {
		super(MobEffectCategory.HARMFUL, -7960954);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.helicopter";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		HelicopterOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
