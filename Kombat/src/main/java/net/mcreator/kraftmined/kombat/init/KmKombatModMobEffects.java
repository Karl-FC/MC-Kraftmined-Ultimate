
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.kombat.potion.EyepatchEffectMobEffect;
import net.mcreator.kraftmined.kombat.KmKombatMod;

public class KmKombatModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KmKombatMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> EYEPATCH_EFFECT = REGISTRY.register("eyepatch_effect", () -> new EyepatchEffectMobEffect());
}
