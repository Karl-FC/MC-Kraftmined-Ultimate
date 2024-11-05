
package net.mcreator.kraftmined.unplayable.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmined.unplayable.procedures.SilkTouchProcedure;

public class BlockEggBlock extends Block {
	public BlockEggBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.3f).friction(0.7f).speedFactor(0.9f).jumpFactor(0.5f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return super.canHarvestBlock(state, world, pos, player) && SilkTouchProcedure.execute(player.level(), player);
	}
}
