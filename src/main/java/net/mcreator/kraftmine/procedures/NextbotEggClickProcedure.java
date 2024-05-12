package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.Nextbot9Entity;
import net.mcreator.kraftmine.entity.Nextbot8Entity;
import net.mcreator.kraftmine.entity.Nextbot7Entity;
import net.mcreator.kraftmine.entity.Nextbot6Entity;
import net.mcreator.kraftmine.entity.Nextbot5Entity;
import net.mcreator.kraftmine.entity.Nextbot4Entity;
import net.mcreator.kraftmine.entity.Nextbot3Entity;
import net.mcreator.kraftmine.entity.Nextbot2Entity;
import net.mcreator.kraftmine.entity.Nextbot1Entity;
import net.mcreator.kraftmine.entity.Nextbot11Entity;
import net.mcreator.kraftmine.entity.Nextbot10Entity;

import java.lang.reflect.Type;

public class NextbotEggClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Type = 0;
		double Variance = 0;
		Variance = Mth.nextInt(RandomSource.create(), 1, 11);
		if (Variance == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot1Entity(KraftmineModEntities.NEXTBOT_1.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot2Entity(KraftmineModEntities.NEXTBOT_2.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot3Entity(KraftmineModEntities.NEXTBOT_3.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 4) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot4Entity(KraftmineModEntities.NEXTBOT_4.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 5) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot11Entity(KraftmineModEntities.NEXTBOT_11.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 6) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot6Entity(KraftmineModEntities.NEXTBOT_6.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 7) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot7Entity(KraftmineModEntities.NEXTBOT_7.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 8) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot8Entity(KraftmineModEntities.NEXTBOT_8.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 9) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot9Entity(KraftmineModEntities.NEXTBOT_9.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 11) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot5Entity(KraftmineModEntities.NEXTBOT_5.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if (Variance == 10) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Nextbot10Entity(KraftmineModEntities.NEXTBOT_10.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
