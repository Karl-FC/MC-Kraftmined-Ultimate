package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmined.kombat.init.KmKombatModAttributes;

public class TestDummyModeswitchProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity0.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 0) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
				_livingEntity2.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity1.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
			entity.setCustomName(Component.literal("Dmg Indicator Mode"));
		} else if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity4.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 1) {
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
				_livingEntity6.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity5.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
			entity.setCustomName(Component.literal("HP Indicator Mode"));
		} else if ((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity8.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 2) {
			if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
				_livingEntity10.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(
						((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity9.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) + 1));
			entity.setCustomName(Component.literal("HP Percentage Mode"));
		} else if ((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity12.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 3) {
			if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
				_livingEntity13.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(0);
			entity.setCustomName(Component.literal("Test Dummy"));
		}
	}
}
