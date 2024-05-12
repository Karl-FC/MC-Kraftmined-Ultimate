
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.GigaEffectEffectStartedappliedProcedure;
import net.mcreator.kraftmine.procedures.GigaEffectEffectExpiresProcedure;

public class GigaEffectMobEffect extends MobEffect {
	public GigaEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.giga_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GigaEffectEffectStartedappliedProcedure.execute(entity.level, entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		GigaEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
