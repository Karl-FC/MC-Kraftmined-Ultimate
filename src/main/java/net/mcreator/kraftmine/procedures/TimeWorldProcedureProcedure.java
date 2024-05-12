package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TimeWorldProcedureProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if ((world.getLevelData().getGameRules().getInt(KraftmineModGameRules.TIMESPEED)) > 0) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world.dayTime() + (world.getLevelData().getGameRules().getInt(KraftmineModGameRules.TIMESPEED))));
		}
	}
}
