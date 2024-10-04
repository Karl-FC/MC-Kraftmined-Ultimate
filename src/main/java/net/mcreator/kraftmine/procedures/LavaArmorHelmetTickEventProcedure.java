package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class LavaArmorHelmetTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.fireImmune() || !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.FIRE_RESISTANCE))) {
			entity.igniteForSeconds(5);
		}
	}
}
