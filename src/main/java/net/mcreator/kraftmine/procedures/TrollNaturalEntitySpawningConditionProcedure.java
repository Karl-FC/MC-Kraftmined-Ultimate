package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TrollNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 2 && world.isEmptyBlock(BlockPos.containing(x, y, z))
				&& world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			return true;
		}
		return false;
	}
}
