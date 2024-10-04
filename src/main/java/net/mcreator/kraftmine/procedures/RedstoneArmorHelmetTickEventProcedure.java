package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.KraftmineMod;

public class RedstoneArmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.REDSTONE_LAMP) {
			world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			KraftmineMod.queueServerWork(200, () -> {
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.REDSTONE_LAMP && !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR)) {
			world.setBlock(BlockPos.containing(x, y + 3, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			KraftmineMod.queueServerWork(200, () -> {
				world.setBlock(BlockPos.containing(x, y + 3, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
			});
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.TNT) {
			world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}
