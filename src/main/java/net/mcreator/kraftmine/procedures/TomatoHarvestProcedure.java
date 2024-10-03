package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class TomatoHarvestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState stage2 = Blocks.AIR.defaultBlockState();
		BlockState stage3 = Blocks.AIR.defaultBlockState();
		double dropcount = 0;
		stage2 = KraftmineModBlocks.TOMATO_BUSH_2.get().defaultBlockState();
		stage3 = KraftmineModBlocks.TOMATO_BUSH_3.get().defaultBlockState();
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == stage2.getBlock() && stage3.canSurvive(world, BlockPos.containing(x, y, z))) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = stage3;
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata(world.registryAccess());
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.loadWithComponents(_bnbt, world.registryAccess());
						} catch (Exception ignored) {
						}
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("GrowthTime", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			dropcount = Mth.nextInt(RandomSource.create(), 3, 10);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sweet_berry_bush.pick_berries")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sweet_berry_bush.pick_berries")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < (int) dropcount; index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(KraftmineModItems.RANGED_TOMATO.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
