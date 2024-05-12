package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.kraftmine.init.KraftmineModGameRules;

public class SupplyCrateAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.SUPPLIES) == true) {
			return true;
		}
		return false;
	}
}
