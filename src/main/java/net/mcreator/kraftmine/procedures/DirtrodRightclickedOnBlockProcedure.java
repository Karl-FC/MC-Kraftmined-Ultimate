package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class DirtrodRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		ItemStack emeralds = ItemStack.EMPTY;
		ItemStack tool = ItemStack.EMPTY;
		ItemStack pickaxe = ItemStack.EMPTY;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double enchant_levels = 0;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem) {
			if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:conjuring")))) != 0
					&& !(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:impenetrable"))) && true) {
				world.setBlock(BlockPos.containing(x, y + 1, z),
						(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
								.defaultBlockState(),
						3);
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:reconstruction")))) != 0) {
				world.setBlock(BlockPos.containing(x, y, z),
						(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
								.defaultBlockState(),
						3);
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == KraftmineModBlocks.WALL_BLOCK.get())) {
					if (new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entity)) {
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
				} else {
					if (new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entity)) {
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(50, _level, null, _stkprov -> {
							});
						}
					}
				}
			} else {
				if (!(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:impenetrable")))) {
					world.setBlock(BlockPos.containing(x, y, z),
							(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
									.defaultBlockState(),
							3);
					if (new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entity)) {
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
				}
			}
		}
	}
}
