
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.encharted.procedures.GigasizedEffectExpiresProcedure;
import net.mcreator.kraftmined.encharted.potion.MinimizedMobEffect;
import net.mcreator.kraftmined.encharted.potion.GigasizedMobEffect;
import net.mcreator.kraftmined.encharted.KmEnchartedMod;

@EventBusSubscriber
public class KmEnchartedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KmEnchartedMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> GIGASIZED = REGISTRY.register("gigasized", () -> new GigasizedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINIMIZED = REGISTRY.register("minimized", () -> new MinimizedMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(GIGASIZED)) {
			GigasizedEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MINIMIZED)) {
			GigasizedEffectExpiresProcedure.execute(entity);
		}
	}
}
