package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GhostSpiderMutantWalkProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.AIR)) {
			return true;
		}
		return false;
	}
}
