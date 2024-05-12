package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class XPButtonClaimAllProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double TotalXPTaken = 0;
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "XPStored") >= 1) {
			TotalXPTaken = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "XPStored");
			if (entity instanceof Player _player)
				_player.giveExperienceLevels((int) TotalXPTaken);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("XPStored", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
