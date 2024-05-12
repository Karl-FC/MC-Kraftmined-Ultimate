
package net.mcreator.kraftmine.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.BleedEffectActiveTickConditionProcedure;

public class BleedEffectMobEffect extends MobEffect {
	public BleedEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -5634811);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.bleed_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BleedEffectActiveTickConditionProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
