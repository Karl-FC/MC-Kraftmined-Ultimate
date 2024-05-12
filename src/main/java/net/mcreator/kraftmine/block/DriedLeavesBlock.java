
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class DriedLeavesBlock extends Block {
	public DriedLeavesBlock() {
		super(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.PLANT).sound(SoundType.MOSS).strength(1f, 10f).requiresCorrectToolForDrops().noCollission().speedFactor(0.7000000000000001f).jumpFactor(1.2f));
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
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.LEAVES;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof HoeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 1;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
