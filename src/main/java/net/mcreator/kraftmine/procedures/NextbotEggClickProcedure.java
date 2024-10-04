package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEntities;

public class NextbotEggClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Type = 0;
		double Variance = 0;
		Variance = Mth.nextInt(RandomSource.create(), 1, 11);
		if (Variance == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_1.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_2.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_3.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 4) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_4.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 5) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_11.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 6) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_6.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 7) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_7.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 8) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_8.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 9) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_9.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 11) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_5.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (Variance == 10) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.NEXTBOT_10.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
