
package net.mcreator.kraftmine.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.procedures.BleedEffectActiveTickConditionProcedure;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BleedEffectMobEffect extends MobEffect {
	public BleedEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -5634811);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BleedEffectActiveTickConditionProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, KraftmineModMobEffects.BLEED_EFFECT.get());
	}
}
