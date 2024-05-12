
package net.mcreator.kraftmine.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.kraftmine.procedures.WaterMobNaturalEntitySpawningConditionProcedure;
import net.mcreator.kraftmine.procedures.SkeleturtleWalkProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

public class SkeleturtleEntity extends Monster implements RangedAttackMob {
	public SkeleturtleEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(KraftmineModEntities.SKELETURTLE.get(), world);
	}

	public SkeleturtleEntity(EntityType<SkeleturtleEntity> type, Level world) {
		super(type, world);
		xpReward = 5;
		setNoAi(false);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (SkeleturtleEntity.this.isInWater())
					SkeleturtleEntity.this.setDeltaMovement(SkeleturtleEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !SkeleturtleEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - SkeleturtleEntity.this.getX();
					double dy = this.wantedY - SkeleturtleEntity.this.getY();
					double dz = this.wantedZ - SkeleturtleEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * SkeleturtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					SkeleturtleEntity.this.setYRot(this.rotlerp(SkeleturtleEntity.this.getYRot(), f, 10));
					SkeleturtleEntity.this.yBodyRot = SkeleturtleEntity.this.getYRot();
					SkeleturtleEntity.this.yHeadRot = SkeleturtleEntity.this.getYRot();
					if (SkeleturtleEntity.this.isInWater()) {
						SkeleturtleEntity.this.setSpeed((float) SkeleturtleEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						SkeleturtleEntity.this.setXRot(this.rotlerp(SkeleturtleEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(SkeleturtleEntity.this.getXRot() * (float) (Math.PI / 180.0));
						SkeleturtleEntity.this.setZza(f3 * f1);
						SkeleturtleEntity.this.setYya((float) (f1 * dy));
					} else {
						SkeleturtleEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					SkeleturtleEntity.this.setSpeed(0);
					SkeleturtleEntity.this.setYya(0);
					SkeleturtleEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1, 40));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.2) {
			@Override
			public boolean canUse() {
				double x = SkeleturtleEntity.this.getX();
				double y = SkeleturtleEntity.this.getY();
				double z = SkeleturtleEntity.this.getZ();
				Entity entity = SkeleturtleEntity.this;
				Level world = SkeleturtleEntity.this.level;
				return super.canUse() && SkeleturtleWalkProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SkeleturtleEntity.this.getX();
				double y = SkeleturtleEntity.this.getY();
				double z = SkeleturtleEntity.this.getZ();
				Entity entity = SkeleturtleEntity.this;
				Level world = SkeleturtleEntity.this.level;
				return super.canContinueToUse() && SkeleturtleWalkProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	@Override
	public double getPassengersRidingOffset() {
		return super.getPassengersRidingOffset() + 4;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.BONE));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.death"));
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		SkeleturtleEntityProjectile entityarrow = new SkeleturtleEntityProjectile(KraftmineModEntities.SKELETURTLE_PROJECTILE.get(), this, this.level);
		double d0 = target.getY() + target.getEyeHeight() - 1.1;
		double d1 = target.getX() - this.getX();
		double d3 = target.getZ() - this.getZ();
		entityarrow.shoot(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
		level.addFreshEntity(entityarrow);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	public static void init() {
		SpawnPlacements.register(KraftmineModEntities.SKELETURTLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return WaterMobNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);
		return builder;
	}
}
