package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;
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
			if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.CONJURING.get(), itemstack) != 0 && !(world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:impenetrable")))
					&& !((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR)) {
				world.setBlock(new BlockPos(x, y + 1, z), (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
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
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.RECONSTRUCTION.get(), itemstack) != 0) {
				world.setBlock(new BlockPos(x, y, z), (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
				if (!((world.getBlockState(new BlockPos(x, y, z))).getBlock() == KraftmineModBlocks.WALL_BLOCK.get())) {
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
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				} else {
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
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(50, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			} else {
				if (!(world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:impenetrable")))) {
					world.setBlock(new BlockPos(x, y, z), (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:dirt"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
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
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			}
		}
	}
}
