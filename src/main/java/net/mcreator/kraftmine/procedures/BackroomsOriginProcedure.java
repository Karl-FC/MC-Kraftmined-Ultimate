package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BackroomsOriginProcedure {
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
		if (entity instanceof Player
				&& (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("kraftmine:no_clipped"))).isDone() : false)
				&& (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms")))) {
			KraftmineModVariables.WorldVariables.get(world).NoClipped = true;
			KraftmineModVariables.WorldVariables.get(world).syncData(world);
		}
		if (KraftmineModVariables.WorldVariables.get(world).NoClipped == true && (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms")))) {
			if (y != 20) {
				{
					Entity _ent = entity;
					_ent.teleportTo(x, 20, z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, 20, z, _ent.getYRot(), _ent.getXRot());
				}
				entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			}
			if (!world.isEmptyBlock(new BlockPos(x, y, z)) || !world.isEmptyBlock(new BlockPos(x, y - 1, z))) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(new BlockPos(x, y - 2, z))) {
				world.setBlock(new BlockPos(x, y - 2, z), KraftmineModBlocks.WALL_BLOCK.get().defaultBlockState(), 3);
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("kraftmine", "bkbase"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x, y - 1, z), new BlockPos(x, y - 1, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			if (Math.random() > 0.5) {
				world.setBlock(new BlockPos(x, y, z + 5), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(new BlockPos(x, y, z - 5), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(new BlockPos(x + 5, y, z), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(new BlockPos(x - 5, y, z), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
		}
	}
}
