package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;

public class BkbaseAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double y) {
		if (y == world.getLevelData().getYSpawn()) {
			return true;
		}
		return false;
	}
}
