
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.GhostlyEffectStartedappliedProcedure;
import net.mcreator.kraftmine.procedures.GhostlyEffectExpiresProcedure;

public class GhostlyMobEffect extends MobEffect {
	public GhostlyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6684724);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.ghostly";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GhostlyEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		GhostlyEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
