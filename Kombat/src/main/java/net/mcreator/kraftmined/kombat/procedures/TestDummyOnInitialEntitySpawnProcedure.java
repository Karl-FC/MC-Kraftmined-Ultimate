package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmined.kombat.init.KmKombatModAttributes;

public class TestDummyOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE))
			_livingEntity0.getAttribute(KmKombatModAttributes.DUMMY_MODE).setBaseValue(0);
		entity.setCustomName(Component.literal("Test Dummy"));
	}
}
