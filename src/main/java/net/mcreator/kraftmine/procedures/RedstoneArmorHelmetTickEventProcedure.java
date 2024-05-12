package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.KraftmineMod;

public class RedstoneArmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.REDSTONE_LAMP) {
			world.setBlock(new BlockPos(x, y + 2, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			KraftmineMod.queueServerWork(200, () -> {
				world.setBlock(new BlockPos(x, y + 2, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(new BlockPos(x, y + 3, z))).getBlock() == Blocks.REDSTONE_LAMP && !((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR)) {
			world.setBlock(new BlockPos(x, y + 3, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			KraftmineMod.queueServerWork(200, () -> {
				world.setBlock(new BlockPos(x, y + 3, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.TNT) {
			world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new PrimedTnt(EntityType.TNT, _level);
				entityToSpawn.moveTo(x, (y + 2), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
