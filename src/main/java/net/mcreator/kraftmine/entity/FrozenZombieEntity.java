
package net.mcreator.kraftmine.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.kraftmine.procedures.FrozenZombieRunConditionProcedure;
import net.mcreator.kraftmine.procedures.FrozenZombieOnEntityTickUpdateProcedure;
import net.mcreator.kraftmine.procedures.FrozenZombieAttackConditionProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

public class FrozenZombieEntity extends Monster {
	public FrozenZombieEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(KraftmineModEntities.FROZEN_ZOMBIE.get(), world);
	}

	public FrozenZombieEntity(EntityType<FrozenZombieEntity> type, Level world) {
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
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, (float) 2, 0.4, 0.3) {
			@Override
			public boolean canUse() {
				double x = FrozenZombieEntity.this.getX();
				double y = FrozenZombieEntity.this.getY();
				double z = FrozenZombieEntity.this.getZ();
				Entity entity = FrozenZombieEntity.this;
				Level world = FrozenZombieEntity.this.level;
				return super.canUse() && FrozenZombieRunConditionProcedure.execute(world, entity);
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.3, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = FrozenZombieEntity.this.getX();
				double y = FrozenZombieEntity.this.getY();
				double z = FrozenZombieEntity.this.getZ();
				Entity entity = FrozenZombieEntity.this;
				Level world = FrozenZombieEntity.this.level;
				return super.canUse() && FrozenZombieAttackConditionProcedure.execute(world, x, y, z);
			}

		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = FrozenZombieEntity.this.getX();
				double y = FrozenZombieEntity.this.getY();
				double z = FrozenZombieEntity.this.getZ();
				Entity entity = FrozenZombieEntity.this;
				Level world = FrozenZombieEntity.this.level;
				return super.canUse() && FrozenZombieAttackConditionProcedure.execute(world, x, y, z);
			}
		});
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new BreakDoorGoal(this, e -> true));
		this.goalSelector.addGoal(8, new RestrictSunGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.ROTTEN_FLESH));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.death"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		FrozenZombieOnEntityTickUpdateProcedure.execute(this.level, this);
	}

	public static void init() {
		SpawnPlacements.register(KraftmineModEntities.FROZEN_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 20);
		return builder;
	}
}
