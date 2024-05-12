
package net.mcreator.kraftmine.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.kraftmine.procedures.MimicmoveconditionProcedure;
import net.mcreator.kraftmine.procedures.MimicEntityThisEntityKillsAnotherOneProcedure;
import net.mcreator.kraftmine.procedures.MimicEntityRightClickedOnEntityProcedure;
import net.mcreator.kraftmine.procedures.MimicEntityOnEntityTickUpdateProcedure;
import net.mcreator.kraftmine.procedures.MimicEntityInitialSpawnProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

import javax.annotation.Nullable;

import java.util.EnumSet;

public class MimicEntityEntity extends Monster {
	public MimicEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(KraftmineModEntities.MIMIC_ENTITY.get(), world);
	}

	public MimicEntityEntity(EntityType<MimicEntityEntity> type, Level world) {
		super(type, world);
		xpReward = 15;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (MimicEntityEntity.this.getTarget() != null && !MimicEntityEntity.this.getMoveControl().hasWanted()) {
					double x = MimicEntityEntity.this.getX();
					double y = MimicEntityEntity.this.getY();
					double z = MimicEntityEntity.this.getZ();
					Entity entity = MimicEntityEntity.this;
					return MimicmoveconditionProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return MimicEntityEntity.this.getMoveControl().hasWanted() && MimicEntityEntity.this.getTarget() != null && MimicEntityEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = MimicEntityEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				MimicEntityEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = MimicEntityEntity.this.getTarget();
				if (MimicEntityEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					MimicEntityEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = MimicEntityEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						MimicEntityEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = MimicEntityEntity.this.getRandom();
				double dir_x = MimicEntityEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = MimicEntityEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = MimicEntityEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

			@Override
			public boolean canUse() {
				double x = MimicEntityEntity.this.getX();
				double y = MimicEntityEntity.this.getY();
				double z = MimicEntityEntity.this.getZ();
				Entity entity = MimicEntityEntity.this;
				Level world = MimicEntityEntity.this.level;
				return super.canUse() && MimicmoveconditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = MimicEntityEntity.this.getX();
				double y = MimicEntityEntity.this.getY();
				double z = MimicEntityEntity.this.getZ();
				Entity entity = MimicEntityEntity.this;
				Level world = MimicEntityEntity.this.level;
				return super.canUse() && MimicmoveconditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = MimicEntityEntity.this.getX();
				double y = MimicEntityEntity.this.getY();
				double z = MimicEntityEntity.this.getZ();
				Entity entity = MimicEntityEntity.this;
				Level world = MimicEntityEntity.this.level;
				return super.canUse() && MimicmoveconditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ender_chest.open"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ender_chest.close"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		MimicmoveconditionProcedure.execute(this);
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		MimicEntityInitialSpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;

		MimicEntityRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		MimicEntityThisEntityKillsAnotherOneProcedure.execute(entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MimicEntityOnEntityTickUpdateProcedure.execute(this);
	}

	public static void init() {
		SpawnPlacements.register(KraftmineModEntities.MIMIC_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
		DungeonHooks.addDungeonMob(KraftmineModEntities.MIMIC_ENTITY.get(), 180);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.30000000000000004);
		return builder;
	}
}
