
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmKombatModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> BUFFED_MOBS;
	public static GameRules.Key<GameRules.IntegerValue> BUFFED_PASSIVES;
	public static GameRules.Key<GameRules.BooleanValue> SIZE_DIFFERENCE;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		BUFFED_MOBS = GameRules.register("buffedMobs", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
		BUFFED_PASSIVES = GameRules.register("buffedPassives", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
		SIZE_DIFFERENCE = GameRules.register("sizeDifference", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
	}
}
