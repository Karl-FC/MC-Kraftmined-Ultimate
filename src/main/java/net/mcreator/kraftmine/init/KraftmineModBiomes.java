
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import net.mcreator.kraftmine.world.biome.WastelandBiome;
import net.mcreator.kraftmine.world.biome.TropicsBiome;
import net.mcreator.kraftmine.world.biome.SakuraBiome;
import net.mcreator.kraftmine.world.biome.RobloxBiome;
import net.mcreator.kraftmine.world.biome.GlowShroomBiomeBiome;
import net.mcreator.kraftmine.world.biome.EerieBiome;
import net.mcreator.kraftmine.world.biome.DomainBiome;
import net.mcreator.kraftmine.world.biome.BackroomLevel0Biome;
import net.mcreator.kraftmine.world.biome.AetherBiomeBiome;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

import com.google.common.base.Suppliers;

@Mod.EventBusSubscriber
public class KraftmineModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, KraftmineMod.MODID);
	public static final RegistryObject<Biome> AETHER_BIOME = REGISTRY.register("aether_biome", AetherBiomeBiome::createBiome);
	public static final RegistryObject<Biome> WASTELAND = REGISTRY.register("wasteland", WastelandBiome::createBiome);
	public static final RegistryObject<Biome> EERIE = REGISTRY.register("eerie", EerieBiome::createBiome);
	public static final RegistryObject<Biome> SAKURA = REGISTRY.register("sakura", SakuraBiome::createBiome);
	public static final RegistryObject<Biome> ROBLOX = REGISTRY.register("roblox", RobloxBiome::createBiome);
	public static final RegistryObject<Biome> DOMAIN = REGISTRY.register("domain", DomainBiome::createBiome);
	public static final RegistryObject<Biome> TROPICS = REGISTRY.register("tropics", TropicsBiome::createBiome);
	public static final RegistryObject<Biome> BACKROOM_LEVEL_0 = REGISTRY.register("backroom_level_0", BackroomLevel0Biome::createBiome);
	public static final RegistryObject<Biome> GLOW_SHROOM_BIOME = REGISTRY.register("glow_shroom_biome", GlowShroomBiomeBiome::createBiome);

	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
		WorldGenSettings worldGenSettings = server.getWorldData().worldGenSettings();
		for (Map.Entry<ResourceKey<LevelStem>, LevelStem> entry : worldGenSettings.dimensions().entrySet()) {
			DimensionType dimensionType = entry.getValue().typeHolder().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = entry.getValue().generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters.values());
					for (Climate.ParameterPoint parameterPoint : WastelandBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, WASTELAND.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : EerieBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, EERIE.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : SakuraBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, SAKURA.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : RobloxBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, ROBLOX.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : TropicsBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, TROPICS.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : GlowShroomBiomeBiome.PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, GLOW_SHROOM_BIOME.getId()))));
					}
					for (Climate.ParameterPoint parameterPoint : GlowShroomBiomeBiome.UNDERGROUND_PARAMETER_POINTS) {
						parameters.add(new Pair<>(parameterPoint, biomeRegistry.getOrCreateHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, GLOW_SHROOM_BIOME.getId()))));
					}

					chunkGenerator.biomeSource = new MultiNoiseBiomeSource(new Climate.ParameterList<>(parameters), noiseSource.preset);
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						surfaceRules.add(1, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, GLOW_SHROOM_BIOME.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, WASTELAND.getId()), KraftmineModBlocks.COARSE_GRASS_BLOCK.get().defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(),
								Blocks.GRAVEL.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, EERIE.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, SAKURA.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, ROBLOX.getId()), KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState(), KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState(),
								KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, TROPICS.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
						surfaceRules.add(1, preliminarySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, GLOW_SHROOM_BIOME.getId()), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}

		}
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
								SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
						SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))));
	}
}
