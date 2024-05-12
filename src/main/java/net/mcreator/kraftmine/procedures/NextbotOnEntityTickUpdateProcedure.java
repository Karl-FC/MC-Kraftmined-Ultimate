package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.Direction;

import java.util.Comparator;

public class NextbotOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x + 2), y, z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x - 2), y, z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x + 2), (y + 3), z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((x - 2), (y + 3), z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			}
		} else if ((entity.getDirection()) == Direction.EAST || (entity.getDirection()) == Direction.WEST) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 2)), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, (z + 2))).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 2)), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, (z - 2))).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 2)), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, (y + 3), (z + 2))).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 2)), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, (y + 3), (z - 2))).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 10);
			}
		}
	}
}
