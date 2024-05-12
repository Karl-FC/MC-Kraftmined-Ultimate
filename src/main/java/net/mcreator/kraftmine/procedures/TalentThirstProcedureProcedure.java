package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.Advancement;

import net.mcreator.kraftmine.network.KraftmineModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TalentThirstProcedureProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAdvancement(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
		execute(null, world, x, y, z, advancement, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
		if (advancement == null || entity == null)
			return;
		double addhealth = 0;
		if (world instanceof Level _lvl && _lvl.getServer() != null ? _lvl.getServer().getAdvancements().getAdvancement(new ResourceLocation("kraftmine:talent_thirst")).equals(advancement) : false) {
			if (!((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).PlayerMaxThirst > 20)) {
				{
					double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).PlayerMaxThirst + 2;
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerMaxThirst = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}
