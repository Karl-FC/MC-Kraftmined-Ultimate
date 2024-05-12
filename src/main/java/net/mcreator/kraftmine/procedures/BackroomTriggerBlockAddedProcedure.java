package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class BackroomTriggerBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level)
			_level.updateNeighborsAt(new BlockPos(x, y, z), _level.getBlockState(new BlockPos(x, y, z)).getBlock());
	}
}
