
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmEnchartedModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> PLAYER_STARTING_SCALE;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		PLAYER_STARTING_SCALE = GameRules.register("playerStartingScale", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
	}
}
