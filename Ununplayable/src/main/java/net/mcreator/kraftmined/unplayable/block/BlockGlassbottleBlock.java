
package net.mcreator.kraftmined.unplayable.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmined.unplayable.procedures.SilkTouchProcedure;

public class BlockGlassbottleBlock extends Block {
	public BlockGlassbottleBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.4f, 10f).friction(0.7f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 2;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return super.canHarvestBlock(state, world, pos, player) && SilkTouchProcedure.execute(player.level(), player);
	}
}
