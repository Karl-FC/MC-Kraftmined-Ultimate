
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, KraftminedMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ATTACK_METALPIPE = REGISTRY.register("entity.attack.metalpipe",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmined", "entity.attack.metalpipe")));
}
