package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ThirstMainProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double seconds = 0;
		if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel < entity.getData(KraftmineModVariables.PLAYER_VARIABLES).PlayerMaxThirst) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.AllowDrink = true;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel >= entity.getData(KraftmineModVariables.PLAYER_VARIABLES).PlayerMaxThirst) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.AllowDrink = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel > 0
				&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(KraftmineModMobEffects.HYDRATED)) && new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity) && !(world.getDifficulty() == Difficulty.PEACEFUL)) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + 0.001;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.isOnFire() || entity instanceof LivingEntity _livEnt5 && _livEnt5.isFallFlying()) {
				{
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + 0.2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.isSprinting()) {
				{
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + 0.025;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f >= 1) {
				{
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f * 0.0001;
					_vars.syncPlayerVariables(entity);
				}
				if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert"))) {
					{
						KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
						_vars.ThirstExhaustionLevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel + world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f * 0.0001;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true
				&& entity.getData(KraftmineModVariables.PLAYER_VARIABLES).ThirstExhaustionLevel >= entity.getData(KraftmineModVariables.PLAYER_VARIABLES).PlayerMaxThirstExhaustion) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.ThirstExhaustionLevel = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
