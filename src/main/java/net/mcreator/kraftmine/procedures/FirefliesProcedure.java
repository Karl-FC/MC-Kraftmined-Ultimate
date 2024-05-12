package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

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
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FirefliesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
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
			if (!(world instanceof Level _lvl && _lvl.isDay()) && (entity.level.dimension()) == (Level.OVERWORLD)) {
				posX = x - 16;
				posY = y - 16;
				posZ = z - 16;
				for (int index0 = 0; index0 < (int) (33); index0++) {
					for (int index1 = 0; index1 < (int) (33); index1++) {
						for (int index2 = 0; index2 < (int) (33); index2++) {
							if ((world.getBlockState(new BlockPos(posX, posY, posZ))).is(BlockTags.create(new ResourceLocation("kraftmine:fauna"))) && (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("swamp"))
									|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:has_structure/village_plains")))
									|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_forest")))) && world.canSeeSkyFromBelowWater(new BlockPos(posX, posY, posZ))) {
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
				if (((world.getBlockState(
						new BlockPos(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.getBlock() == Blocks.TALL_GRASS
						|| (world.getBlockState(new BlockPos(
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
								.getBlock() == Blocks.LARGE_FERN)
						&& (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("swamp"))
								|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:has_structure/village_plains")))
								|| world.getBiome(new BlockPos(posX, posY, posZ)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_forest"))))
						&& world.canSeeSkyFromBelowWater(new BlockPos(
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))) {
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
