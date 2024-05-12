
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
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
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;

import net.mcreator.kraftmine.world.features.treedecorators.BackroomLevel0TrunkDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.BackroomLevel0LeaveDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.BackroomLevel0FruitDecorator;
import net.mcreator.kraftmine.init.KraftmineModEntities;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class BackroomLevel0Biome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-16777216).waterColor(-16777114).waterFogColor(-13369447).skyColor(-16777216).foliageColorOverride(-10066432).grassColorOverride(-10066432)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("kraftmine:ambient.backrooms"))).ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("kraftmine:mood.backrooms")), 12000, 8, 2))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.backrooms")), 12000, 24000, true)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:tree_backroom_level_0",
						FeatureUtils.register("kraftmine:tree_backroom_level_0", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.LIGHT.defaultBlockState()), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
										new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
										.decorators(ImmutableList.of(BackroomLevel0LeaveDecorator.INSTANCE, BackroomLevel0TrunkDecorator.INSTANCE, BackroomLevel0FruitDecorator.INSTANCE)).build()),
						List.of(CountPlacement.of(5), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_AMOGUS_BLUE.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_AMOGUS_GREEN.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_AMOGUS_GREY.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_AMOGUS.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_SHADE.get(), 8, 1, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.SIRENHEAD.get(), 1, 1, 1));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
