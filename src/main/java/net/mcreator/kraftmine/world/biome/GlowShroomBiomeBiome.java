
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.kraftmine.world.features.treedecorators.GlowShroomBiomeTrunkDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.GlowShroomBiomeLeaveDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.GlowShroomBiomeFruitDecorator;
import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class GlowShroomBiomeBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666666666667f, 0.9333333333333332f), Climate.Parameter.span(-1.2f, 1.5999999999999999f), Climate.Parameter.span(-0.9199999999999999f, 1.88f),
					Climate.Parameter.span(-0.3999999999999999f, 2f), Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.5051180079562358f, 2f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666666666667f, 0.9333333333333332f), Climate.Parameter.span(-1.2f, 1.5999999999999999f), Climate.Parameter.span(-0.9199999999999999f, 1.88f),
					Climate.Parameter.span(-0.3999999999999999f, 2f), Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.5051180079562358f, 2f), 0));
	public static final List<Climate.ParameterPoint> UNDERGROUND_PARAMETER_POINTS = List.of(new Climate.ParameterPoint(Climate.Parameter.span(-1.8666666666666667f, 0.9333333333333332f), Climate.Parameter.span(-1.2f, 1.5999999999999999f),
			Climate.Parameter.span(-0.9199999999999999f, 1.88f), Climate.Parameter.span(-0.3999999999999999f, 2f), Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-0.5051180079562358f, 2f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-6684673).waterFogColor(-7342081).skyColor(7972607).foliageColorOverride(-13927575).grassColorOverride(-13944743)
				.ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("ambient.warped_forest.mood")), 6000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("ambient.warped_forest.additions")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.terraria")), 12000, 24000, true)).ambientParticle(new AmbientParticleSettings(ParticleTypes.MYCELIUM, 0.005f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:tree_glow_shroom_biome",
						FeatureUtils.register("kraftmine:tree_glow_shroom_biome", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(KraftmineModBlocks.GLOW_SHROOM.get().defaultBlockState()), new StraightTrunkPlacer(1, 2, 0),
										BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
										.decorators(ImmutableList.of(GlowShroomBiomeLeaveDecorator.INSTANCE, GlowShroomBiomeTrunkDecorator.INSTANCE, GlowShroomBiomeFruitDecorator.INSTANCE)).build()),
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:grass_glow_shroom_biome", VegetationFeatures.PATCH_GRASS,
				List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:seagrass_glow_shroom_biome", AquaticFeatures.SEAGRASS_SHORT, AquaticPlacements.seagrassPlacement(2)));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:flower_glow_shroom_biome", VegetationFeatures.FLOWER_DEFAULT,
				List.of(CountPlacement.of(20), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:brown_mushroom_glow_shroom_biome", VegetationFeatures.PATCH_BROWN_MUSHROOM,
				List.of(CountPlacement.of(20), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:red_mushroom_glow_shroom_biome", VegetationFeatures.PATCH_RED_MUSHROOM,
				List.of(CountPlacement.of(20), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:mushrooms_huge_glow_shroom_biome", VegetationFeatures.MUSHROOM_ISLAND_VEGETATION, List.of(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(KraftmineModEntities.GOOSE.get(), 8, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CAT, 7, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 10, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.BEE, 12, 3, 5));
		mobSpawnInfo.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 1, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.TROLL.get(), 15, 3, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.SIRENHEAD.get(), 4, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 15, 1, 4));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).temperature(-0.2f).downfall(0.6f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
