package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class TimeFreezeExpiresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator) && (entityiterator instanceof Monster || entityiterator instanceof Animal)) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 200, (false), (false)));
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 200, (false), (false)));
						if (entityiterator instanceof Player _player) {
							_player.getAbilities().invulnerable = ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)
									&& (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) == 200);
							_player.onUpdateAbilities();
						}
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, (false), (false)));
		}
	}
}
