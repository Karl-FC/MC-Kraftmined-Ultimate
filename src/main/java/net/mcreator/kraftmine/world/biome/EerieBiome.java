
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import net.mcreator.kraftmine.world.features.treedecorators.EerieFruitDecorator;
import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class EerieBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.6666666666666667f, 1.3333333333333333f), Climate.Parameter.span(-0.6000000000000001f, 1.4f), Climate.Parameter.span(-0.49f, 1.51f), Climate.Parameter.span(-0.19999999999999996f, 1.8f),
					Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.22349175447375114f, 1.7765082455262489f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.6666666666666667f, 1.3333333333333333f), Climate.Parameter.span(-0.6000000000000001f, 1.4f), Climate.Parameter.span(-0.49f, 1.51f), Climate.Parameter.span(-0.19999999999999996f, 1.8f),
					Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.22349175447375114f, 1.7765082455262489f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-12960964).waterColor(-8419183).waterFogColor(-8879977).skyColor(-12960964).foliageColorOverride(-13618649).grassColorOverride(-13025996)
				.ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("kraftmine:ambient.eerie")), 20000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("ambient.cave")), 0.0111D)).backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.eerie")), 12000, 24000, true)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:tree_eerie",
						FeatureUtils.register("kraftmine:tree_eerie", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(KraftmineModBlocks.DEADWOOD_LOG.get().defaultBlockState()), new ForkingTrunkPlacer(7, 2, 2),
										BlockStateProvider.simple(KraftmineModBlocks.DEADWOOD_LEAVES.get().defaultBlockState()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
										.decorators(ImmutableList.of(

												EerieFruitDecorator.INSTANCE))
										.build()),
						List.of(CountPlacement.of(20), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:grass_eerie", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:disk_gravel_eerie",
						FeatureUtils.register("kraftmine:disk_gravel_eerie", Feature.DISK,
								new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)), UniformInt.of(2, 5), 2)),
						List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDesertVegetation(biomeGenerationSettings);
		BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addExtraEmeralds(biomeGenerationSettings);
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.GHOST_SPIDER.get(), 20, 1, 5));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.SIRENHEAD.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MIMIC_ENTITY.get(), 20, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 20, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.VINDICATOR, 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 20, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 20, 2, 3));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(1f).downfall(0.7f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
