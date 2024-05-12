package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class MobFloatingEyeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.canSeeSkyFromBelowWater(new BlockPos(x, y, z)) && world.dayTime() < 13000) {
			entity.setSecondsOnFire(5);
			if (entity.isInWaterRainOrBubble()) {
				entity.clearFire();
			}
		}
	}
}
