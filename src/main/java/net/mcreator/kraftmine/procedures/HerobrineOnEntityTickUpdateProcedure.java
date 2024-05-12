package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.entity.HerobrineEntity;

import java.util.stream.Collectors;
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
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR) {
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
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						AttackType = Calendar.getInstance().get(Calendar.SECOND);
						if (AttackType == 9) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							if (!(!world.getEntitiesOfClass(WitherSkeleton.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index0 = 0; index0 < (int) (4); index0++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new WitherSkeleton(EntityType.WITHER_SKELETON, _level);
										entityToSpawn.moveTo((entityiterator.getX()), (entityiterator.getY() + 3), (entityiterator.getZ()), world.getRandom().nextFloat() * 360F, 0);
										if (entityToSpawn instanceof Mob _mobToSpawn)
											_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										world.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
						if (AttackType == 19) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							if (!(!world.getEntitiesOfClass(Blaze.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index1 = 0; index1 < (int) (3); index1++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new Blaze(EntityType.BLAZE, _level);
										entityToSpawn.moveTo((entityiterator.getX()), (entityiterator.getY() + 3), (entityiterator.getZ()), world.getRandom().nextFloat() * 360F, 0);
										if (entityToSpawn instanceof Mob _mobToSpawn)
											_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										world.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
						if (AttackType == 29) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							entityiterator.hurt(DamageSource.GENERIC, 4);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.imitate.wither")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.imitate.wither")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
						if (AttackType == 39) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
							entityiterator.setSecondsOnFire(5);
						}
						if (AttackType == 49) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 8));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
						if (AttackType == 59) {
							if (Herobrine instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
							if (Herobrine instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, (false), (false)));
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
							if (!(!world.getEntitiesOfClass(Creeper.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 5, 5, 5), e -> true).isEmpty())) {
								for (int index2 = 0; index2 < (int) (1); index2++) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
										entityToSpawn.moveTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ() + 2), world.getRandom().nextFloat() * 360F, 0);
										if (entityToSpawn instanceof Mob _mobToSpawn)
											_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										world.addFreshEntity(entityToSpawn);
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
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(false);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
