
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
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
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import java.util.List;

public class WastelandBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-1.1102230246251565E-16f, 1.1999999999999997f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.07999999999999996f, 1.12f), Climate.Parameter.span(0.4f, 1.6f),
					Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.4139816399985157f, -0.2139816399985156f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-1.1102230246251565E-16f, 1.1999999999999997f), Climate.Parameter.span(-0.6f, 0.6f), Climate.Parameter.span(-0.07999999999999996f, 1.12f), Climate.Parameter.span(0.4f, 1.6f),
					Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.4139816399985157f, -0.2139816399985156f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-4827337).waterColor(-9683167).waterFogColor(-5602198).skyColor(-4827337).foliageColorOverride(-8948652).grassColorOverride(-8423387)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("ambient.basalt_deltas.loop"))).ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("kraftmine:mood.wastelands")), 6000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("ambient.basalt_deltas.additions")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.wasteland")), 12000, 24000, true)).ambientParticle(new AmbientParticleSettings(ParticleTypes.MYCELIUM, 0.096f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:grass_wasteland", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:brown_mushroom_wasteland", VegetationFeatures.PATCH_BROWN_MUSHROOM,
				List.of(CountPlacement.of(2), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("kraftmine:red_mushroom_wasteland", VegetationFeatures.PATCH_RED_MUSHROOM,
				List.of(CountPlacement.of(2), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:disk_sand_wasteland",
						FeatureUtils.register("kraftmine:disk_sand_wasteland", Feature.DISK,
								new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.SAND), BlockPredicate.matchesBlocks(List.of(KraftmineModBlocks.COARSE_GRASS_BLOCK.get(), Blocks.COARSE_DIRT)), UniformInt.of(2, 6), 2)),
						List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("kraftmine:disk_gravel_wasteland",
						FeatureUtils.register("kraftmine:disk_gravel_wasteland", Feature.DISK,
								new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(KraftmineModBlocks.COARSE_GRASS_BLOCK.get(), Blocks.COARSE_DIRT)), UniformInt.of(2, 5), 2)),
						List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 12, 3, 6));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.SIRENHEAD.get(), 5, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MOB_AMOGUS.get(), 8, 4, 8));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 12, 5, 10));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOGLIN, 10, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.VINDICATOR, 10, 4, 4));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.MIMIC_ENTITY.get(), 5, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_1.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_2.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_3.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_4.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_5.get(), 8, 1, 2));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_6.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_7.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_8.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_9.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_10.get(), 16, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(KraftmineModEntities.NEXTBOT_11.get(), 20, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 5, 10, 20));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(1.4f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
