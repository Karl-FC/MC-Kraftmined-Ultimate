package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import java.util.List;
import java.util.Comparator;

public class FireScepterProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity user = null;
		user = sourceentity;
		if (!(entity == user)) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 4);
			entity.igniteForSeconds(10);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == user) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 1);
						entityiterator.igniteForSeconds(3);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == user) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 2);
						entityiterator.igniteForSeconds(6);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == user) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 3);
						entityiterator.igniteForSeconds(8);
					}
				}
			}
		}
	}
}
