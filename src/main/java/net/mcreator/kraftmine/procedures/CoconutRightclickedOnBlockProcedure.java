package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class CoconutRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y + 1, z), KraftmineModBlocks.COCONUT_BLOCK.get().defaultBlockState(), 3);
	}
}
