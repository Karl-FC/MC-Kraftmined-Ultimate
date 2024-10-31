
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.encharted.KmEnchartedMod;

public class KmEnchartedModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, KmEnchartedMod.MODID);
	public static final DeferredHolder<Potion, Potion> POTION_BIG = REGISTRY.register("potion_big", () -> new Potion(new MobEffectInstance(KmEnchartedModMobEffects.GIGASIZED, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> POTION_SMALL = REGISTRY.register("potion_small", () -> new Potion(new MobEffectInstance(KmEnchartedModMobEffects.MINIMIZED, 3600, 0, false, true)));
}
