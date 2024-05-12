package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.StoneSpearThrownEntity;

public class StonespearProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new StoneSpearThrownEntity(KraftmineModEntities.STONE_SPEAR_THROWN.get(), _level);
			entityToSpawn.moveTo(x, y, z, immediatesourceentity.getYRot(), immediatesourceentity.getXRot());
			entityToSpawn.setYBodyRot(immediatesourceentity.getYRot());
			entityToSpawn.setYHeadRot(immediatesourceentity.getYRot());
			entityToSpawn.setDeltaMovement(0, 0, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
