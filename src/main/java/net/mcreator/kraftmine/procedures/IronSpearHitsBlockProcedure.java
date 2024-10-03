package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEntities;

public class IronSpearHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = KraftmineModEntities.IRON_SPEAR_ENTITY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(immediatesourceentity.getYRot());
				entityToSpawn.setYBodyRot(immediatesourceentity.getYRot());
				entityToSpawn.setYHeadRot(immediatesourceentity.getYRot());
				entityToSpawn.setXRot(immediatesourceentity.getXRot());
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
