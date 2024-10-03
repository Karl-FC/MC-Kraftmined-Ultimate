
package net.mcreator.kraftmine.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmine.procedures.PenguinSwimProcedure;
import net.mcreator.kraftmine.procedures.PenguinOnInitialEntitySpawnProcedure;
import net.mcreator.kraftmine.procedures.PenguinOnEntityTickUpdateProcedure;
import net.mcreator.kraftmine.procedures.PenguinGuntherProcedure;
import net.mcreator.kraftmine.procedures.PenguinFloatProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

import javax.annotation.Nullable;

public class PenguinEntity extends PathfinderMob {
	public PenguinEntity(EntityType<PenguinEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canUse() && PenguinGuntherProcedure.execute(entity);
			}
		}.setAlertOthers());
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canUse() && PenguinGuntherProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(5, new FollowMobGoal(this, 1, (float) 10, (float) 5));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canUse() && PenguinFloatProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canContinueToUse() && PenguinFloatProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new RandomSwimmingGoal(this, 1, 40) {
			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canUse() && PenguinSwimProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level();
				return super.canContinueToUse() && PenguinSwimProcedure.execute(entity);
			}
		});
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.SALMON));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:mob.penguin"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:mob.penguin"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		PenguinOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		PenguinOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(KraftmineModEntities.PENGUIN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
