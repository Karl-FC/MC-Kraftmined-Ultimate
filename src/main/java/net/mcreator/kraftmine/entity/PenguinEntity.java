
package net.mcreator.kraftmine.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.material.Material;
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
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.kraftmine.procedures.PenguinSwimProcedure;
import net.mcreator.kraftmine.procedures.PenguinOnInitialEntitySpawnProcedure;
import net.mcreator.kraftmine.procedures.PenguinOnEntityTickUpdateProcedure;
import net.mcreator.kraftmine.procedures.PenguinGuntherProcedure;
import net.mcreator.kraftmine.procedures.PenguinFloatProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

import javax.annotation.Nullable;

public class PenguinEntity extends PathfinderMob {
	public PenguinEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(KraftmineModEntities.PENGUIN.get(), world);
	}

	public PenguinEntity(EntityType<PenguinEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
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
				Level world = PenguinEntity.this.level;
				return super.canUse() && PenguinGuntherProcedure.execute(entity);
			}
		}.setAlertOthers());
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level;
				return super.canUse() && PenguinGuntherProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(5, new FollowMobGoal(this, (float) 1, 10, 5));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level;
				return super.canUse() && PenguinFloatProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level;
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
				Level world = PenguinEntity.this.level;
				return super.canUse() && PenguinSwimProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PenguinEntity.this.getX();
				double y = PenguinEntity.this.getY();
				double z = PenguinEntity.this.getZ();
				Entity entity = PenguinEntity.this;
				Level world = PenguinEntity.this.level;
				return super.canContinueToUse() && PenguinSwimProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.SALMON));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:mob.penguin"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:mob.penguin"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		PenguinOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		PenguinOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
		SpawnPlacements.register(KraftmineModEntities.PENGUIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
