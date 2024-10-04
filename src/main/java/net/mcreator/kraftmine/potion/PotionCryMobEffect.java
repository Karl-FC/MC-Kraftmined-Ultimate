
package net.mcreator.kraftmine.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.ProcedureCryProcedure;

public class PotionCryMobEffect extends MobEffect {
	public PotionCryMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ProcedureCryProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
