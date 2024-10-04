package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

import com.mojang.math.Divisor;

@EventBusSubscriber
public class DegenerationProcedureProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity(), event.getAmount());
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double InitialHeal = 0;
		double Divisor = 0;
		double FinalHeal = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(KraftmineModMobEffects.ANTI_HEAL)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						- amount / ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.ANTI_HEAL) ? _livEnt.getEffect(KraftmineModMobEffects.ANTI_HEAL).getAmplifier() : 0) + 1)));
		}
	}
}
