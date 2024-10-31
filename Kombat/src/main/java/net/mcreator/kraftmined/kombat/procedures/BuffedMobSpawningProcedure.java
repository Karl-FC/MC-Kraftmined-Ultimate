package net.mcreator.kraftmined.kombat.procedures;

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
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmined.kombat.init.KmKombatModGameRules;
import net.mcreator.kraftmined.kombat.init.KmKombatModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BuffedMobSpawningProcedure {
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
		double BuffChance = 0;
		double Difficulty = 0;
		double Size = 0;
		if ((world.getLevelData().getGameRules().getInt(KmKombatModGameRules.BUFFED_MOBS)) > 0 && !(entity instanceof Player)) {
			Difficulty = (world.getLevelData().getGameRules().getInt(KmKombatModGameRules.BUFFED_MOBS));
			BuffChance = Difficulty * 0.25;
			if (Math.random() <= BuffChance) {
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(KmKombatModAttributes.BUFF_LEVEL))
					_livingEntity4.getAttribute(KmKombatModAttributes.BUFF_LEVEL).setBaseValue((Mth.nextInt(RandomSource.create(), 0, 3)));
				if ((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(KmKombatModAttributes.BUFF_LEVEL) ? _livingEntity5.getAttribute(KmKombatModAttributes.BUFF_LEVEL).getBaseValue() : 0) > 0) {
					BuffedWeaponsProcedure.execute(entity);
					BuffedArmorSpawningProcedure.execute(entity);
				}
				if (world.getLevelData().getGameRules().getBoolean(KmKombatModGameRules.SIZE_DIFFERENCE) == true) {
					Size = entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity7.getAttribute(Attributes.SCALE).getBaseValue() : 0;
					if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.SCALE))
						_livingEntity9.getAttribute(Attributes.SCALE).setBaseValue((Size + 0.005 * Mth.nextInt(RandomSource.create(), -15, 15)));
				}
			}
		}
	}
}
