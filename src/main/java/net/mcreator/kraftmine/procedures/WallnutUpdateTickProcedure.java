package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;
import net.mcreator.kraftmine.entity.ZombiePigManEntity;

import java.util.List;
import java.util.Comparator;

public class WallnutUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Tick = 0;
		if (!world.getEntitiesOfClass(Zombie.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty() || !world.getEntitiesOfClass(Husk.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(ZombieVillager.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty() || !world.getEntitiesOfClass(ZombiePigManEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(ZombifiedPiglin.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty() || !world.getEntitiesOfClass(ZombieHorse.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(Zoglin.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Zombie || entityiterator instanceof Husk || entityiterator instanceof ZombieVillager || entityiterator instanceof ZombiePigManEntity || entityiterator instanceof ZombifiedPiglin
							|| entityiterator instanceof Zoglin || entityiterator instanceof ZombieHorse) {
						Tick = Tick + 1;
						entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
					}
					if (Tick == 20) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("Health", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "Health") + 5));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("Health", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "Health") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.attack_wooden_door")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.attack_wooden_door")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					Tick = 0;
				}
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Health") >= 50) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(KraftmineModBlocks.WALLNUT.get().defaultBlockState()));
		}
	}
}
