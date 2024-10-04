package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
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
		if (entity instanceof Player && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().get(ResourceLocation.parse("kraftmine:no_clipped"))).isDone()
				&& (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:backrooms"))) {
			KraftmineModVariables.WorldVariables.get(world).NoClipped = true;
			KraftmineModVariables.WorldVariables.get(world).syncData(world);
		}
		if (KraftmineModVariables.WorldVariables.get(world).NoClipped == true && (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:backrooms"))) {
			if (y != 20) {
				{
					Entity _ent = entity;
					_ent.teleportTo(x, 20, z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, 20, z, _ent.getYRot(), _ent.getXRot());
				}
				entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			}
			if (!world.isEmptyBlock(BlockPos.containing(x, y, z)) || !world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y - 2, z))) {
				world.setBlock(BlockPos.containing(x, y - 2, z), KraftmineModBlocks.WALL_BLOCK.get().defaultBlockState(), 3);
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("kraftmine", "bkbase"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, y - 1, z), BlockPos.containing(x, y - 1, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
							3);
				}
			}
			if (Math.random() > 0.5) {
				world.setBlock(BlockPos.containing(x, y, z + 5), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(BlockPos.containing(x, y, z - 5), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(BlockPos.containing(x + 5, y, z), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
			if (Math.random() > 0.5) {
				world.setBlock(BlockPos.containing(x - 5, y, z), KraftmineModBlocks.BACKROOM_TRIGGER.get().defaultBlockState(), 3);
			}
		}
	}
}
