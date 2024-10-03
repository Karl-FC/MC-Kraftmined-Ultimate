
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmine.world.features.SupplyCrateFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmtinyFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmtallFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmsmallFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmminiFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmmidFeatureFeature;
import net.mcreator.kraftmine.world.features.PalmbentFeatureFeature;
import net.mcreator.kraftmine.world.features.GlowShroomFeatureFeature;
import net.mcreator.kraftmine.world.features.BkbaseFeatureFeature;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, KraftmineMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMTALL_FEATURE = REGISTRY.register("palmtall_feature", PalmtallFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMSMALL_FEATURE = REGISTRY.register("palmsmall_feature", PalmsmallFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMBENT_FEATURE = REGISTRY.register("palmbent_feature", PalmbentFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMTINY_FEATURE = REGISTRY.register("palmtiny_feature", PalmtinyFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMMINI_FEATURE = REGISTRY.register("palmmini_feature", PalmminiFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PALMMID_FEATURE = REGISTRY.register("palmmid_feature", PalmmidFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BKBASE_FEATURE = REGISTRY.register("bkbase_feature", BkbaseFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SUPPLY_CRATE_FEATURE = REGISTRY.register("supply_crate_feature", SupplyCrateFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GLOW_SHROOM_FEATURE = REGISTRY.register("glow_shroom_feature", GlowShroomFeatureFeature::new);
}
