package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.PlagueWitchEntity;
import net.mcreator.kraftmine.entity.IronDroidEntity;
import net.mcreator.kraftmine.entity.GhostSpiderMutantEntity;
import net.mcreator.kraftmine.entity.GhostSpiderEntity;
import net.mcreator.kraftmine.entity.AmongamiteEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BarrensSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity.level.dimension()) == (Level.OVERWORLD))) {
			if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:barrens")))) {
				if (entity instanceof Witch && Math.random() <= 0.8) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new PlagueWitchEntity(KraftmineModEntities.PLAGUE_WITCH.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof IronGolem && Math.random() <= 0.8) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new IronDroidEntity(KraftmineModEntities.IRON_DROID.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof Zombie && Math.random() <= 0.3) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Husk(EntityType.HUSK, _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof GhostSpiderEntity && Math.random() <= 0.8) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GhostSpiderMutantEntity(KraftmineModEntities.GHOST_SPIDER_MUTANT.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof Endermite && Math.random() <= 0.8) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new AmongamiteEntity(KraftmineModEntities.AMONGAMITE.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof Villager) {
					if (Math.random() <= 0.7) {
						if (!entity.level.isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new PlagueWitchEntity(KraftmineModEntities.PLAGUE_WITCH.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() > 0.7) {
						if (!entity.level.isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new ZombieVillager(EntityType.ZOMBIE_VILLAGER, _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms")))) {
				if (entity instanceof Witch && Math.random() <= 0.9) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new PlagueWitchEntity(KraftmineModEntities.PLAGUE_WITCH.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof IronGolem && Math.random() <= 0.3) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new IronDroidEntity(KraftmineModEntities.IRON_DROID.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof Zombie && Math.random() <= 0.5) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Husk(EntityType.HUSK, _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				} else if (entity instanceof GhostSpiderEntity && Math.random() <= 0.6) {
					if (!entity.level.isClientSide())
						entity.discard();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new GhostSpiderMutantEntity(KraftmineModEntities.GHOST_SPIDER_MUTANT.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
