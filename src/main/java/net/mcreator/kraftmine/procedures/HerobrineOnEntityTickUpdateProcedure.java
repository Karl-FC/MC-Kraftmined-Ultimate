package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.entity.HerobrineEntity;

import java.util.List;
import java.util.Comparator;
import java.util.Calendar;

public class HerobrineOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double AttackType = 0;
		double TPCounter = 0;
		double AirCountdown = 0;
		Entity NearestOpponent = null;
		Entity Herobrine = null;
		if (entity instanceof HerobrineEntity) {
			Herobrine = entity;
			TPCounter = TPCounter + 0.05;
			if (TPCounter == 15) {
				TPCounter = 0;
				{
					Entity _ent = Herobrine;
					_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), y, (z + Mth.nextInt(RandomSource.create(), -10, 10)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), -10, 10)), y, (z + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
				AirCountdown = AirCountdown + 0.05;
			}
			if (AirCountdown == 10) {
				AirCountdown = 0;
				Herobrine.setDeltaMovement(new Vec3(0, (-2), 0));
				if (Herobrine instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SLOW_FALLING);
				if (Herobrine instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.LEVITATION);
			}
			if ((Herobrine instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 495) {
				if (Math.random() <= 0.05) {
					if (Herobrine instanceof LivingEntity _entity)
						_entity.setHealth((float) ((Herobrine instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 5));
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						AttackType = Calendar.getInstance().get(Calendar.SECOND);
						if (AttackType == 9) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							if (!(!world.getEntitiesOfClass(WitherSkeleton.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index0 = 0; index0 < 4; index0++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 3, entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								}
							}
						}
						if (AttackType == 19) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							if (!(!world.getEntitiesOfClass(Blaze.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index1 = 0; index1 < 3; index1++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.BLAZE.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 3, entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								}
							}
						}
						if (AttackType == 29) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 4);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.parrot.imitate.wither")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.parrot.imitate.wither")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
						if (AttackType == 39) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
							entityiterator.igniteForSeconds(5);
						}
						if (AttackType == 49) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 8));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
						if (AttackType == 59) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, false, false));
							if (Herobrine instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (!(!world.getEntitiesOfClass(Creeper.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index2 = 0; index2 < 1; index2++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.CREEPER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + 1, entityiterator.getZ() + 2), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								}
							}
						}
					}
					if (entityiterator instanceof WitherSkeleton) {
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.NETHERITE_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
							}
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
							}
						}
					}
					if (entityiterator instanceof Creeper) {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
