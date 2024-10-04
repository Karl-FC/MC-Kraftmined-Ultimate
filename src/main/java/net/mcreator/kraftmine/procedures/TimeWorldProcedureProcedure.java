package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TimeWorldProcedureProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
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
