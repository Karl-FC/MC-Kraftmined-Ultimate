
package net.mcreator.kraftmine.block;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.TomatoUpdateTickProcedure;
import net.mcreator.kraftmine.procedures.TomatoBushPlantAddedProcedure;
import net.mcreator.kraftmine.procedures.TomatoBoneMealProcedure;
import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.block.entity.TomatoBush2BlockEntity;

public class TomatoBush2Block extends FlowerBlock implements EntityBlock {
	public TomatoBush2Block() {
		super(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of(Material.PLANT).randomTicks().sound(SoundType.CROP).instabreak().noLootTable().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.WALKABLE;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(KraftmineModItems.TOMATO.get());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		TomatoBushPlantAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		TomatoUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		TomatoBoneMealProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TomatoBush2BlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
