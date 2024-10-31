package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmined.kombat.init.KmKombatModItems;
import net.mcreator.kraftmined.kombat.init.KmKombatModAttributes;

public class TestDummyRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity1.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 0) {
				if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
					_livingEntity3.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity2.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
				entity.setCustomName(Component.literal("Dmg Indicator Mode"));
			} else if ((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity5.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 1) {
				if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
					_livingEntity7.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity6.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
				entity.setCustomName(Component.literal("HP Indicator Mode"));
			} else if ((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity9.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 2) {
				if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
					_livingEntity11.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
							((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity10.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
				entity.setCustomName(Component.literal("HP Percentage Mode"));
			} else if ((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity13.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 3) {
				if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
					_livingEntity14.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(0);
				entity.setCustomName(Component.literal("Test Dummy"));
			}
		} else if (!sourceentity.isShiftKeyDown()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(KmKombatModItems.TEST_DUMMY_SPAWN.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
