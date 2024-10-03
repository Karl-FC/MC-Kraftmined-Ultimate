
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.CloudBlockRainBlockDestroyedByPlayerProcedure;

import com.mojang.serialization.MapCodec;

public class CloudBlockRainBlock extends FallingBlock {
	public static final MapCodec<CloudBlockRainBlock> CODEC = simpleCodec(properties -> new CloudBlockRainBlock());

	public MapCodec<CloudBlockRainBlock> codec() {
		return CODEC;
	}

	public CloudBlockRainBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(1f, 10f).friction(0.8f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		CloudBlockRainBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
