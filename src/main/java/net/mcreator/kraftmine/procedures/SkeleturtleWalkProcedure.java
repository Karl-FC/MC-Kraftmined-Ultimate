package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

public class SkeleturtleWalkProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.isInWater()) {
			return true;
		}
		return false;
	}
}