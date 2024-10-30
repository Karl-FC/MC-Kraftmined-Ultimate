package net.mcreator.kraftmined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FlyingSquidNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
	}
}
