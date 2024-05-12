
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.ChillIceUpdateTickProcedure;

public class ChillIceBlock extends FallingBlock {
	public ChillIceBlock() {
		super(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.ICE).sound(SoundType.GLASS).strength(0.8f, 1f).speedFactor(0.8f).jumpFactor(0.9f).randomTicks().noLootTable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		ChillIceUpdateTickProcedure.execute(world, x, y, z);
	}
}
