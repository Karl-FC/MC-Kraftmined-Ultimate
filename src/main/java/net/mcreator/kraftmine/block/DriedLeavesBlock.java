
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DriedLeavesBlock extends Block {
	public DriedLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.PLANT).sound(SoundType.MOSS).strength(1f, 10f).requiresCorrectToolForDrops().noCollission().speedFactor(0.7f).jumpFactor(1.2f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 2;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.LEAVES;
	}
}
