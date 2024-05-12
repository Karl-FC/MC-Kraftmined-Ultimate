package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GiantSquidNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.WATER && (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.WATER
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == Blocks.WATER
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == Blocks.WATER
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == Blocks.WATER && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == Blocks.WATER
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == Blocks.WATER) {
			return true;
		}
		return false;
	}
}
