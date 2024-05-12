package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GhostSpiderNightProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.canSeeSkyFromBelowWater(new BlockPos(x, y, z)) == true && world.dayTime() > 13000 || world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) < 12) {
			return true;
		}
		return false;
	}
}
