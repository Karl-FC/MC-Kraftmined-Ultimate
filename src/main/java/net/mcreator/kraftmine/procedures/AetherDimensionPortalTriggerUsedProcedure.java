package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class AetherDimensionPortalTriggerUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:travel.aether")), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:travel.aether")), SoundSource.MUSIC, 1, 1, false);
			}
		}
		if (!world.isEmptyBlock(BlockPos.containing(x, y, z)) && !world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y - 2, z))) {
			world.setBlock(BlockPos.containing(x, y - 2, z), KraftmineModBlocks.CLOUD.get().defaultBlockState(), 3);
		}
	}
}
