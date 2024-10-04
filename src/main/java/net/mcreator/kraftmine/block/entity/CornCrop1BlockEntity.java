package net.mcreator.kraftmine.block.entity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlockEntities;

public class CornCrop1BlockEntity extends BlockEntity {
	public CornCrop1BlockEntity(BlockPos pos, BlockState state) {
		super(KraftmineModBlockEntities.CORN_CROP_1.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}
}
