package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

public class PenguinGuntherProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getDisplayName().getString()).equals("gunther") || (entity.getDisplayName().getString()).equals("Gunther") || (entity.getDisplayName().getString()).equals("Gunter") || (entity.getDisplayName().getString()).equals("gunter")) {
			return true;
		}
		return false;
	}
}
