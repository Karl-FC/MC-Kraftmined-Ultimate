
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.ChillIceUpdateTickProcedure;

import com.mojang.serialization.MapCodec;

public class ChillIceBlock extends FallingBlock {
	public static final MapCodec<ChillIceBlock> CODEC = simpleCodec(properties -> new ChillIceBlock());

	public MapCodec<ChillIceBlock> codec() {
		return CODEC;
	}

	public ChillIceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).sound(SoundType.GLASS).strength(0.8f, 1f).speedFactor(0.8f).jumpFactor(0.9f).randomTicks().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		ChillIceUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
