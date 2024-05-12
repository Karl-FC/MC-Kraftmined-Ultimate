package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.world.inventory.PossibilityShardGUIMenu;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModItems;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

public class ExtraButtonShard2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sped = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.OMNIPOTENCE_SHARD.get() && (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:wisdom_omnipotence"))).isDone()
				: false) == true) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.CREATIVE);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			} else if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.ASCENDANCE_SHARD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.ASCENDANCE_SHARD.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:wisdom_ascendence"))).isDone()
					: false) == true) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PossibilityShardGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PossibilityShardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.TRANSCENDENCE_SHARD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.TRANSCENDENCE_SHARD.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:wisdom_trancendence"))).isDone()
					: false) == true) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PossibilityShardGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PossibilityShardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.INITIAL_SHARD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.INITIAL_SHARD.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:knowledge_initial"))).isDone()
					: false) == true) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PossibilityShardGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PossibilityShardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.REALITY_SHARD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.REALITY_SHARD.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:knowledge_realities"))).isDone()
					: false) == true) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PossibilityShardGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PossibilityShardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.SHARD_POSSIBILITIES.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.SHARD_POSSIBILITIES.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:knowledge_alternates"))).isDone()
					: false) == true) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				{
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("PossibilityShardGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new PossibilityShardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.SHARD_TIME.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.SHARD_TIME.get()) {
			if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_time"))).isDone()
					: false) == true) {
				if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.TIME_FREEZE.get()) : false)) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.TIME_FREEZE.get(), 600, 1));
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
				} else if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.TIME_FREEZE.get()) : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(KraftmineModMobEffects.TIME_FREEZE.get());
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			} else if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:mastery_time"))).isDone()
					: false) == false) {
				sped = Mth.nextInt(RandomSource.create(), 0, 1);
				if (sped < 1) {
					sped = Mth.nextInt(RandomSource.create(), 1, 2);
					if (sped == 1) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player)) {
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999, 7, (false), (false)));
								} else {
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999, 2, (false), (false)));
								}
							}
						}
						sped = 0;
					} else if (sped == 2) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player)) {
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 7, (false), (false)));
								} else {
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9999, 5, (false), (false)));
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 9999, 5, (false), (false)));
								}
							}
						}
						sped = 0;
					}
				} else if (sped > 0) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.SLOW_FALLING);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
						}
					}
				}
			}
		}
	}
}