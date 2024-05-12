package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class AetherDimensionPortalTriggerUsedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:travel.aether")), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:travel.aether")), SoundSource.MUSIC, 1, 1, false);
			}
		}
		if (!world.isEmptyBlock(new BlockPos(x, y, z)) && !world.isEmptyBlock(new BlockPos(x, y - 1, z))) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if (world.isEmptyBlock(new BlockPos(x, y - 2, z))) {
			world.setBlock(new BlockPos(x, y - 2, z), KraftmineModBlocks.CLOUD.get().defaultBlockState(), 3);
		}
	}
}
