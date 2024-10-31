
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, KmUnplayableMod.MODID);
	public static final DeferredHolder<Potion, Potion> MILK_POTION = REGISTRY.register("milk_potion", () -> new Potion(new MobEffectInstance(KmUnplayableModMobEffects.MILKED, 200, 0, false, true)));
}
