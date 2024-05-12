package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.HerobrineEntity;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class HerobrineSpawnProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (Level.NETHER)
				|| (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms"))))
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.SOUL_FIRE) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.SOUL_SOIL && (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.PLAYER_HEAD
					&& (world.getBlockState(new BlockPos(x - 1, y - 2, z))).getBlock() == Blocks.GILDED_BLACKSTONE && (world.getBlockState(new BlockPos(x + 1, y - 2, z))).getBlock() == Blocks.GILDED_BLACKSTONE
					&& (world.getBlockState(new BlockPos(x, y - 2, z - 1))).getBlock() == Blocks.GILDED_BLACKSTONE && (world.getBlockState(new BlockPos(x, y - 2, z + 1))).getBlock() == Blocks.GILDED_BLACKSTONE
					&& (world.getBlockState(new BlockPos(x + 1, y - 2, z - 1))).getBlock() == Blocks.GILDED_BLACKSTONE && (world.getBlockState(new BlockPos(x - 1, y - 2, z + 1))).getBlock() == Blocks.GILDED_BLACKSTONE
					&& (world.getBlockState(new BlockPos(x - 1, y - 2, z - 1))).getBlock() == Blocks.GILDED_BLACKSTONE && (world.getBlockState(new BlockPos(x + 1, y - 2, z + 1))).getBlock() == Blocks.GILDED_BLACKSTONE
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == Blocks.RED_CANDLE && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == Blocks.RED_CANDLE
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == Blocks.RED_CANDLE && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == Blocks.RED_CANDLE) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(15, () -> {
					for (int index0 = 0; index0 < (int) (10); index0++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new LightningBolt(EntityType.LIGHTNING_BOLT, _level);
							entityToSpawn.moveTo(x, y, z, 0, 0);
							entityToSpawn.setYBodyRot(0);
							entityToSpawn.setYHeadRot(0);
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
					KraftmineMod.queueServerWork(55, () -> {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new HerobrineEntity(KraftmineModEntities.HEROBRINE.get(), _level);
							entityToSpawn.moveTo(x, (y + 2), z, 0, 0);
							entityToSpawn.setYBodyRot(0);
							entityToSpawn.setYHeadRot(0);
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof HerobrineEntity) {
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 255));
									if (entity instanceof LivingEntity _entity)
										_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 1));
								}
							}
						}
					});
				});
			}
		}
	}
}
