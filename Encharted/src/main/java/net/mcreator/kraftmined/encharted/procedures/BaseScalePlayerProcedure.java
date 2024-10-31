package net.mcreator.kraftmined.encharted.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmined.encharted.init.KmEnchartedModGameRules;
import net.mcreator.kraftmined.encharted.init.KmEnchartedModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BaseScalePlayerProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SCALE) && entity instanceof Player) {
			if ((world.getLevelData().getGameRules().getInt(KmEnchartedModGameRules.PLAYER_STARTING_SCALE)) > 16) {
				if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(KmEnchartedModAttributes.BASE_SCALE))
					_livingEntity3.getAttribute(KmEnchartedModAttributes.BASE_SCALE).setBaseValue(16);
			} else if ((world.getLevelData().getGameRules().getInt(KmEnchartedModGameRules.PLAYER_STARTING_SCALE)) < 0.0625) {
				if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(KmEnchartedModAttributes.BASE_SCALE))
					_livingEntity5.getAttribute(KmEnchartedModAttributes.BASE_SCALE).setBaseValue(0.0625);
			} else {
				if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(KmEnchartedModAttributes.BASE_SCALE))
					_livingEntity7.getAttribute(KmEnchartedModAttributes.BASE_SCALE).setBaseValue((world.getLevelData().getGameRules().getInt(KmEnchartedModGameRules.PLAYER_STARTING_SCALE)));
			}
		}
	}
}
