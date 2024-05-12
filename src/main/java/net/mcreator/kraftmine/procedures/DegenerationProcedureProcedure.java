package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHealEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
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
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.ANTI_HEAL.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						- amount / ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.ANTI_HEAL.get()) ? _livEnt.getEffect(KraftmineModMobEffects.ANTI_HEAL.get()).getAmplifier() : 0) + 1)));
		}
	}
}
