package net.mcreator.kraftmine.block.entity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlockEntities;

public class TomatoBush1BlockEntity extends BlockEntity {
	public TomatoBush1BlockEntity(BlockPos pos, BlockState state) {
		super(KraftmineModBlockEntities.TOMATO_BUSH_1.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}
}
