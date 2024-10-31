package net.mcreator.kraftmined.encharted.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmined.encharted.init.KmEnchartedModMobEffects;
import net.mcreator.kraftmined.encharted.init.KmEnchartedModAttributes;

public class GigasizedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity2.getAttribute(Attributes.SCALE).setBaseValue(
					((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(KmEnchartedModAttributes.BASE_SCALE) ? _livingEntity0.getAttribute(KmEnchartedModAttributes.BASE_SCALE).getBaseValue() : 0)
							+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KmEnchartedModMobEffects.GIGASIZED) ? _livEnt.getEffect(KmEnchartedModMobEffects.GIGASIZED).getAmplifier() : 0) + 1));
	}
}
