package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import java.util.Comparator;

public class FrozenZombieRunConditionProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		Entity target = null;
		target = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
		if (!(target instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) && !(target instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			return true;
		}
		return false;
	}
}
