
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmine.entity.ZombiePigManEntity;
import net.mcreator.kraftmine.entity.WaspEntity;
import net.mcreator.kraftmine.entity.TrollgeLvl3Entity;
import net.mcreator.kraftmine.entity.TrollgeLvl2Entity;
import net.mcreator.kraftmine.entity.TrollEntity;
import net.mcreator.kraftmine.entity.TomatoShurikenProjectileEntity;
import net.mcreator.kraftmine.entity.TheSwitcherProjectileEntity;
import net.mcreator.kraftmine.entity.TestDummyEntity;
import net.mcreator.kraftmine.entity.StonespearProjectileEntity;
import net.mcreator.kraftmine.entity.StoneSpearThrownEntity;
import net.mcreator.kraftmine.entity.StickHorseEntity;
import net.mcreator.kraftmine.entity.SleuthEntity;
import net.mcreator.kraftmine.entity.SkeleturtleEntityProjectile;
import net.mcreator.kraftmine.entity.SkeleturtleEntity;
import net.mcreator.kraftmine.entity.SirenheadEntity;
import net.mcreator.kraftmine.entity.ShrooMooEntity;
import net.mcreator.kraftmine.entity.SeedMachineGunProjectileEntity;
import net.mcreator.kraftmine.entity.RangedTomatoProjectileEntity;
import net.mcreator.kraftmine.entity.PrimalDragonEntity;
import net.mcreator.kraftmine.entity.PopCornProjectileEntity;
import net.mcreator.kraftmine.entity.PlagueWitchEntity;
import net.mcreator.kraftmine.entity.PenguinbigEntity;
import net.mcreator.kraftmine.entity.PenguinEntity;
import net.mcreator.kraftmine.entity.ParasEntity;
import net.mcreator.kraftmine.entity.NootnootEntity;
import net.mcreator.kraftmine.entity.NoobEntity;
import net.mcreator.kraftmine.entity.Nextbot9Entity;
import net.mcreator.kraftmine.entity.Nextbot8Entity;
import net.mcreator.kraftmine.entity.Nextbot7Entity;
import net.mcreator.kraftmine.entity.Nextbot6Entity;
import net.mcreator.kraftmine.entity.Nextbot5Entity;
import net.mcreator.kraftmine.entity.Nextbot4Entity;
import net.mcreator.kraftmine.entity.Nextbot3Entity;
import net.mcreator.kraftmine.entity.Nextbot2Entity;
import net.mcreator.kraftmine.entity.Nextbot1Entity;
import net.mcreator.kraftmine.entity.Nextbot11Entity;
import net.mcreator.kraftmine.entity.Nextbot10Entity;
import net.mcreator.kraftmine.entity.MobShadeEntity;
import net.mcreator.kraftmine.entity.MobFloatingEyeEntity;
import net.mcreator.kraftmine.entity.MobBigEntity;
import net.mcreator.kraftmine.entity.MobAmogusGreyEntity;
import net.mcreator.kraftmine.entity.MobAmogusGreenEntity;
import net.mcreator.kraftmine.entity.MobAmogusEntity;
import net.mcreator.kraftmine.entity.MobAmogusBlueEntity;
import net.mcreator.kraftmine.entity.MimicEntityEntity;
import net.mcreator.kraftmine.entity.MickeyEntity;
import net.mcreator.kraftmine.entity.MeteoriteProjectileEntity;
import net.mcreator.kraftmine.entity.MPPotatoProjectileEntity;
import net.mcreator.kraftmine.entity.LightningRodProjectileEntity;
import net.mcreator.kraftmine.entity.JockeyTowerEntity;
import net.mcreator.kraftmine.entity.IronSpearProjectileEntity;
import net.mcreator.kraftmine.entity.IronSpearEntityEntity;
import net.mcreator.kraftmine.entity.IronDroidEntity;
import net.mcreator.kraftmine.entity.IceologerEntity;
import net.mcreator.kraftmine.entity.IceWandProjectileEntity;
import net.mcreator.kraftmine.entity.HerobrineEntity;
import net.mcreator.kraftmine.entity.GooseEntity;
import net.mcreator.kraftmine.entity.GiantSquidEntity;
import net.mcreator.kraftmine.entity.GiantAIEntity;
import net.mcreator.kraftmine.entity.GhostSpiderMutantEntity;
import net.mcreator.kraftmine.entity.GhostSpiderEntity;
import net.mcreator.kraftmine.entity.GeneralEntity;
import net.mcreator.kraftmine.entity.FrozenZombieEntity;
import net.mcreator.kraftmine.entity.FireScepterProjectileEntity;
import net.mcreator.kraftmine.entity.EntityBodEntity;
import net.mcreator.kraftmine.entity.DuckEntity;
import net.mcreator.kraftmine.entity.CreepestEntity;
import net.mcreator.kraftmine.entity.CreepEntity;
import net.mcreator.kraftmine.entity.CocaColaGrenadeProjectileEntity;
import net.mcreator.kraftmine.entity.ChomperEntity;
import net.mcreator.kraftmine.entity.CatfishEntity;
import net.mcreator.kraftmine.entity.BuffalobabyEntity;
import net.mcreator.kraftmine.entity.BuffaloEntity;
import net.mcreator.kraftmine.entity.BladeRazorProjectileEntity;
import net.mcreator.kraftmine.entity.BladeOfDespairProjectileEntity;
import net.mcreator.kraftmine.entity.BeetzookaProjectileEntity;
import net.mcreator.kraftmine.entity.BeetsniperProjectileEntity;
import net.mcreator.kraftmine.entity.AnomalyEntity;
import net.mcreator.kraftmine.entity.AmongamiteEntity;
import net.mcreator.kraftmine.KraftmineMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KraftmineModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, KraftmineMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<MobAmogusEntity>> MOB_AMOGUS = register("mob_amogus",
			EntityType.Builder.<MobAmogusEntity>of(MobAmogusEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SirenheadEntity>> SIRENHEAD = register("sirenhead",
			EntityType.Builder.<SirenheadEntity>of(SirenheadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GooseEntity>> GOOSE = register("goose",
			EntityType.Builder.<GooseEntity>of(GooseEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MimicEntityEntity>> MIMIC_ENTITY = register("mimic_entity",
			EntityType.Builder.<MimicEntityEntity>of(MimicEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostSpiderEntity>> GHOST_SPIDER = register("ghost_spider",
			EntityType.Builder.<GhostSpiderEntity>of(GhostSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3)

					.sized(1.6f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<MickeyEntity>> MICKEY = register("mickey",
			EntityType.Builder.<MickeyEntity>of(MickeyEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantAIEntity>> GIANT_AI = register("giant_ai",
			EntityType.Builder.<GiantAIEntity>of(GiantAIEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(7.5f, 16f));
	public static final DeferredHolder<EntityType<?>, EntityType<EntityBodEntity>> ENTITY_BOD = register("entity_bod",
			EntityType.Builder.<EntityBodEntity>of(EntityBodEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3)

					.sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobAmogusBlueEntity>> MOB_AMOGUS_BLUE = register("mob_amogus_blue",
			EntityType.Builder.<MobAmogusBlueEntity>of(MobAmogusBlueEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobAmogusGreyEntity>> MOB_AMOGUS_GREY = register("mob_amogus_grey",
			EntityType.Builder.<MobAmogusGreyEntity>of(MobAmogusGreyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobAmogusGreenEntity>> MOB_AMOGUS_GREEN = register("mob_amogus_green",
			EntityType.Builder.<MobAmogusGreenEntity>of(MobAmogusGreenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobBigEntity>> MOB_BIG = register("mob_big",
			EntityType.Builder.<MobBigEntity>of(MobBigEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobFloatingEyeEntity>> MOB_FLOATING_EYE = register("mob_floating_eye",
			EntityType.Builder.<MobFloatingEyeEntity>of(MobFloatingEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MobShadeEntity>> MOB_SHADE = register("mob_shade",
			EntityType.Builder.<MobShadeEntity>of(MobShadeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.7f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ZombiePigManEntity>> ZOMBIE_PIG_MAN = register("zombie_pig_man",
			EntityType.Builder.<ZombiePigManEntity>of(ZombiePigManEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TestDummyEntity>> TEST_DUMMY = register("test_dummy",
			EntityType.Builder.<TestDummyEntity>of(TestDummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GeneralEntity>> GENERAL = register("general",
			EntityType.Builder.<GeneralEntity>of(GeneralEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(3.2f, 4.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrollEntity>> TROLL = register("troll",
			EntityType.Builder.<TrollEntity>of(TrollEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrollgeLvl2Entity>> TROLLGE_LVL_2 = register("trollge_lvl_2",
			EntityType.Builder.<TrollgeLvl2Entity>of(TrollgeLvl2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(20f, 20f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrollgeLvl3Entity>> TROLLGE_LVL_3 = register("trollge_lvl_3",
			EntityType.Builder.<TrollgeLvl3Entity>of(TrollgeLvl3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().sized(20f, 30f));
	public static final DeferredHolder<EntityType<?>, EntityType<NoobEntity>> NOOB = register("noob",
			EntityType.Builder.<NoobEntity>of(NoobEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShrooMooEntity>> SHROO_MOO = register("shroo_moo",
			EntityType.Builder.<ShrooMooEntity>of(ShrooMooEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimalDragonEntity>> PRIMAL_DRAGON = register("primal_dragon",
			EntityType.Builder.<PrimalDragonEntity>of(PrimalDragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuffaloEntity>> BUFFALO = register("buffalo",
			EntityType.Builder.<BuffaloEntity>of(BuffaloEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<AnomalyEntity>> ANOMALY = register("anomaly",
			EntityType.Builder.<AnomalyEntity>of(AnomalyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.7f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SleuthEntity>> SLEUTH = register("sleuth",
			EntityType.Builder.<SleuthEntity>of(SleuthEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3)

					.sized(3f, 2.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuffalobabyEntity>> BUFFALOBABY = register("buffalobaby",
			EntityType.Builder.<BuffalobabyEntity>of(BuffalobabyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<HerobrineEntity>> HEROBRINE = register("herobrine",
			EntityType.Builder.<HerobrineEntity>of(HerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.7f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<PenguinEntity>> PENGUIN = register("penguin",
			EntityType.Builder.<PenguinEntity>of(PenguinEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<IceologerEntity>> ICEOLOGER = register("iceologer",
			EntityType.Builder.<IceologerEntity>of(IceologerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.7f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<NootnootEntity>> NOOTNOOT = register("nootnoot",
			EntityType.Builder.<NootnootEntity>of(NootnootEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2.5f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<PenguinbigEntity>> PENGUINBIG = register("penguinbig",
			EntityType.Builder.<PenguinbigEntity>of(PenguinbigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<ParasEntity>> PARAS = register("paras",
			EntityType.Builder.<ParasEntity>of(ParasEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostSpiderMutantEntity>> GHOST_SPIDER_MUTANT = register("ghost_spider_mutant",
			EntityType.Builder.<GhostSpiderMutantEntity>of(GhostSpiderMutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3)

					.sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot1Entity>> NEXTBOT_1 = register("nextbot_1",
			EntityType.Builder.<Nextbot1Entity>of(Nextbot1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot2Entity>> NEXTBOT_2 = register("nextbot_2",
			EntityType.Builder.<Nextbot2Entity>of(Nextbot2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot3Entity>> NEXTBOT_3 = register("nextbot_3",
			EntityType.Builder.<Nextbot3Entity>of(Nextbot3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot4Entity>> NEXTBOT_4 = register("nextbot_4",
			EntityType.Builder.<Nextbot4Entity>of(Nextbot4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot5Entity>> NEXTBOT_5 = register("nextbot_5",
			EntityType.Builder.<Nextbot5Entity>of(Nextbot5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot6Entity>> NEXTBOT_6 = register("nextbot_6",
			EntityType.Builder.<Nextbot6Entity>of(Nextbot6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot7Entity>> NEXTBOT_7 = register("nextbot_7",
			EntityType.Builder.<Nextbot7Entity>of(Nextbot7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot8Entity>> NEXTBOT_8 = register("nextbot_8",
			EntityType.Builder.<Nextbot8Entity>of(Nextbot8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot9Entity>> NEXTBOT_9 = register("nextbot_9",
			EntityType.Builder.<Nextbot9Entity>of(Nextbot9Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(2f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot10Entity>> NEXTBOT_10 = register("nextbot_10",
			EntityType.Builder.<Nextbot10Entity>of(Nextbot10Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<Nextbot11Entity>> NEXTBOT_11 = register("nextbot_11",
			EntityType.Builder.<Nextbot11Entity>of(Nextbot11Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).fireImmune().sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<WaspEntity>> WASP = register("wasp", EntityType.Builder.<WaspEntity>of(WaspEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.5f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<StickHorseEntity>> STICK_HORSE = register("stick_horse",
			EntityType.Builder.<StickHorseEntity>of(StickHorseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantSquidEntity>> GIANT_SQUID = register("giant_squid",
			EntityType.Builder.<GiantSquidEntity>of(GiantSquidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(4f, 4f));
	public static final DeferredHolder<EntityType<?>, EntityType<CatfishEntity>> CATFISH = register("catfish",
			EntityType.Builder.<CatfishEntity>of(CatfishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SkeleturtleEntity>> SKELETURTLE = register("skeleturtle",
			EntityType.Builder.<SkeleturtleEntity>of(SkeleturtleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SkeleturtleEntityProjectile>> SKELETURTLE_PROJECTILE = register("projectile_skeleturtle",
			EntityType.Builder.<SkeleturtleEntityProjectile>of(SkeleturtleEntityProjectile::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmongamiteEntity>> AMONGAMITE = register("amongamite",
			EntityType.Builder.<AmongamiteEntity>of(AmongamiteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronDroidEntity>> IRON_DROID = register("iron_droid",
			EntityType.Builder.<IronDroidEntity>of(IronDroidEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<PlagueWitchEntity>> PLAGUE_WITCH = register("plague_witch",
			EntityType.Builder.<PlagueWitchEntity>of(PlagueWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<CreepestEntity>> CREEPIEST = register("creepiest",
			EntityType.Builder.<CreepestEntity>of(CreepestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<DuckEntity>> DUCK = register("duck",
			EntityType.Builder.<DuckEntity>of(DuckEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<CreepEntity>> CREEP = register("creep",
			EntityType.Builder.<CreepEntity>of(CreepEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.4f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<ChomperEntity>> CHOMPER = register("chomper",
			EntityType.Builder.<ChomperEntity>of(ChomperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FrozenZombieEntity>> FROZEN_ZOMBIE = register("frozen_zombie",
			EntityType.Builder.<FrozenZombieEntity>of(FrozenZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<StoneSpearThrownEntity>> STONE_SPEAR_THROWN = register("stone_spear_thrown",
			EntityType.Builder.<StoneSpearThrownEntity>of(StoneSpearThrownEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronSpearEntityEntity>> IRON_SPEAR_ENTITY = register("iron_spear_entity",
			EntityType.Builder.<IronSpearEntityEntity>of(IronSpearEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<JockeyTowerEntity>> JOCKEY_TOWER = register("jockey_tower",
			EntityType.Builder.<JockeyTowerEntity>of(JockeyTowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<RangedTomatoProjectileEntity>> RANGED_TOMATO_PROJECTILE = register("ranged_tomato_projectile",
			EntityType.Builder.<RangedTomatoProjectileEntity>of(RangedTomatoProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BladeRazorProjectileEntity>> BLADE_RAZOR_PROJECTILE = register("blade_razor_projectile",
			EntityType.Builder.<BladeRazorProjectileEntity>of(BladeRazorProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BladeOfDespairProjectileEntity>> BLADE_OF_DESPAIR_PROJECTILE = register("blade_of_despair_projectile",
			EntityType.Builder.<BladeOfDespairProjectileEntity>of(BladeOfDespairProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PopCornProjectileEntity>> POP_CORN_PROJECTILE = register("pop_corn_projectile",
			EntityType.Builder.<PopCornProjectileEntity>of(PopCornProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeedMachineGunProjectileEntity>> SEED_MACHINE_GUN_PROJECTILE = register("seed_machine_gun_projectile",
			EntityType.Builder.<SeedMachineGunProjectileEntity>of(SeedMachineGunProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MeteoriteProjectileEntity>> METEORITE_PROJECTILE = register("meteorite_projectile",
			EntityType.Builder.<MeteoriteProjectileEntity>of(MeteoriteProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StonespearProjectileEntity>> STONESPEAR_PROJECTILE = register("stonespear_projectile",
			EntityType.Builder.<StonespearProjectileEntity>of(StonespearProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CocaColaGrenadeProjectileEntity>> COCA_COLA_GRENADE_PROJECTILE = register("coca_cola_grenade_projectile",
			EntityType.Builder.<CocaColaGrenadeProjectileEntity>of(CocaColaGrenadeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IronSpearProjectileEntity>> IRON_SPEAR_PROJECTILE = register("iron_spear_projectile",
			EntityType.Builder.<IronSpearProjectileEntity>of(IronSpearProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MPPotatoProjectileEntity>> MP_POTATO_PROJECTILE = register("mp_potato_projectile",
			EntityType.Builder.<MPPotatoProjectileEntity>of(MPPotatoProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BeetzookaProjectileEntity>> BEETZOOKA_PROJECTILE = register("beetzooka_projectile",
			EntityType.Builder.<BeetzookaProjectileEntity>of(BeetzookaProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TomatoShurikenProjectileEntity>> TOMATO_SHURIKEN_PROJECTILE = register("tomato_shuriken_projectile",
			EntityType.Builder.<TomatoShurikenProjectileEntity>of(TomatoShurikenProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BeetsniperProjectileEntity>> BEETSNIPER_PROJECTILE = register("beetsniper_projectile",
			EntityType.Builder.<BeetsniperProjectileEntity>of(BeetsniperProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IceWandProjectileEntity>> ICE_WAND_PROJECTILE = register("ice_wand_projectile",
			EntityType.Builder.<IceWandProjectileEntity>of(IceWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightningRodProjectileEntity>> LIGHTNING_ROD_PROJECTILE = register("lightning_rod_projectile",
			EntityType.Builder.<LightningRodProjectileEntity>of(LightningRodProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireScepterProjectileEntity>> FIRE_SCEPTER_PROJECTILE = register("fire_scepter_projectile",
			EntityType.Builder.<FireScepterProjectileEntity>of(FireScepterProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TheSwitcherProjectileEntity>> THE_SWITCHER_PROJECTILE = register("the_switcher_projectile",
			EntityType.Builder.<TheSwitcherProjectileEntity>of(TheSwitcherProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		MobAmogusEntity.init(event);
		SirenheadEntity.init(event);
		GooseEntity.init(event);
		MimicEntityEntity.init(event);
		GhostSpiderEntity.init(event);
		MickeyEntity.init(event);
		GiantAIEntity.init(event);
		EntityBodEntity.init(event);
		MobAmogusBlueEntity.init(event);
		MobAmogusGreyEntity.init(event);
		MobAmogusGreenEntity.init(event);
		MobBigEntity.init(event);
		MobFloatingEyeEntity.init(event);
		MobShadeEntity.init(event);
		ZombiePigManEntity.init(event);
		TestDummyEntity.init(event);
		GeneralEntity.init(event);
		TrollEntity.init(event);
		TrollgeLvl2Entity.init(event);
		TrollgeLvl3Entity.init(event);
		NoobEntity.init(event);
		ShrooMooEntity.init(event);
		PrimalDragonEntity.init(event);
		BuffaloEntity.init(event);
		AnomalyEntity.init(event);
		SleuthEntity.init(event);
		BuffalobabyEntity.init(event);
		HerobrineEntity.init(event);
		PenguinEntity.init(event);
		IceologerEntity.init(event);
		NootnootEntity.init(event);
		PenguinbigEntity.init(event);
		ParasEntity.init(event);
		GhostSpiderMutantEntity.init(event);
		Nextbot1Entity.init(event);
		Nextbot2Entity.init(event);
		Nextbot3Entity.init(event);
		Nextbot4Entity.init(event);
		Nextbot5Entity.init(event);
		Nextbot6Entity.init(event);
		Nextbot7Entity.init(event);
		Nextbot8Entity.init(event);
		Nextbot9Entity.init(event);
		Nextbot10Entity.init(event);
		Nextbot11Entity.init(event);
		WaspEntity.init(event);
		StickHorseEntity.init(event);
		GiantSquidEntity.init(event);
		CatfishEntity.init(event);
		SkeleturtleEntity.init(event);
		AmongamiteEntity.init(event);
		IronDroidEntity.init(event);
		PlagueWitchEntity.init(event);
		CreepestEntity.init(event);
		DuckEntity.init(event);
		CreepEntity.init(event);
		ChomperEntity.init(event);
		FrozenZombieEntity.init(event);
		StoneSpearThrownEntity.init(event);
		IronSpearEntityEntity.init(event);
		JockeyTowerEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MOB_AMOGUS.get(), MobAmogusEntity.createAttributes().build());
		event.put(SIRENHEAD.get(), SirenheadEntity.createAttributes().build());
		event.put(GOOSE.get(), GooseEntity.createAttributes().build());
		event.put(MIMIC_ENTITY.get(), MimicEntityEntity.createAttributes().build());
		event.put(GHOST_SPIDER.get(), GhostSpiderEntity.createAttributes().build());
		event.put(MICKEY.get(), MickeyEntity.createAttributes().build());
		event.put(GIANT_AI.get(), GiantAIEntity.createAttributes().build());
		event.put(ENTITY_BOD.get(), EntityBodEntity.createAttributes().build());
		event.put(MOB_AMOGUS_BLUE.get(), MobAmogusBlueEntity.createAttributes().build());
		event.put(MOB_AMOGUS_GREY.get(), MobAmogusGreyEntity.createAttributes().build());
		event.put(MOB_AMOGUS_GREEN.get(), MobAmogusGreenEntity.createAttributes().build());
		event.put(MOB_BIG.get(), MobBigEntity.createAttributes().build());
		event.put(MOB_FLOATING_EYE.get(), MobFloatingEyeEntity.createAttributes().build());
		event.put(MOB_SHADE.get(), MobShadeEntity.createAttributes().build());
		event.put(ZOMBIE_PIG_MAN.get(), ZombiePigManEntity.createAttributes().build());
		event.put(TEST_DUMMY.get(), TestDummyEntity.createAttributes().build());
		event.put(GENERAL.get(), GeneralEntity.createAttributes().build());
		event.put(TROLL.get(), TrollEntity.createAttributes().build());
		event.put(TROLLGE_LVL_2.get(), TrollgeLvl2Entity.createAttributes().build());
		event.put(TROLLGE_LVL_3.get(), TrollgeLvl3Entity.createAttributes().build());
		event.put(NOOB.get(), NoobEntity.createAttributes().build());
		event.put(SHROO_MOO.get(), ShrooMooEntity.createAttributes().build());
		event.put(PRIMAL_DRAGON.get(), PrimalDragonEntity.createAttributes().build());
		event.put(BUFFALO.get(), BuffaloEntity.createAttributes().build());
		event.put(ANOMALY.get(), AnomalyEntity.createAttributes().build());
		event.put(SLEUTH.get(), SleuthEntity.createAttributes().build());
		event.put(BUFFALOBABY.get(), BuffalobabyEntity.createAttributes().build());
		event.put(HEROBRINE.get(), HerobrineEntity.createAttributes().build());
		event.put(PENGUIN.get(), PenguinEntity.createAttributes().build());
		event.put(ICEOLOGER.get(), IceologerEntity.createAttributes().build());
		event.put(NOOTNOOT.get(), NootnootEntity.createAttributes().build());
		event.put(PENGUINBIG.get(), PenguinbigEntity.createAttributes().build());
		event.put(PARAS.get(), ParasEntity.createAttributes().build());
		event.put(GHOST_SPIDER_MUTANT.get(), GhostSpiderMutantEntity.createAttributes().build());
		event.put(NEXTBOT_1.get(), Nextbot1Entity.createAttributes().build());
		event.put(NEXTBOT_2.get(), Nextbot2Entity.createAttributes().build());
		event.put(NEXTBOT_3.get(), Nextbot3Entity.createAttributes().build());
		event.put(NEXTBOT_4.get(), Nextbot4Entity.createAttributes().build());
		event.put(NEXTBOT_5.get(), Nextbot5Entity.createAttributes().build());
		event.put(NEXTBOT_6.get(), Nextbot6Entity.createAttributes().build());
		event.put(NEXTBOT_7.get(), Nextbot7Entity.createAttributes().build());
		event.put(NEXTBOT_8.get(), Nextbot8Entity.createAttributes().build());
		event.put(NEXTBOT_9.get(), Nextbot9Entity.createAttributes().build());
		event.put(NEXTBOT_10.get(), Nextbot10Entity.createAttributes().build());
		event.put(NEXTBOT_11.get(), Nextbot11Entity.createAttributes().build());
		event.put(WASP.get(), WaspEntity.createAttributes().build());
		event.put(STICK_HORSE.get(), StickHorseEntity.createAttributes().build());
		event.put(GIANT_SQUID.get(), GiantSquidEntity.createAttributes().build());
		event.put(CATFISH.get(), CatfishEntity.createAttributes().build());
		event.put(SKELETURTLE.get(), SkeleturtleEntity.createAttributes().build());
		event.put(AMONGAMITE.get(), AmongamiteEntity.createAttributes().build());
		event.put(IRON_DROID.get(), IronDroidEntity.createAttributes().build());
		event.put(PLAGUE_WITCH.get(), PlagueWitchEntity.createAttributes().build());
		event.put(CREEPIEST.get(), CreepestEntity.createAttributes().build());
		event.put(DUCK.get(), DuckEntity.createAttributes().build());
		event.put(CREEP.get(), CreepEntity.createAttributes().build());
		event.put(CHOMPER.get(), ChomperEntity.createAttributes().build());
		event.put(FROZEN_ZOMBIE.get(), FrozenZombieEntity.createAttributes().build());
		event.put(STONE_SPEAR_THROWN.get(), StoneSpearThrownEntity.createAttributes().build());
		event.put(IRON_SPEAR_ENTITY.get(), IronSpearEntityEntity.createAttributes().build());
		event.put(JOCKEY_TOWER.get(), JockeyTowerEntity.createAttributes().build());
	}
}
