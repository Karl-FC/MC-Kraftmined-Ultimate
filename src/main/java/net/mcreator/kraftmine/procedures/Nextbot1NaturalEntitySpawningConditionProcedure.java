package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

public class Nextbot1NaturalEntitySpawningConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:barrens")))) || !world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("kraftmine:wasteland"))) {
			if (Math.random() <= 0.999) {
				if (!entity.level.isClientSide())
					entity.discard();
			}
		}
	}
}
