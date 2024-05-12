
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.GravityDisruptorProcedureProcedure;

import java.util.List;
import java.util.Collections;

public class GravityDisruptorBlock extends Block {
	public GravityDisruptorBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.METAL).strength(1.5f, 10f).jumpFactor(0.8f));
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
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		GravityDisruptorProcedureProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
	}
}
