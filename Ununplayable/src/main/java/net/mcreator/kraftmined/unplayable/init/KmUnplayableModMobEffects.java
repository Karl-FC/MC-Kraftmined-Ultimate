
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.unplayable.potion.OiledMobEffect;
import net.mcreator.kraftmined.unplayable.potion.MilkedMobEffect;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, KmUnplayableMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> OILED = REGISTRY.register("oiled", () -> new OiledMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MILKED = REGISTRY.register("milked", () -> new MilkedMobEffect());
}
