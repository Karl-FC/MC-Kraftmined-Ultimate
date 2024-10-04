package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class TomatoBoneMealProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState stage2 = Blocks.AIR.defaultBlockState();
		BlockState stage1 = Blocks.AIR.defaultBlockState();
		BlockState stage0 = Blocks.AIR.defaultBlockState();
		BlockState stage3 = Blocks.AIR.defaultBlockState();
		stage0 = KraftmineModBlocks.TOMATO_BUSH.get().defaultBlockState();
		stage1 = KraftmineModBlocks.TOMATO_BUSH_1.get().defaultBlockState();
		stage2 = KraftmineModBlocks.TOMATO_BUSH_2.get().defaultBlockState();
		stage3 = KraftmineModBlocks.TOMATO_BUSH_3.get().defaultBlockState();
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == stage0.getBlock() && stage1.canSurvive(world, BlockPos.containing(x, y, z))) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = stage1;
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
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == stage1.getBlock() && stage2.canSurvive(world, BlockPos.containing(x, y, z))) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = stage2;
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
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == stage2.getBlock() && stage3.canSurvive(world, BlockPos.containing(x, y, z))) {
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
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 5, 3, 3, 3, 1);
		}
	}
}
