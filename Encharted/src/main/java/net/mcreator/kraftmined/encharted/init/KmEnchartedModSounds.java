
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.encharted.KmEnchartedMod;

public class KmEnchartedModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, KmEnchartedMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ATTACK_METALPIPE = REGISTRY.register("entity.attack.metalpipe",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("km_encharted", "entity.attack.metalpipe")));
}
