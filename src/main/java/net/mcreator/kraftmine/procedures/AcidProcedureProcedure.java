package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

public class AcidProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Ticktimer = 0;
		Ticktimer = Ticktimer + 1;
		if (Ticktimer >= 10) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("acid").bypassArmor(), 2);
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1, (false), (false)));
			Ticktimer = 0;
		}
	}
}
