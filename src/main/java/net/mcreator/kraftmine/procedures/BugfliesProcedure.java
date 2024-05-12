package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;

public class BugfliesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomCHance = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double Fireflycount = 0;
		if (!world.isClientSide()) {
			randomCHance = Math.random();
		}
		if (randomCHance >= 0.98) {
			if (!(world instanceof Level _lvl && _lvl.isDay()) && (entity.level.dimension()) == (Level.OVERWORLD)) {
				posX = x - 16;
				posY = y - 16;
				posZ = z - 16;
				for (int index0 = 0; index0 < (int) (33); index0++) {
					for (int index1 = 0; index1 < (int) (33); index1++) {
						for (int index2 = 0; index2 < (int) (33); index2++) {
							if ((world.getBlockState(new BlockPos(posX, posY, posZ))).is(BlockTags.create(new ResourceLocation("kraftmine:bug_lights")))
									&& (world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:has_structure/village_plains")))
											|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_mountain")))
											|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_forest"))))
									&& world.canSeeSkyFromBelowWater(new BlockPos(posX, posY, posZ))) {
								Fireflycount = Mth.nextInt(RandomSource.create(), 1, 3);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.BUGS.get()), posX, posY, posZ, (int) Fireflycount, 1.2, 1.2, 1.2, 0.2);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.BUGS.get()), posX, posY, posZ, (int) Fireflycount, 1.2, 1.2, 1.2, 0.2);
							}
							posX = posX + 1;
						}
						posX = x - 16;
						posZ = posZ + 1;
					}
					posX = x - 16;
					posZ = z - 16;
					posY = posY + 1;
				}
			}
		}
	}
}
