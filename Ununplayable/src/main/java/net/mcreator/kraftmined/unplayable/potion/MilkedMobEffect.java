
package net.mcreator.kraftmined.unplayable.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmined.unplayable.procedures.MilkedEffectStartedappliedProcedure;

import java.util.Set;

public class MilkedMobEffect extends MobEffect {
	public MilkedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MilkedEffectStartedappliedProcedure.execute(entity);
	}
}
