package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GlowShroomAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && false && world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("kraftmine:glow_shroom_biome"))) {
			return true;
		}
		return false;
	}
}
