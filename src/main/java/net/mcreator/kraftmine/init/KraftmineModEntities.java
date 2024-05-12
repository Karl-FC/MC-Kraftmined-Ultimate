
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.entity.ZombiePigManEntity;
import net.mcreator.kraftmine.entity.WaspEntity;
import net.mcreator.kraftmine.entity.TrollgeLvl3Entity;
import net.mcreator.kraftmine.entity.TrollgeLvl2Entity;
import net.mcreator.kraftmine.entity.TrollEntity;
import net.mcreator.kraftmine.entity.TomatoShurikenEntity;
import net.mcreator.kraftmine.entity.TheSwitcherEntity;
import net.mcreator.kraftmine.entity.TestDummyEntity;
import net.mcreator.kraftmine.entity.StonespearEntity;
import net.mcreator.kraftmine.entity.StoneSpearThrownEntity;
import net.mcreator.kraftmine.entity.StickHorseEntity;
import net.mcreator.kraftmine.entity.SleuthEntity;
import net.mcreator.kraftmine.entity.SkeleturtleEntityProjectile;
import net.mcreator.kraftmine.entity.SkeleturtleEntity;
import net.mcreator.kraftmine.entity.SirenheadEntity;
import net.mcreator.kraftmine.entity.ShrooMooEntity;
import net.mcreator.kraftmine.entity.SeedMachineGunEntity;
import net.mcreator.kraftmine.entity.RangedTomatoEntity;
import net.mcreator.kraftmine.entity.PrimalDragonEntity;
import net.mcreator.kraftmine.entity.PopCornEntity;
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
import net.mcreator.kraftmine.entity.MeteoriteEntity;
import net.mcreator.kraftmine.entity.MPPotatoEntity;
import net.mcreator.kraftmine.entity.LightningRodEntity;
import net.mcreator.kraftmine.entity.JockeyTowerEntity;
import net.mcreator.kraftmine.entity.IronSpearEntityEntity;
import net.mcreator.kraftmine.entity.IronSpearEntity;
import net.mcreator.kraftmine.entity.IronDroidEntity;
import net.mcreator.kraftmine.entity.IceologerEntity;
import net.mcreator.kraftmine.entity.IceWandEntity;
import net.mcreator.kraftmine.entity.HerobrineEntity;
import net.mcreator.kraftmine.entity.GooseEntity;
import net.mcreator.kraftmine.entity.GiantSquidEntity;
import net.mcreator.kraftmine.entity.GiantAIEntity;
import net.mcreator.kraftmine.entity.GhostSpiderMutantEntity;
import net.mcreator.kraftmine.entity.GhostSpiderEntity;
import net.mcreator.kraftmine.entity.GeneralEntity;
import net.mcreator.kraftmine.entity.FrozenZombieEntity;
import net.mcreator.kraftmine.entity.FireScepterEntity;
import net.mcreator.kraftmine.entity.EntityBodEntity;
import net.mcreator.kraftmine.entity.DuckEntity;
import net.mcreator.kraftmine.entity.CreepestEntity;
import net.mcreator.kraftmine.entity.CreepEntity;
import net.mcreator.kraftmine.entity.CocaColaGrenadeEntity;
import net.mcreator.kraftmine.entity.ChomperEntity;
import net.mcreator.kraftmine.entity.CatfishEntity;
import net.mcreator.kraftmine.entity.BuffalobabyEntity;
import net.mcreator.kraftmine.entity.BuffaloEntity;
import net.mcreator.kraftmine.entity.BladeRazorEntity;
import net.mcreator.kraftmine.entity.BladeOfDespairEntity;
import net.mcreator.kraftmine.entity.BeetzookaEntity;
import net.mcreator.kraftmine.entity.BeetsniperEntity;
import net.mcreator.kraftmine.entity.AnomalyEntity;
import net.mcreator.kraftmine.entity.AmongamiteEntity;
import net.mcreator.kraftmine.KraftmineMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KraftmineModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KraftmineMod.MODID);
	public static final RegistryObject<EntityType<RangedTomatoEntity>> TOMATO = register("projectile_tomato",
			EntityType.Builder.<RangedTomatoEntity>of(RangedTomatoEntity::new, MobCategory.MISC).setCustomClientFactory(RangedTomatoEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TestDummyEntity>> TEST_DUMMY = register("test_dummy",
			EntityType.Builder.<TestDummyEntity>of(TestDummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestDummyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BuffaloEntity>> BUFFALO = register("buffalo",
			EntityType.Builder.<BuffaloEntity>of(BuffaloEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuffaloEntity::new)

					.sized(0.6f, 1.2f));
	public static final RegistryObject<EntityType<BuffalobabyEntity>> BUFFALOBABY = register("buffalobaby",
			EntityType.Builder.<BuffalobabyEntity>of(BuffalobabyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BuffalobabyEntity::new)

					.sized(0.5f, 0.7000000000000001f));
	public static final RegistryObject<EntityType<ShrooMooEntity>> SHROO_MOO = register("shroo_moo",
			EntityType.Builder.<ShrooMooEntity>of(ShrooMooEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShrooMooEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = register("penguin",
			EntityType.Builder.<PenguinEntity>of(PenguinEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PenguinEntity::new)

					.sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<PenguinbigEntity>> PENGUINBIG = register("penguinbig",
			EntityType.Builder.<PenguinbigEntity>of(PenguinbigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PenguinbigEntity::new)

					.sized(0.8f, 0.9f));
	public static final RegistryObject<EntityType<MobBigEntity>> MOB_BIG = register("mob_big",
			EntityType.Builder.<MobBigEntity>of(MobBigEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobBigEntity::new)

					.sized(0.5f, 0.8f));
	public static final RegistryObject<EntityType<GooseEntity>> GOOSE = register("goose",
			EntityType.Builder.<GooseEntity>of(GooseEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GooseEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ParasEntity>> PARAS = register("paras",
			EntityType.Builder.<ParasEntity>of(ParasEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ParasEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ZombiePigManEntity>> ZOMBIE_PIG_MAN = register("zombie_pig_man", EntityType.Builder.<ZombiePigManEntity>of(ZombiePigManEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZombiePigManEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FrozenZombieEntity>> FROZEN_ZOMBIE = register("frozen_zombie",
			EntityType.Builder.<FrozenZombieEntity>of(FrozenZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrozenZombieEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IceologerEntity>> ICEOLOGER = register("iceologer", EntityType.Builder.<IceologerEntity>of(IceologerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(IceologerEntity::new).fireImmune().sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<GhostSpiderEntity>> GHOST_SPIDER = register("ghost_spider",
			EntityType.Builder.<GhostSpiderEntity>of(GhostSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3).setCustomClientFactory(GhostSpiderEntity::new)

					.sized(1.6f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<MimicEntityEntity>> MIMIC_ENTITY = register("mimic_entity", EntityType.Builder.<MimicEntityEntity>of(MimicEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MimicEntityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SirenheadEntity>> SIRENHEAD = register("sirenhead",
			EntityType.Builder.<SirenheadEntity>of(SirenheadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SirenheadEntity::new)

					.sized(0.7f, 5f));
	public static final RegistryObject<EntityType<GiantAIEntity>> GIANT_AI = register("giant_ai",
			EntityType.Builder.<GiantAIEntity>of(GiantAIEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GiantAIEntity::new).fireImmune().sized(7.5f, 16f));
	public static final RegistryObject<EntityType<MobAmogusEntity>> MOB_AMOGUS = register("mob_amogus",
			EntityType.Builder.<MobAmogusEntity>of(MobAmogusEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobAmogusEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MobShadeEntity>> MOB_SHADE = register("mob_shade",
			EntityType.Builder.<MobShadeEntity>of(MobShadeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobShadeEntity::new).fireImmune().sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<SleuthEntity>> SLEUTH = register("sleuth",
			EntityType.Builder.<SleuthEntity>of(SleuthEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3).setCustomClientFactory(SleuthEntity::new)

					.sized(3f, 2.6f));
	public static final RegistryObject<EntityType<AnomalyEntity>> ANOMALY = register("anomaly",
			EntityType.Builder.<AnomalyEntity>of(AnomalyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AnomalyEntity::new).fireImmune().sized(0.7f, 1.8f));
	public static final RegistryObject<EntityType<MobAmogusGreenEntity>> MOB_AMOGUS_GREEN = register("mob_amogus_green",
			EntityType.Builder.<MobAmogusGreenEntity>of(MobAmogusGreenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobAmogusGreenEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MobAmogusGreyEntity>> MOB_AMOGUS_GREY = register("mob_amogus_grey",
			EntityType.Builder.<MobAmogusGreyEntity>of(MobAmogusGreyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobAmogusGreyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MobAmogusBlueEntity>> MOB_AMOGUS_BLUE = register("mob_amogus_blue",
			EntityType.Builder.<MobAmogusBlueEntity>of(MobAmogusBlueEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobAmogusBlueEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MobFloatingEyeEntity>> MOB_FLOATING_EYE = register("mob_floating_eye",
			EntityType.Builder.<MobFloatingEyeEntity>of(MobFloatingEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MobFloatingEyeEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NoobEntity>> NOOB = register("noob",
			EntityType.Builder.<NoobEntity>of(NoobEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NoobEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MickeyEntity>> MICKEY = register("mickey",
			EntityType.Builder.<MickeyEntity>of(MickeyEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MickeyEntity::new)

					.sized(1f, 2f));
	public static final RegistryObject<EntityType<GeneralEntity>> GENERAL = register("general",
			EntityType.Builder.<GeneralEntity>of(GeneralEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GeneralEntity::new)

					.sized(3.2f, 4.2f));
	public static final RegistryObject<EntityType<TrollEntity>> TROLL = register("troll",
			EntityType.Builder.<TrollEntity>of(TrollEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrollEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TrollgeLvl2Entity>> TROLLGE_LVL_2 = register("trollge_lvl_2",
			EntityType.Builder.<TrollgeLvl2Entity>of(TrollgeLvl2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrollgeLvl2Entity::new)

					.sized(20f, 20f));
	public static final RegistryObject<EntityType<TrollgeLvl3Entity>> TROLLGE_LVL_3 = register("trollge_lvl_3", EntityType.Builder.<TrollgeLvl3Entity>of(TrollgeLvl3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(TrollgeLvl3Entity::new).fireImmune().sized(20f, 30f));
	public static final RegistryObject<EntityType<HerobrineEntity>> HEROBRINE = register("herobrine", EntityType.Builder.<HerobrineEntity>of(HerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(HerobrineEntity::new).fireImmune().sized(0.7000000000000001f, 2f));
	public static final RegistryObject<EntityType<NootnootEntity>> NOOTNOOT = register("nootnoot",
			EntityType.Builder.<NootnootEntity>of(NootnootEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NootnootEntity::new)

					.sized(2.5f, 3f));
	public static final RegistryObject<EntityType<GhostSpiderMutantEntity>> GHOST_SPIDER_MUTANT = register("ghost_spider_mutant",
			EntityType.Builder.<GhostSpiderMutantEntity>of(GhostSpiderMutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(75).setUpdateInterval(3).setCustomClientFactory(GhostSpiderMutantEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<Nextbot1Entity>> NEXTBOT_1 = register("nextbot_1",
			EntityType.Builder.<Nextbot1Entity>of(Nextbot1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot1Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot2Entity>> NEXTBOT_2 = register("nextbot_2",
			EntityType.Builder.<Nextbot2Entity>of(Nextbot2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot2Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot3Entity>> NEXTBOT_3 = register("nextbot_3",
			EntityType.Builder.<Nextbot3Entity>of(Nextbot3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot3Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot4Entity>> NEXTBOT_4 = register("nextbot_4",
			EntityType.Builder.<Nextbot4Entity>of(Nextbot4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot4Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot5Entity>> NEXTBOT_5 = register("nextbot_5",
			EntityType.Builder.<Nextbot5Entity>of(Nextbot5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot5Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot6Entity>> NEXTBOT_6 = register("nextbot_6",
			EntityType.Builder.<Nextbot6Entity>of(Nextbot6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot6Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot7Entity>> NEXTBOT_7 = register("nextbot_7",
			EntityType.Builder.<Nextbot7Entity>of(Nextbot7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot7Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot8Entity>> NEXTBOT_8 = register("nextbot_8",
			EntityType.Builder.<Nextbot8Entity>of(Nextbot8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot8Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot9Entity>> NEXTBOT_9 = register("nextbot_9",
			EntityType.Builder.<Nextbot9Entity>of(Nextbot9Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot9Entity::new).fireImmune().sized(2f, 2f));
	public static final RegistryObject<EntityType<Nextbot10Entity>> NEXTBOT_10 = register("nextbot_10",
			EntityType.Builder.<Nextbot10Entity>of(Nextbot10Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot10Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<Nextbot11Entity>> NEXTBOT_11 = register("nextbot_11",
			EntityType.Builder.<Nextbot11Entity>of(Nextbot11Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(86).setUpdateInterval(3).setCustomClientFactory(Nextbot11Entity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<WaspEntity>> WASP = register("wasp",
			EntityType.Builder.<WaspEntity>of(WaspEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WaspEntity::new)

					.sized(0.5f, 0.8f));
	public static final RegistryObject<EntityType<StickHorseEntity>> STICK_HORSE = register("stick_horse",
			EntityType.Builder.<StickHorseEntity>of(StickHorseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StickHorseEntity::new)

					.sized(0.6f, 1.2f));
	public static final RegistryObject<EntityType<GiantSquidEntity>> GIANT_SQUID = register("giant_squid",
			EntityType.Builder.<GiantSquidEntity>of(GiantSquidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GiantSquidEntity::new)

					.sized(4f, 4f));
	public static final RegistryObject<EntityType<CatfishEntity>> CATFISH = register("catfish",
			EntityType.Builder.<CatfishEntity>of(CatfishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CatfishEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SkeleturtleEntity>> SKELETURTLE = register("skeleturtle",
			EntityType.Builder.<SkeleturtleEntity>of(SkeleturtleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SkeleturtleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SkeleturtleEntityProjectile>> SKELETURTLE_PROJECTILE = register("projectile_skeleturtle", EntityType.Builder.<SkeleturtleEntityProjectile>of(SkeleturtleEntityProjectile::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(SkeleturtleEntityProjectile::new).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmongamiteEntity>> AMONGAMITE = register("amongamite",
			EntityType.Builder.<AmongamiteEntity>of(AmongamiteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmongamiteEntity::new)

					.sized(0.4f, 0.3f));
	public static final RegistryObject<EntityType<IronDroidEntity>> IRON_DROID = register("iron_droid",
			EntityType.Builder.<IronDroidEntity>of(IronDroidEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IronDroidEntity::new)

					.sized(1.4f, 2.3f));
	public static final RegistryObject<EntityType<PlagueWitchEntity>> PLAGUE_WITCH = register("plague_witch",
			EntityType.Builder.<PlagueWitchEntity>of(PlagueWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PlagueWitchEntity::new)

					.sized(0.6f, 1.9500000000000002f));
	public static final RegistryObject<EntityType<CreepestEntity>> CREEPIEST = register("creepiest",
			EntityType.Builder.<CreepestEntity>of(CreepestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CreepestEntity::new).fireImmune().sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<DuckEntity>> DUCK = register("duck",
			EntityType.Builder.<DuckEntity>of(DuckEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DuckEntity::new)

					.sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<CreepEntity>> CREEP = register("creep",
			EntityType.Builder.<CreepEntity>of(CreepEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CreepEntity::new).fireImmune().sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<ChomperEntity>> CHOMPER = register("chomper",
			EntityType.Builder.<ChomperEntity>of(ChomperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChomperEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TomatoShurikenEntity>> TOMATO_SHURIKEN = register("projectile_tomato_shuriken",
			EntityType.Builder.<TomatoShurikenEntity>of(TomatoShurikenEntity::new, MobCategory.MISC).setCustomClientFactory(TomatoShurikenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StonespearEntity>> STONESPEAR = register("projectile_stonespear",
			EntityType.Builder.<StonespearEntity>of(StonespearEntity::new, MobCategory.MISC).setCustomClientFactory(StonespearEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BladeRazorEntity>> BLADE_RAZOR = register("projectile_blade_razor",
			EntityType.Builder.<BladeRazorEntity>of(BladeRazorEntity::new, MobCategory.MISC).setCustomClientFactory(BladeRazorEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BladeOfDespairEntity>> BLADE_OF_DESPAIR = register("projectile_blade_of_despair",
			EntityType.Builder.<BladeOfDespairEntity>of(BladeOfDespairEntity::new, MobCategory.MISC).setCustomClientFactory(BladeOfDespairEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CocaColaGrenadeEntity>> COCA_COLA_GRENADE = register("projectile_coca_cola_grenade", EntityType.Builder.<CocaColaGrenadeEntity>of(CocaColaGrenadeEntity::new, MobCategory.MISC)
			.setCustomClientFactory(CocaColaGrenadeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SeedMachineGunEntity>> SEED_MACHINE_GUN = register("projectile_seed_machine_gun",
			EntityType.Builder.<SeedMachineGunEntity>of(SeedMachineGunEntity::new, MobCategory.MISC).setCustomClientFactory(SeedMachineGunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PopCornEntity>> POP_CORN = register("projectile_pop_corn",
			EntityType.Builder.<PopCornEntity>of(PopCornEntity::new, MobCategory.MISC).setCustomClientFactory(PopCornEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IronSpearEntity>> IRON_SPEAR = register("projectile_iron_spear",
			EntityType.Builder.<IronSpearEntity>of(IronSpearEntity::new, MobCategory.MISC).setCustomClientFactory(IronSpearEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MPPotatoEntity>> MP_POTATO = register("projectile_mp_potato",
			EntityType.Builder.<MPPotatoEntity>of(MPPotatoEntity::new, MobCategory.MISC).setCustomClientFactory(MPPotatoEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BeetzookaEntity>> BEETZOOKA = register("projectile_beetzooka",
			EntityType.Builder.<BeetzookaEntity>of(BeetzookaEntity::new, MobCategory.MISC).setCustomClientFactory(BeetzookaEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BeetsniperEntity>> BEETSNIPER = register("projectile_beetsniper",
			EntityType.Builder.<BeetsniperEntity>of(BeetsniperEntity::new, MobCategory.MISC).setCustomClientFactory(BeetsniperEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StoneSpearThrownEntity>> STONE_SPEAR_THROWN = register("stone_spear_thrown", EntityType.Builder.<StoneSpearThrownEntity>of(StoneSpearThrownEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneSpearThrownEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IronSpearEntityEntity>> IRON_SPEAR_ENTITY = register("iron_spear_entity", EntityType.Builder.<IronSpearEntityEntity>of(IronSpearEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IronSpearEntityEntity::new).fireImmune().sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EntityBodEntity>> ENTITY_BOD = register("entity_bod",
			EntityType.Builder.<EntityBodEntity>of(EntityBodEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(EntityBodEntity::new)

					.sized(0.5f, 1f));
	public static final RegistryObject<EntityType<PrimalDragonEntity>> PRIMAL_DRAGON = register("primal_dragon",
			EntityType.Builder.<PrimalDragonEntity>of(PrimalDragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimalDragonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MeteoriteEntity>> METEORITE = register("projectile_meteorite",
			EntityType.Builder.<MeteoriteEntity>of(MeteoriteEntity::new, MobCategory.MISC).setCustomClientFactory(MeteoriteEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JockeyTowerEntity>> JOCKEY_TOWER = register("jockey_tower",
			EntityType.Builder.<JockeyTowerEntity>of(JockeyTowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JockeyTowerEntity::new)

					.sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<IceWandEntity>> ICE_WAND = register("projectile_ice_wand",
			EntityType.Builder.<IceWandEntity>of(IceWandEntity::new, MobCategory.MISC).setCustomClientFactory(IceWandEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LightningRodEntity>> LIGHTNING_ROD = register("projectile_lightning_rod",
			EntityType.Builder.<LightningRodEntity>of(LightningRodEntity::new, MobCategory.MISC).setCustomClientFactory(LightningRodEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FireScepterEntity>> FIRE_SCEPTER = register("projectile_fire_scepter",
			EntityType.Builder.<FireScepterEntity>of(FireScepterEntity::new, MobCategory.MISC).setCustomClientFactory(FireScepterEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TheSwitcherEntity>> THE_SWITCHER = register("projectile_the_switcher",
			EntityType.Builder.<TheSwitcherEntity>of(TheSwitcherEntity::new, MobCategory.MISC).setCustomClientFactory(TheSwitcherEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TestDummyEntity.init();
			BuffaloEntity.init();
			BuffalobabyEntity.init();
			ShrooMooEntity.init();
			PenguinEntity.init();
			PenguinbigEntity.init();
			MobBigEntity.init();
			GooseEntity.init();
			ParasEntity.init();
			ZombiePigManEntity.init();
			FrozenZombieEntity.init();
			IceologerEntity.init();
			GhostSpiderEntity.init();
			MimicEntityEntity.init();
			SirenheadEntity.init();
			GiantAIEntity.init();
			MobAmogusEntity.init();
			MobShadeEntity.init();
			SleuthEntity.init();
			AnomalyEntity.init();
			MobAmogusGreenEntity.init();
			MobAmogusGreyEntity.init();
			MobAmogusBlueEntity.init();
			MobFloatingEyeEntity.init();
			NoobEntity.init();
			MickeyEntity.init();
			GeneralEntity.init();
			TrollEntity.init();
			TrollgeLvl2Entity.init();
			TrollgeLvl3Entity.init();
			HerobrineEntity.init();
			NootnootEntity.init();
			GhostSpiderMutantEntity.init();
			Nextbot1Entity.init();
			Nextbot2Entity.init();
			Nextbot3Entity.init();
			Nextbot4Entity.init();
			Nextbot5Entity.init();
			Nextbot6Entity.init();
			Nextbot7Entity.init();
			Nextbot8Entity.init();
			Nextbot9Entity.init();
			Nextbot10Entity.init();
			Nextbot11Entity.init();
			WaspEntity.init();
			StickHorseEntity.init();
			GiantSquidEntity.init();
			CatfishEntity.init();
			SkeleturtleEntity.init();
			AmongamiteEntity.init();
			IronDroidEntity.init();
			PlagueWitchEntity.init();
			CreepestEntity.init();
			DuckEntity.init();
			CreepEntity.init();
			ChomperEntity.init();
			StoneSpearThrownEntity.init();
			IronSpearEntityEntity.init();
			EntityBodEntity.init();
			PrimalDragonEntity.init();
			JockeyTowerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TEST_DUMMY.get(), TestDummyEntity.createAttributes().build());
		event.put(BUFFALO.get(), BuffaloEntity.createAttributes().build());
		event.put(BUFFALOBABY.get(), BuffalobabyEntity.createAttributes().build());
		event.put(SHROO_MOO.get(), ShrooMooEntity.createAttributes().build());
		event.put(PENGUIN.get(), PenguinEntity.createAttributes().build());
		event.put(PENGUINBIG.get(), PenguinbigEntity.createAttributes().build());
		event.put(MOB_BIG.get(), MobBigEntity.createAttributes().build());
		event.put(GOOSE.get(), GooseEntity.createAttributes().build());
		event.put(PARAS.get(), ParasEntity.createAttributes().build());
		event.put(ZOMBIE_PIG_MAN.get(), ZombiePigManEntity.createAttributes().build());
		event.put(FROZEN_ZOMBIE.get(), FrozenZombieEntity.createAttributes().build());
		event.put(ICEOLOGER.get(), IceologerEntity.createAttributes().build());
		event.put(GHOST_SPIDER.get(), GhostSpiderEntity.createAttributes().build());
		event.put(MIMIC_ENTITY.get(), MimicEntityEntity.createAttributes().build());
		event.put(SIRENHEAD.get(), SirenheadEntity.createAttributes().build());
		event.put(GIANT_AI.get(), GiantAIEntity.createAttributes().build());
		event.put(MOB_AMOGUS.get(), MobAmogusEntity.createAttributes().build());
		event.put(MOB_SHADE.get(), MobShadeEntity.createAttributes().build());
		event.put(SLEUTH.get(), SleuthEntity.createAttributes().build());
		event.put(ANOMALY.get(), AnomalyEntity.createAttributes().build());
		event.put(MOB_AMOGUS_GREEN.get(), MobAmogusGreenEntity.createAttributes().build());
		event.put(MOB_AMOGUS_GREY.get(), MobAmogusGreyEntity.createAttributes().build());
		event.put(MOB_AMOGUS_BLUE.get(), MobAmogusBlueEntity.createAttributes().build());
		event.put(MOB_FLOATING_EYE.get(), MobFloatingEyeEntity.createAttributes().build());
		event.put(NOOB.get(), NoobEntity.createAttributes().build());
		event.put(MICKEY.get(), MickeyEntity.createAttributes().build());
		event.put(GENERAL.get(), GeneralEntity.createAttributes().build());
		event.put(TROLL.get(), TrollEntity.createAttributes().build());
		event.put(TROLLGE_LVL_2.get(), TrollgeLvl2Entity.createAttributes().build());
		event.put(TROLLGE_LVL_3.get(), TrollgeLvl3Entity.createAttributes().build());
		event.put(HEROBRINE.get(), HerobrineEntity.createAttributes().build());
		event.put(NOOTNOOT.get(), NootnootEntity.createAttributes().build());
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
		event.put(STONE_SPEAR_THROWN.get(), StoneSpearThrownEntity.createAttributes().build());
		event.put(IRON_SPEAR_ENTITY.get(), IronSpearEntityEntity.createAttributes().build());
		event.put(ENTITY_BOD.get(), EntityBodEntity.createAttributes().build());
		event.put(PRIMAL_DRAGON.get(), PrimalDragonEntity.createAttributes().build());
		event.put(JOCKEY_TOWER.get(), JockeyTowerEntity.createAttributes().build());
	}
}
