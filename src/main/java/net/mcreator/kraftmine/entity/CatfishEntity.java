
package net.mcreator.kraftmine.entity;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmine.procedures.WaterMobNaturalEntitySpawningConditionProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

public class CatfishEntity extends Monster {
	public CatfishEntity(EntityType<CatfishEntity> type, Level world) {
		super(type, world);
		xpReward = 5;
		setNoAi(false);
		this.setPathfindingMalus(PathType.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (CatfishEntity.this.isInWater())
					CatfishEntity.this.setDeltaMovement(CatfishEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !CatfishEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - CatfishEntity.this.getX();
					double dy = this.wantedY - CatfishEntity.this.getY();
					double dz = this.wantedZ - CatfishEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * CatfishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					CatfishEntity.this.setYRot(this.rotlerp(CatfishEntity.this.getYRot(), f, 10));
					CatfishEntity.this.yBodyRot = CatfishEntity.this.getYRot();
					CatfishEntity.this.yHeadRot = CatfishEntity.this.getYRot();
					if (CatfishEntity.this.isInWater()) {
						CatfishEntity.this.setSpeed((float) CatfishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						CatfishEntity.this.setXRot(this.rotlerp(CatfishEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(CatfishEntity.this.getXRot() * (float) (Math.PI / 180.0));
						CatfishEntity.this.setZza(f3 * f1);
						CatfishEntity.this.setYya((float) (f1 * dy));
					} else {
						CatfishEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					CatfishEntity.this.setSpeed(0);
					CatfishEntity.this.setYya(0);
					CatfishEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 3, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, FishingHook.class, true, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Cod.class, true, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, WaterAnimal.class, true, true));
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(6, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float f) {
		return super.getPassengerAttachmentPoint(entity, dimensions, f).add(0, 4f, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.COD));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.stray_ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.hiss"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.death"));
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(KraftmineModEntities.CATFISH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return WaterMobNaturalEntitySpawningConditionProcedure.execute();
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		builder = builder.add(NeoForgeMod.SWIM_SPEED, 0.4);
		return builder;
	}
}
