
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
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
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import net.mcreator.kraftmine.world.features.treedecorators.RobloxTrunkDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.RobloxLeaveDecorator;
import net.mcreator.kraftmine.world.features.treedecorators.RobloxFruitDecorator;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class RobloxBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(0.24f, 0.72f), Climate.Parameter.span(0.56f, 1.04f), Climate.Parameter.point(0.0f),
					Climate.Parameter.span(0.7103103971582909f, 1.190310397158291f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(-0.24f, 0.24f), Climate.Parameter.span(0.24f, 0.72f), Climate.Parameter.span(0.56f, 1.04f), Climate.Parameter.point(1.0f),
					Climate.Parameter.span(0.7103103971582909f, 1.190310397158291f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-16713985).waterColor(4159204).waterFogColor(329011).skyColor(-16713985).foliageColorOverride(-14709223).grassColorOverride(-5921371)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("kraftmine:music.terraria"))).backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.sweden.remix")), 12000, 24000, true)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:tree_roblox",
						FeatureUtils.register("kraftmine:tree_roblox", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_WOOD.defaultBlockState()), new ForkingTrunkPlacer(6, 2, 2), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
										new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
										.decorators(ImmutableList.of(RobloxLeaveDecorator.INSTANCE, RobloxTrunkDecorator.INSTANCE, RobloxFruitDecorator.INSTANCE)).build()),
						List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 10, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 7, 4, 4));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
