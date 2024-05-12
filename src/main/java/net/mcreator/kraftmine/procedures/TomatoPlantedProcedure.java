package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class TomatoPlantedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack seeds = ItemStack.EMPTY;
		BlockState stage0 = Blocks.AIR.defaultBlockState();
		seeds = new ItemStack(KraftmineModItems.TOMATOSEEDS.get());
		stage0 = KraftmineModBlocks.TOMATO_BUSH.get().defaultBlockState();
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == seeds.getItem() && (world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR
				&& stage0.canSurvive(world, new BlockPos(x, y + 1, z))) {
			world.setBlock(new BlockPos(x, y + 1, z), stage0, 3);
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					_setstack.setCount((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getCount() - 1));
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
	}
}
