
package net.mcreator.kraftmine.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class SupplyCrateBlock extends FallingBlock {
	public static final MapCodec<SupplyCrateBlock> CODEC = simpleCodec(properties -> new SupplyCrateBlock());

	public MapCodec<SupplyCrateBlock> codec() {
		return CODEC;
	}

	public SupplyCrateBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.BAMBOO).strength(2f, 10f).lightLevel(s -> 1).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
