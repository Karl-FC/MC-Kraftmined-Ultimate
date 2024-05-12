package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class StabweaponsProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		Entity front = null;
		Entity back = null;
		double distance = 0;
		double DmgMultiplier = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("kraftmine:stabbing_weapons")))) {
			if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).isEmpty()) {
				front = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
				for (int index0 = 0; index0 < (int) (5); index0++) {
					distance = distance + 1;
					DmgMultiplier = DmgMultiplier + 1;
					if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY()), (front.getZ() - distance)), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.NORTH) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY()), (front.getZ() - distance)), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX()), (front.getY()), (front.getZ() - distance))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					} else if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY()), (front.getZ() + distance)), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.SOUTH) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY()), (front.getZ() + distance)), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX()), (front.getY()), (front.getZ() + distance))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					} else if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX() + distance), (front.getY()), (front.getZ())), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.EAST) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX() + distance), (front.getY()), (front.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX() + distance), (front.getY()), (front.getZ()))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					} else if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX() - distance), (entity.getY()), (entity.getZ())), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.WEST) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX() - distance), (front.getY()), (front.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX() - distance), (front.getY()), (front.getZ()))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					} else if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY() + distance), (entity.getZ())), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.UP) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY() + distance), (front.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX()), (front.getY() + distance), (front.getZ()))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					} else if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY() - distance), (entity.getZ())), 1, 1, 1), e -> true).isEmpty() && (sourceentity.getDirection()) == Direction.DOWN) {
						back = (Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((front.getX()), (front.getY() - distance), (front.getZ())), 1, 1, 1), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf((front.getX()), (front.getY() - distance), (front.getZ()))).findFirst().orElse(null);
						if (!(front == back)) {
							back.hurt(DamageSource.GENERIC, (float) Math.ceil(amount / DmgMultiplier));
						}
					}
				}
			}
		}
	}
}
