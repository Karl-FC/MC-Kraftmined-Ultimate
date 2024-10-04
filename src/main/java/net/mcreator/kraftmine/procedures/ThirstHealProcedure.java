package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ThirstHealProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity().level(), event.getEntity(), event.getAmount());
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		double healamount = 0;
		if (entity instanceof Player && new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) && world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true && !(world.getDifficulty() == Difficulty.PEACEFUL)
				&& !(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(KraftmineModMobEffects.HYDRATED)) && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel > 0) {
			healamount = amount / 10;
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + healamount;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
