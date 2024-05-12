package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GlowShroomAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z)) && (world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR
				&& world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("kraftmine:glow_shroom_biome"))) {
			return true;
		}
		return false;
	}
}
