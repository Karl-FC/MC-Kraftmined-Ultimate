
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmine.KraftmineMod;

@EventBusSubscriber
public class KraftmineModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KraftmineMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> POTION_CRY = REGISTRY.register("potion_cry", () -> new PotionCryMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DRIP = REGISTRY.register("drip", () -> new DripMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JUMPSCARE_EFFECT = REGISTRY.register("jumpscare_effect", () -> new JumpscareEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEED_EFFECT = REGISTRY.register("bleed_effect", () -> new BleedEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> EYEPATCH_ON_EFFECT = REGISTRY.register("eyepatch_on_effect", () -> new EyepatchOnEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HELICOPTER = REGISTRY.register("helicopter", () -> new HelicopterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> THIRSTY = REGISTRY.register("thirsty", () -> new ThirstyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HYDRATED = REGISTRY.register("hydrated", () -> new RefreshedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUS = REGISTRY.register("sus", () -> new SusMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TIME_FREEZE = REGISTRY.register("time_freeze", () -> new TimeFreezeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SPLINTERED = REGISTRY.register("splintered", () -> new SplinteredMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ANTI_HEAL = REGISTRY.register("anti_heal", () -> new AntiHealMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GHOSTLY = REGISTRY.register("ghostly", () -> new GhostlyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> NO_U = REGISTRY.register("no_u", () -> new NoUMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SANITATION = REGISTRY.register("sanitation", () -> new SanitationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BURNHEAL = REGISTRY.register("burnheal", () -> new BurnhealMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BEASTMODE = REGISTRY.register("beastmode", () -> new BeastmodeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CONFUSION = REGISTRY.register("confusion", () -> new ConfusionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MILKED = REGISTRY.register("milked", () -> new MilkedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GIGA_EFFECT = REGISTRY.register("giga_effect", () -> new GigaEffectMobEffect());

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
		if (effectInstance.getEffect().is(POTION_CRY)) {
			RemoveCryProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(GHOSTLY)) {
			GhostlyEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MILKED)) {
			MilkedEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(GIGA_EFFECT)) {
			GigaEffectEffectExpiresProcedure.execute(entity);
		}
	}
}
