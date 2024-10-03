package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class RemoveCryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(KraftmineModMobEffects.POTION_CRY)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(KraftmineModMobEffects.POTION_CRY);
		}
	}
}
