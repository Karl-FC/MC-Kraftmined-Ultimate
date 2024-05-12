
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.kraftmine.world.features.plants.TomatoBushFeature;
import net.mcreator.kraftmine.world.features.plants.TomatoBush3Feature;
import net.mcreator.kraftmine.world.features.plants.TomatoBush2Feature;
import net.mcreator.kraftmine.world.features.plants.TomatoBush1Feature;
import net.mcreator.kraftmine.world.features.plants.IrisSilverFeature;
import net.mcreator.kraftmine.world.features.plants.IrisPurpleFeature;
import net.mcreator.kraftmine.world.features.plants.GlowShroomFeature;
import net.mcreator.kraftmine.world.features.plants.CornCrop2Feature;
import net.mcreator.kraftmine.world.features.plants.CornCrop1Feature;
import net.mcreator.kraftmine.world.features.plants.CornCrop0Feature;
import net.mcreator.kraftmine.world.features.ores.WallBlockFeature;
import net.mcreator.kraftmine.world.features.ores.TungstenOreFeature;
import net.mcreator.kraftmine.world.features.ores.TitaniumOreFeature;
import net.mcreator.kraftmine.world.features.ores.SupplyCrateFeature;
import net.mcreator.kraftmine.world.features.ores.SaphhireOreFeature;
import net.mcreator.kraftmine.world.features.ores.RubyOreFeature;
import net.mcreator.kraftmine.world.features.ores.PlasticOreFeature;
import net.mcreator.kraftmine.world.features.ores.NickelOreFeature;
import net.mcreator.kraftmine.world.features.ores.MoltenObsidianFeature;
import net.mcreator.kraftmine.world.features.ores.LuckyBlockFeature;
import net.mcreator.kraftmine.world.features.ores.LifeOrbFeature;
import net.mcreator.kraftmine.world.features.ores.EmptyLanternFeature;
import net.mcreator.kraftmine.world.features.ores.DomainBarrierFeature;
import net.mcreator.kraftmine.world.features.ores.DeepslateTungstenOreFeature;
import net.mcreator.kraftmine.world.features.ores.DeepslateTitaniumOreFeature;
import net.mcreator.kraftmine.world.features.ores.CloudSapphireOreFeature;
import net.mcreator.kraftmine.world.features.ores.CloudRubyOreFeature;
import net.mcreator.kraftmine.world.features.ores.AluminumOreFeature;
import net.mcreator.kraftmine.world.features.ores.AetherancientdebrisFeature;
import net.mcreator.kraftmine.world.features.PalmtinyFeature;
import net.mcreator.kraftmine.world.features.PalmtallFeature;
import net.mcreator.kraftmine.world.features.PalmsmallFeature;
import net.mcreator.kraftmine.world.features.PalmminiFeature;
import net.mcreator.kraftmine.world.features.PalmmidFeature;
import net.mcreator.kraftmine.world.features.PalmbentFeature;
import net.mcreator.kraftmine.world.features.MahoganyTreeFeature;
import net.mcreator.kraftmine.world.features.GraveyardFeature;
import net.mcreator.kraftmine.world.features.BkbaseFeature;
import net.mcreator.kraftmine.world.features.AcidFeatureFeature;
import net.mcreator.kraftmine.KraftmineMod;

