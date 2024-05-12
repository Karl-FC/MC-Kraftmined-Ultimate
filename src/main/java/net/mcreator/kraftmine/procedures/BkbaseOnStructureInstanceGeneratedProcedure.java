package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class BkbaseOnStructureInstanceGeneratedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x + Mth.nextDouble(RandomSource.create(), 1, 4), y + 5, z + Mth.nextDouble(RandomSource.create(), 1, 4)), Blocks.SEA_LANTERN.defaultBlockState(), 3);
		world.setBlock(new BlockPos(x, y, z), KraftmineModBlocks.RUBY_BLOCK.get().defaultBlockState(), 3);
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("kraftmine", "bkbase"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x + 4, y, z), new BlockPos(x + 4, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("kraftmine", "bkbase"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x - 4, y, z), new BlockPos(x - 4, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("kraftmine", "bkbase"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x, y, z + 4), new BlockPos(x, y, z + 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("kraftmine", "bkbase"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x, y, z + 4), new BlockPos(x, y, z + 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
	}
}
