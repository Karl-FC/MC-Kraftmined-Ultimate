package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

public class HydroArmorBodyTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isOnFire()) {
			entity.clearFire();
		}
	}
}
