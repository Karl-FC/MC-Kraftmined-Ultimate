package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import java.util.Comparator;

public class FrozenZombieAttackConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double wait = 0;
		Entity target = null;
		target = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
		if ((target instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false) && !(target instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			return false;
		}
		return true;
	}
}
