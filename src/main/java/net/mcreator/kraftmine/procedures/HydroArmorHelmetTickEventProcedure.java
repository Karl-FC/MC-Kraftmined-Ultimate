package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class HydroArmorHelmetTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.WATER_BREATHING) : false)) {
			entity.setAirSupply((int) (entity.getAirSupply() - 1));
		}
		if (entity.isOnFire()) {
			entity.clearFire();
		}
	}
}