package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FirefliesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomCHance = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double Fireflycount = 0;
		if (!world.isClientSide()) {
			randomCHance = Math.random();
		}
		if (randomCHance >= 0.98) {
			if (!(world instanceof Level _lvl1 && _lvl1.isDay()) && (entity.level().dimension()) == Level.OVERWORLD) {
				posX = x - 16;
				posY = y - 16;
				posZ = z - 16;
				for (int index0 = 0; index0 < 33; index0++) {
					for (int index1 = 0; index1 < 33; index1++) {
						for (int index2 = 0; index2 < 33; index2++) {
							if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).is(BlockTags.create(ResourceLocation.parse("kraftmine:fauna")))
									&& (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("swamp"))
											|| world.getBiome(BlockPos.containing(posX, posY, posZ)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:has_structure/village_plains")))
											|| world.getBiome(BlockPos.containing(posX, posY, posZ)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_forest"))))
									&& world.canSeeSkyFromBelowWater(BlockPos.containing(posX, posY, posZ))) {
								Fireflycount = Mth.nextInt(RandomSource.create(), 1, 2);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.FIREFLY.get()), posX, posY, posZ, (int) Fireflycount, 1.5, 1.5, 1.5, 0.1);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.FIREFLYRIGHT.get()), posX, posY, posZ, (int) Fireflycount, 1.5, 1.5, 1.5, 0.1);
							}
							posX = posX + 1;
						}
						posX = x - 16;
						posZ = posZ + 1;
					}
					posX = x - 16;
					posZ = z - 16;
					posY = posY + 1;
				}
				if (((world
						.getBlockState(
								new BlockPos(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ())))
						.getBlock() == Blocks.TALL_GRASS
						|| (world.getBlockState(new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
								.getBlock() == Blocks.LARGE_FERN)
						&& (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("swamp"))
								|| world.getBiome(BlockPos.containing(posX, posY, posZ)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:has_structure/village_plains"))) || world.getBiome(
										BlockPos.containing(posX, posY, posZ)).is(
												TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_forest"))))
						&& world.canSeeSkyFromBelowWater(new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))) {
					Fireflycount = Mth.nextInt(RandomSource.create(), 2, 3);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.FIREFLY.get()), posX, posY, posZ, (int) Fireflycount, 1.5, 1.5, 1.5, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.FIREFLYRIGHT.get()), posX, posY, posZ, (int) Fireflycount, 1.5, 1.5, 1.5, 0.1);
				}
			}
		}
	}
}
