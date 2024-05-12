package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

public class AcidMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		AcidProcedureProcedure.execute(entity);
	}
}
