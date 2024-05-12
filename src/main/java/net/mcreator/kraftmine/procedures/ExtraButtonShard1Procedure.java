package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;

public class ExtraButtonShard1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double PosX = 0;
		double PosY = 0;
		double PosZ = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.SHARD_VOLUMETRIC.get())) : false) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_space"))).isDone()
					: false) == false) {
				PosX = Mth.nextInt(RandomSource.create(), 1, 10);
				PosY = Mth.nextInt(RandomSource.create(), 1, 10);
				PosZ = Mth.nextInt(RandomSource.create(), 1, 10);
				if ((world.getBlockState(new BlockPos(x + PosX, y + PosY + 1, z + PosZ))).getBlock() == Blocks.AIR) {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + PosX), (y + PosY), (z + PosZ));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + PosX), (y + PosY), (z + PosZ), _ent.getYRot(), _ent.getXRot());
					}
				}
			} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_space"))).isDone()
					: false) == true) {
				entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 2), Math.sin(Math.toRadians(0 - entity.getXRot())), (Math.cos(Math.toRadians(entity.getYRot())) * 2)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 3, (false), (false)));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.SHARD_POSITIONING.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.SHARD_ALTITUDE.get())) : false)) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.SHARD_ALTITUDE.get())) : false) {
				if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_air"))).isDone()
						: false) == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.95), (0 - entity.getXRot()), (Math.cos(Math.toRadians(entity.getYRot())) * 0.95)));
				} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_air"))).isDone()
						: false) == false) {
					PosY = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((world.getBlockState(new BlockPos(x, y + PosY + 1, z))).getBlock() == Blocks.AIR) {
						{
							Entity _ent = entity;
							_ent.teleportTo(x, PosY, z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, PosY, z, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.SHARD_POSITIONING.get())) : false) {
				if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_land"))).isDone()
						: false) == true) {
					entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.95), (0 - entity.getXRot()), (Math.cos(Math.toRadians(entity.getYRot())) * 0.95)));
				} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_land"))).isDone()
						: false) == false) {
					PosX = Mth.nextInt(RandomSource.create(), 1, 5);
					PosZ = Mth.nextInt(RandomSource.create(), 1, 5);
					if ((world.getBlockState(new BlockPos(x + PosX, y + 1, z + PosZ))).getBlock() == Blocks.AIR) {
						{
							Entity _ent = entity;
							_ent.teleportTo((x + PosX), y, (z + PosZ));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((x + PosX), y, (z + PosZ), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}
