
package net.mcreator.kraftmine.block;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.TomatoUpdateTickProcedure;
import net.mcreator.kraftmine.procedures.TomatoHarvestProcedure;
import net.mcreator.kraftmine.procedures.TomatoBushPlantAddedProcedure;
import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.block.entity.TomatoBush3BlockEntity;

public class TomatoBush3Block extends FlowerBlock implements EntityBlock {
	public TomatoBush3Block() {
		super(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().sound(SoundType.CROP).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.WALKABLE;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player) {
		return new ItemStack(KraftmineModItems.RANGED_TOMATO.get());
	}

	private boolean canPlantTypeSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return state.is(BlockTags.DIRT) || state.getBlock() == Blocks.FARMLAND;
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader world, BlockPos pos) {
		BlockPos posbelow = pos.below();
		BlockState statebelow = world.getBlockState(posbelow);
		if (blockstate.getBlock() == this)
			return this.canPlantTypeSurvive(statebelow, world, posbelow);
		return this.mayPlaceOn(statebelow, world, posbelow);
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		TomatoBushPlantAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		TomatoUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		TomatoHarvestProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return InteractionResult.SUCCESS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TomatoBush3BlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
