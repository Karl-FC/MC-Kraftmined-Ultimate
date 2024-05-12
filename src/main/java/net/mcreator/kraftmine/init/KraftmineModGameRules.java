
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KraftmineModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SUPPLIES = GameRules.register("supplies", GameRules.Category.DROPS, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BUFFEDMOBS = GameRules.register("buffedMobs", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> TIMESPEED = GameRules.register("timeSpeed", GameRules.Category.MISC, GameRules.IntegerValue.create(0));
	public static final GameRules.Key<GameRules.BooleanValue> HYDRATION = GameRules.register("hydration", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JUMPSCARES = GameRules.register("jumpscares", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
