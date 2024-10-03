
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

import com.google.common.base.Suppliers;

@EventBusSubscriber
public class KraftmineModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			DimensionType dimensionType = levelStem.type().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters,
							new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0f, 1.2f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.08f, 1.12f), Climate.Parameter.span(0.4f, 1.6f), Climate.Parameter.point(0.0f),
									Climate.Parameter.span(-1.41398164f, -0.21398164f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "wasteland")))));
					addParameterPoint(parameters,
							new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0f, 1.2f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.08f, 1.12f), Climate.Parameter.span(0.4f, 1.6f), Climate.Parameter.point(1.0f),
									Climate.Parameter.span(-1.41398164f, -0.21398164f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "wasteland")))));
					addParameterPoint(parameters,
							new Pair<>(
									new Climate.ParameterPoint(Climate.Parameter.span(-0.6666666667f, 1.3333333333f), Climate.Parameter.span(-0.6f, 1.4f), Climate.Parameter.span(-0.49f, 1.51f), Climate.Parameter.span(-0.2f, 1.8f),
											Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.2234917545f, 1.7765082455f), 0),
									biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "eerie")))));
					addParameterPoint(parameters,
							new Pair<>(
									new Climate.ParameterPoint(Climate.Parameter.span(-0.6666666667f, 1.3333333333f), Climate.Parameter.span(-0.6f, 1.4f), Climate.Parameter.span(-0.49f, 1.51f), Climate.Parameter.span(-0.2f, 1.8f),
											Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.2234917545f, 1.7765082455f), 0),
									biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "eerie")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 1.7333333333f), Climate.Parameter.span(-1.8f, 2f), Climate.Parameter.span(-1.5f, 2f), Climate.Parameter.span(-1f, 2f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.0712255037f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "sakura")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 1.7333333333f), Climate.Parameter.span(-1.8f, 2f), Climate.Parameter.span(-1.5f, 2f), Climate.Parameter.span(-1f, 2f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.0712255037f, 2f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "sakura")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(0.24f, 0.72f), Climate.Parameter.span(0.56f, 1.04f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.7103103972f, 1.1903103972f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "roblox")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(0.24f, 0.72f), Climate.Parameter.span(0.56f, 1.04f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.7103103972f, 1.1903103972f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "roblox")))));
					addParameterPoint(parameters,
							new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.8f, 1.2f), Climate.Parameter.span(-0.35f, 1.65f), Climate.Parameter.span(-0.3f, 1.7f), Climate.Parameter.point(0.0f),
									Climate.Parameter.span(-1.4270117639f, 0.5729882361f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "tropics")))));
					addParameterPoint(parameters,
							new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.8f, 1.2f), Climate.Parameter.span(-0.35f, 1.65f), Climate.Parameter.span(-0.3f, 1.7f), Climate.Parameter.point(1.0f),
									Climate.Parameter.span(-1.4270117639f, 0.5729882361f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "tropics")))));
					addParameterPoint(parameters,
							new Pair<>(
									new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666667f, 0.9333333333f), Climate.Parameter.span(-1.2f, 1.6f), Climate.Parameter.span(-0.92f, 1.88f), Climate.Parameter.span(-0.4f, 2f),
											Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.505118008f, 2f), 0),
									biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "glow_shroom_biome")))));
					addParameterPoint(parameters,
							new Pair<>(
									new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666667f, 0.9333333333f), Climate.Parameter.span(-1.2f, 1.6f), Climate.Parameter.span(-0.92f, 1.88f), Climate.Parameter.span(-0.4f, 2f),
											Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.505118008f, 2f), 0),
									biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "glow_shroom_biome")))));
					addParameterPoint(parameters,
							new Pair<>(
									new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666667f, 0.9333333333f), Climate.Parameter.span(-1.2f, 1.6f), Climate.Parameter.span(-0.92f, 1.88f), Climate.Parameter.span(-0.4f, 2f),
											Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-0.505118008f, 2f), 0),
									biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "glow_shroom_biome")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 1, anySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "glow_shroom_biome")), Blocks.GRASS_BLOCK.defaultBlockState(),
								Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "wasteland")), KraftmineModBlocks.COARSE_GRASS_BLOCK.get().defaultBlockState(),
								Blocks.COARSE_DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "eerie")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.DIRT.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "sakura")), Blocks.GRASS_BLOCK.defaultBlockState(),
								Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "roblox")), KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState(),
								KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState(), KraftmineModBlocks.LEGO_BLOCK.get().defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "tropics")), Blocks.GRASS_BLOCK.defaultBlockState(),
								Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("kraftmine", "glow_shroom_biome")), Blocks.GRASS_BLOCK.defaultBlockState(),
								Blocks.DIRT.defaultBlockState(), Blocks.STONE.defaultBlockState()));
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

	private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
		if (!parameters.contains(point))
			parameters.add(point);
	}

	private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
		if (!surfaceRules.contains(rule))
			surfaceRules.add(index, rule);
	}
}