@Mod.EventBusSubscriber
public class KraftmineModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, KraftmineMod.MODID);
	public static final RegistryObject<Feature<?>> TUNGSTEN_ORE = REGISTRY.register("tungsten_ore", TungstenOreFeature::feature);
	public static final RegistryObject<Feature<?>> CLOUD_SAPPHIRE_ORE = REGISTRY.register("cloud_sapphire_ore", CloudSapphireOreFeature::feature);
	public static final RegistryObject<Feature<?>> CLOUD_RUBY_ORE = REGISTRY.register("cloud_ruby_ore", CloudRubyOreFeature::feature);
	public static final RegistryObject<Feature<?>> AETHERANCIENTDEBRIS = REGISTRY.register("aetherancientdebris", AetherancientdebrisFeature::feature);
	public static final RegistryObject<Feature<?>> NICKEL_ORE = REGISTRY.register("nickel_ore", NickelOreFeature::feature);
	public static final RegistryObject<Feature<?>> ALUMINUM_ORE = REGISTRY.register("aluminum_ore", AluminumOreFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPSLATE_TUNGSTEN_ORE = REGISTRY.register("deepslate_tungsten_ore", DeepslateTungstenOreFeature::feature);
	public static final RegistryObject<Feature<?>> TITANIUM_ORE = REGISTRY.register("titanium_ore", TitaniumOreFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPSLATE_TITANIUM_ORE = REGISTRY.register("deepslate_titanium_ore", DeepslateTitaniumOreFeature::feature);
	public static final RegistryObject<Feature<?>> RUBY_ORE = REGISTRY.register("ruby_ore", RubyOreFeature::feature);
	public static final RegistryObject<Feature<?>> SAPHHIRE_ORE = REGISTRY.register("saphhire_ore", SaphhireOreFeature::feature);
	public static final RegistryObject<Feature<?>> WALL_BLOCK = REGISTRY.register("wall_block", WallBlockFeature::feature);
	public static final RegistryObject<Feature<?>> LIFE_ORB = REGISTRY.register("life_orb", LifeOrbFeature::feature);
	public static final RegistryObject<Feature<?>> LUCKY_BLOCK = REGISTRY.register("lucky_block", LuckyBlockFeature::feature);
	public static final RegistryObject<Feature<?>> DOMAIN_BARRIER = REGISTRY.register("domain_barrier", DomainBarrierFeature::feature);
	public static final RegistryObject<Feature<?>> SUPPLY_CRATE = REGISTRY.register("supply_crate", SupplyCrateFeature::feature);
	public static final RegistryObject<Feature<?>> GLOW_SHROOM = REGISTRY.register("glow_shroom", GlowShroomFeature::feature);
	public static final RegistryObject<Feature<?>> MOLTEN_OBSIDIAN = REGISTRY.register("molten_obsidian", MoltenObsidianFeature::feature);
	public static final RegistryObject<Feature<?>> EMPTY_LANTERN = REGISTRY.register("empty_lantern", EmptyLanternFeature::feature);
	public static final RegistryObject<Feature<?>> PLASTIC_ORE = REGISTRY.register("plastic_ore", PlasticOreFeature::feature);
	public static final RegistryObject<Feature<?>> MAHOGANY_TREE = REGISTRY.register("mahogany_tree", MahoganyTreeFeature::feature);
	public static final RegistryObject<Feature<?>> PALMTALL = REGISTRY.register("palmtall", PalmtallFeature::feature);
	public static final RegistryObject<Feature<?>> PALMSMALL = REGISTRY.register("palmsmall", PalmsmallFeature::feature);
	public static final RegistryObject<Feature<?>> PALMBENT = REGISTRY.register("palmbent", PalmbentFeature::feature);
	public static final RegistryObject<Feature<?>> PALMTINY = REGISTRY.register("palmtiny", PalmtinyFeature::feature);
	public static final RegistryObject<Feature<?>> PALMMINI = REGISTRY.register("palmmini", PalmminiFeature::feature);
	public static final RegistryObject<Feature<?>> PALMMID = REGISTRY.register("palmmid", PalmmidFeature::feature);
	public static final RegistryObject<Feature<?>> GRAVEYARD = REGISTRY.register("graveyard", GraveyardFeature::feature);
	public static final RegistryObject<Feature<?>> BKBASE = REGISTRY.register("bkbase", BkbaseFeature::feature);
	public static final RegistryObject<Feature<?>> CORN_CROP_0 = REGISTRY.register("corn_crop_0", CornCrop0Feature::feature);
	public static final RegistryObject<Feature<?>> CORN_CROP_1 = REGISTRY.register("corn_crop_1", CornCrop1Feature::feature);
	public static final RegistryObject<Feature<?>> CORN_CROP_2 = REGISTRY.register("corn_crop_2", CornCrop2Feature::feature);
	public static final RegistryObject<Feature<?>> TOMATO_BUSH = REGISTRY.register("tomato_bush", TomatoBushFeature::feature);
	public static final RegistryObject<Feature<?>> TOMATO_BUSH_1 = REGISTRY.register("tomato_bush_1", TomatoBush1Feature::feature);
	public static final RegistryObject<Feature<?>> TOMATO_BUSH_2 = REGISTRY.register("tomato_bush_2", TomatoBush2Feature::feature);
	public static final RegistryObject<Feature<?>> TOMATO_BUSH_3 = REGISTRY.register("tomato_bush_3", TomatoBush3Feature::feature);
	public static final RegistryObject<Feature<?>> ACID_FEATURE = REGISTRY.register("acid_feature", AcidFeatureFeature::new);
	public static final RegistryObject<Feature<?>> IRIS_PURPLE = REGISTRY.register("iris_purple", IrisPurpleFeature::feature);
	public static final RegistryObject<Feature<?>> IRIS_SILVER = REGISTRY.register("iris_silver", IrisSilverFeature::feature);
}
