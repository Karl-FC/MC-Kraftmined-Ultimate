
package net.mcreator.kraftmine.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.kraftmine.procedures.ChomperOnEntityTickUpdateProcedure;
import net.mcreator.kraftmine.init.KraftmineModEntities;

public class ChomperEntity extends Monster {
	public ChomperEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(KraftmineModEntities.CHOMPER.get(), world);
	}

	public ChomperEntity(EntityType<ChomperEntity> type, Level world) {
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
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Mob.class, false, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, FlyingMob.class, false, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Villager.class, false, true));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
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
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vindicator.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ChomperOnEntityTickUpdateProcedure.execute(this);
	}

	public static void init() {
		SpawnPlacements.register(KraftmineModEntities.CHOMPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.1);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0.2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 4);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		return builder;
	}
}
