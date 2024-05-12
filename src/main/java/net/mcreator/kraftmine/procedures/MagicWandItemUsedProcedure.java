package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

public class MagicWandItemUsedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SUPERSTITIOUS.get(), itemstack) != 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((int) ((100 - EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.MAGICIAN_SECRET.get(), itemstack) * 15) - 1), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			} else {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((int) (100 - 1), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true) {
					{
						double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel - 1;
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Thirstlevel = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
