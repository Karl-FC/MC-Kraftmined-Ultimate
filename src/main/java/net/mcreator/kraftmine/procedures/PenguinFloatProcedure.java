package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.kraftmine.entity.PenguinbigEntity;
import net.mcreator.kraftmine.entity.PenguinEntity;

public class PenguinFloatProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.WATER_BREATHING) : false)
				&& (entity instanceof PenguinEntity && entity.getPersistentData().getDouble("air") < 200 || entity instanceof PenguinbigEntity && entity.getPersistentData().getDouble("air") < 100)) {
			return true;
		}
		return false;
	}
}
