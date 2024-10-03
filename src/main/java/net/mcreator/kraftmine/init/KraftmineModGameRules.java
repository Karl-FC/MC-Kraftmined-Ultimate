
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KraftmineModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> SUPPLIES;
	public static GameRules.Key<GameRules.BooleanValue> BUFFEDMOBS;
	public static GameRules.Key<GameRules.IntegerValue> TIMESPEED;
	public static GameRules.Key<GameRules.BooleanValue> HYDRATION;
	public static GameRules.Key<GameRules.BooleanValue> JUMPSCARES;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		SUPPLIES = GameRules.register("supplies", GameRules.Category.DROPS, GameRules.BooleanValue.create(true));
		BUFFEDMOBS = GameRules.register("buffedMobs", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
		TIMESPEED = GameRules.register("timeSpeed", GameRules.Category.MISC, GameRules.IntegerValue.create(0));
		HYDRATION = GameRules.register("hydration", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		JUMPSCARES = GameRules.register("jumpscares", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
