
package net.mcreator.kraftmined.kombat.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmined.kombat.procedures.RedstoneArmorProcedureProcedure;

public class RededMobEffect extends MobEffect {
	public RededMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6750208);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		RedstoneArmorProcedureProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
