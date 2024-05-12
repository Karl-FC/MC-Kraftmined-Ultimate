package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.Direction;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class HelicopterOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Direction facingat = Direction.NORTH;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.HELICOPTER.get()) : false) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 15));
				_ent.setXRot(1);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1, (false), (false)));
		}
	}
}
