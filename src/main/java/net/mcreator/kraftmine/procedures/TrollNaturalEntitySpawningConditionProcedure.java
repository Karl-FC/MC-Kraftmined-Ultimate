package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TrollNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z)) && world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) < 2 && world.isEmptyBlock(new BlockPos(x, y, z)) && world.isEmptyBlock(new BlockPos(x, y + 1, z))) {
			return true;
		}
		return false;
	}
}
