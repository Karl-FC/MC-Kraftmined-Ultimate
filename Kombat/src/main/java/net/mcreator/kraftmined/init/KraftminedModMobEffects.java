
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.potion.EyepatchEffectMobEffect;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KraftminedMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> EYEPATCH_EFFECT = REGISTRY.register("eyepatch_effect", () -> new EyepatchEffectMobEffect());
}
