
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.BackroomTriggerUpdateTickProcedure;
import net.mcreator.kraftmine.procedures.BackroomTriggerBlockAddedProcedure;

import java.util.List;
import java.util.Collections;

public class BackroomTriggerBlock extends Block {
	public BackroomTriggerBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GRAVEL).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 10);
		BackroomTriggerBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		BackroomTriggerUpdateTickProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 10);
	}
}
