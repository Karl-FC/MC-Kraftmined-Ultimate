package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) && !((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() instanceof LiquidBlock)
				&& !((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() instanceof LiquidBlock)
				&& (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("kraftmine:tropics")) || world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("beach")))) {
			return true;
		}
		return false;
	}
}
