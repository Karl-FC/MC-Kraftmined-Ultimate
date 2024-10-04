package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

public class PenguinSwimProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.isInWater() && entity.getPersistentData().getDouble("air") >= 200) {
			return true;
		}
		return false;
	}
}
