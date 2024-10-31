package net.mcreator.kraftmined.kombat.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmined.kombat.init.KmKombatModAttributes;
import net.mcreator.kraftmined.kombat.entity.TestDummyEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TestDummyUseProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof TestDummyEntity) {
			if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity1.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 1) {
				entity.setCustomName(Component.literal(("DMG: " + Math.round(amount))));
			} else if ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity3.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 2) {
				entity.setCustomName(Component.literal(("HP: " + Math.round(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1))));
			} else if ((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(KmKombatModAttributes.DUMMY_MODE) ? _livingEntity6.getAttribute(KmKombatModAttributes.DUMMY_MODE).getBaseValue() : 0) == 3) {
				entity.setCustomName(Component.literal(("% HP: " + (((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 100) + "%")));
			}
		}
	}
}
