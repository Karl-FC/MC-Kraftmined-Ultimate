package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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

@Mod.EventBusSubscriber
public class ThirstMainProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double seconds = 0;
		if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel < (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new KraftmineModVariables.PlayerVariables())).PlayerMaxThirst) {
			{
				boolean _setval = true;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AllowDrink = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel >= (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new KraftmineModVariables.PlayerVariables())).PlayerMaxThirst) {
			{
				boolean _setval = false;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AllowDrink = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true && (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel > 0
				&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.HYDRATED.get()) : false) && new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity) && !(world.getDifficulty() == Difficulty.PEACEFUL)) {
			{
				double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel + 0.001;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ThirstExhaustionLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity.isOnFire() || (entity instanceof LivingEntity _livEnt ? _livEnt.isFallFlying() : false)) {
				{
					double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel + 0.2;
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirstExhaustionLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.isSprinting()) {
				{
					double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel + 0.025;
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirstExhaustionLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (world.getBiome(new BlockPos(x, y, z)).value().getBaseTemperature() * 100f >= 1) {
				{
					double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel
							+ world.getBiome(new BlockPos(x, y, z)).value().getBaseTemperature() * 100f * 0.0001;
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ThirstExhaustionLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("desert"))) {
					{
						double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel
								+ world.getBiome(new BlockPos(x, y, z)).value().getBaseTemperature() * 100f * 0.0001;
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ThirstExhaustionLevel = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.HYDRATION) == true
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).ThirstExhaustionLevel >= (entity
						.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).PlayerMaxThirstExhaustion) {
			{
				double _setval = 0;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ThirstExhaustionLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
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
