package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock)
				&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock)
				&& (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("kraftmine:tropics")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("beach")))) {
			return true;
		}
		return false;
	}
}
