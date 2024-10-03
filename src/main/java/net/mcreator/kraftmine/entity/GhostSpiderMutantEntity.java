
package net.mcreator.kraftmine.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.MobDespawnAetherProcedure;
import net.mcreator.kraftmine.procedures.GhostSpiderMutantWalkProcedure;

import javax.annotation.Nullable;

import java.util.EnumSet;

public class GhostSpiderMutantEntity extends Monster {
	public GhostSpiderMutantEntity(EntityType<GhostSpiderMutantEntity> type, Level world) {
		super(type, world);
		xpReward = 25;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(2, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (GhostSpiderMutantEntity.this.getTarget() != null && !GhostSpiderMutantEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return GhostSpiderMutantEntity.this.getMoveControl().hasWanted() && GhostSpiderMutantEntity.this.getTarget() != null && GhostSpiderMutantEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = GhostSpiderMutantEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				GhostSpiderMutantEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 20);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = GhostSpiderMutantEntity.this.getTarget();
				if (GhostSpiderMutantEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					GhostSpiderMutantEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = GhostSpiderMutantEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						GhostSpiderMutantEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 20);
					}
				}
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 5, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = GhostSpiderMutantEntity.this.getRandom();
				double dir_x = GhostSpiderMutantEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = GhostSpiderMutantEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = GhostSpiderMutantEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 1));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.9) {
			@Override
			public boolean canUse() {
				double x = GhostSpiderMutantEntity.this.getX();
				double y = GhostSpiderMutantEntity.this.getY();
				double z = GhostSpiderMutantEntity.this.getZ();
				Entity entity = GhostSpiderMutantEntity.this;
				Level world = GhostSpiderMutantEntity.this.level();
				return super.canUse() && GhostSpiderMutantWalkProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GhostSpiderMutantEntity.this.getX();
				double y = GhostSpiderMutantEntity.this.getY();
				double z = GhostSpiderMutantEntity.this.getZ();
				Entity entity = GhostSpiderMutantEntity.this;
				Level world = GhostSpiderMutantEntity.this.level();
				return super.canContinueToUse() && GhostSpiderMutantWalkProcedure.execute(world, x, y, z);
			}
		});
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:eye.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:eye.hurts"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:eye.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		MobDespawnAetherProcedure.execute(this);
		return retval;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 1);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
		builder = builder.add(Attributes.FLYING_SPEED, 0.4);
		return builder;
	}
}
