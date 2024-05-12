package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.TrollgeLvl3Entity;
import net.mcreator.kraftmine.entity.MeteoriteEntity;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.Calendar;

public class TrollgeLvl3OnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestOpponent = null;
		double mickeyCD = 0;
		double AttackType = 0;
		if (entity instanceof TrollgeLvl3Entity) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				NearestOpponent = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				AttackType = Calendar.getInstance().get(Calendar.SECOND);
				if (AttackType == 10) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level;
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new MeteoriteEntity(KraftmineModEntities.METEORITE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 5);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					KraftmineMod.queueServerWork(20, () -> {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level;
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new MeteoriteEntity(KraftmineModEntities.METEORITE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 5, 5);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						KraftmineMod.queueServerWork(20, () -> {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level;
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new MeteoriteEntity(KraftmineModEntities.METEORITE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 5, 5);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						});
					});
				}
				if (AttackType == 20) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 2));
							KraftmineMod.queueServerWork(10, () -> {
								{
									Entity _ent = entityiterator;
									if (!_ent.level.isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null,
												4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "summon lightning_bolt");
									}
								}
								KraftmineMod.queueServerWork(10, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
								});
							});
						}
					}
				}
				if (AttackType == 30) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					if (NearestOpponent instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
				if (AttackType == 40) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.ambient")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
					}
				}
				if (AttackType == 50) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 5));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.celebrate")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						}
					}
				}
				if (AttackType == 59) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 255, (false), (false)));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 3, (false), (false)));
					if (NearestOpponent instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.break")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.splash_potion.break")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
