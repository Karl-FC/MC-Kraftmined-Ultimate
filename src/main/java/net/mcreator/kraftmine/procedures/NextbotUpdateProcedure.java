package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class NextbotUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Distance = 0;
		double Interval = 0;
		if (!(entity.getPersistentData().getDouble("BotVariant") == 4 || entity.getPersistentData().getDouble("BotVariant") == 9)) {
			if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 2), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 2), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 2), (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 2), (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			} else if ((entity.getDirection()) == Direction.EAST || (entity.getDirection()) == Direction.WEST) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 2)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z + 2))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 2)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z - 2))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 2)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), (z + 2))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 2)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 2)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), (z - 2))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			}
		} else if (entity.getPersistentData().getDouble("BotVariant") == 4) {
			if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 2), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 2), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 2), (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 2), (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 2), (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			} else if ((entity.getDirection()) == Direction.EAST || (entity.getDirection()) == Direction.WEST) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 1)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 1)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z - 1))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 1)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), (z + 1))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 1)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), (z - 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), (z - 1))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 3), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			}
		} else if (entity.getPersistentData().getDouble("BotVariant") == 9) {
			if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 4), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 4), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 4), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 4), y, z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 4), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 4), y, z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 4), (y + 4), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 4), (y + 4), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x + 4), (y + 4), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 4), (y + 4), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x - 4), (y + 4), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((x - 4), (y + 4), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), z), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 4), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			} else if ((entity.getDirection()) == Direction.EAST || (entity.getDirection()) == Direction.WEST) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 4)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 4)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z + 4))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 4)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z - 4)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, (z - 4))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), (z + 4)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), (z + 4)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 4), (z + 4))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), (z - 4)), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), (z - 4)), 2, 2, 2), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 4), (z - 4))).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), z), 2, 2, 2), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, (y + 4), z), 3, 3, 3), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, (y + 4), z)).findFirst().orElse(null)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 10);
				}
			}
		}
		if (entity.getPersistentData().getDouble("BotVariant") == 3) {
			Interval = Interval + 1;
			if (Interval == 300) {
				for (int index0 = 0; index0 < 20; index0++) {
					Distance = Mth.nextInt(RandomSource.create(), -10, 10);
					if (!world.getBlockState(BlockPos.containing(x + Distance, y + Distance, z + Distance)).canOcclude() && world.getBlockState(BlockPos.containing(x + Distance, (y + Distance) - 1, z + Distance)).canOcclude()) {
						{
							Entity _ent = entity;
							_ent.teleportTo((x + Distance), (y + Distance), (z + Distance));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((x + Distance), (y + Distance), (z + Distance), _ent.getYRot(), _ent.getXRot());
						}
						Interval = 0;
						break;
					} else if (world.getBlockState(BlockPos.containing(x + Distance, y + Distance, z + Distance)).canOcclude()) {
						continue;
					}
				}
			}
		} else if (entity.getPersistentData().getDouble("BotVariant") == 8) {
			Interval = Interval + 1;
			if (Interval == Mth.nextInt(RandomSource.create(), 100, 200)) {
				entity.setDeltaMovement(new Vec3(0, 1, 0));
				Interval = 0;
			}
		} else if (entity.getPersistentData().getDouble("BotVariant") == 6) {
			if (Interval == Mth.nextInt(RandomSource.create(), 100, 300)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 3, false, true));
				Interval = 0;
			}
		}
	}
}
