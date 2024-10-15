package net.mcreator.kraftmined.procedures;

import org.jline.terminal.Size;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmined.init.KraftminedModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SizeDifferenceProcedureProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Size = 0;
		if (world.getLevelData().getGameRules().getBoolean(KraftminedModGameRules.SIZE_DIFFERENCE) == true && !(entity instanceof Player)) {
			Size = entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity2.getAttribute(Attributes.SCALE).getBaseValue() : 0;
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity4.getAttribute(Attributes.SCALE).setBaseValue((Size + 0.01 * Mth.nextInt(RandomSource.create(), -20, 20)));
		}
	}
}
