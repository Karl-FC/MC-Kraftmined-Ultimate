package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class IceologerAttackProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double Xpos = 0;
		double Ypos = 0;
		double Zpos = 0;
		double wait = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		target = entity;
		Xpos = x - 2;
		Ypos = y + 2;
		Zpos = z - 2;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			Xpos = Xpos + 1;
			if (world.isEmptyBlock(new BlockPos(Xpos, Ypos, Zpos))) {
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, new BlockPos(Xpos, Ypos, Zpos), KraftmineModBlocks.CHILL_ICE.get().defaultBlockState());
			}
			for (int index1 = 0; index1 < (int) (3); index1++) {
				Ypos = Ypos + 1;
				if (world.isEmptyBlock(new BlockPos(Xpos, Ypos, Zpos))) {
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, new BlockPos(Xpos, Ypos, Zpos), KraftmineModBlocks.CHILL_ICE.get().defaultBlockState());
				}
				for (int index2 = 0; index2 < (int) (3); index2++) {
					Zpos = Zpos + 1;
					if (world.isEmptyBlock(new BlockPos(Xpos, Ypos, Zpos))) {
						if (world instanceof ServerLevel _level)
							FallingBlockEntity.fall(_level, new BlockPos(Xpos, Ypos, Zpos), KraftmineModBlocks.CHILL_ICE.get().defaultBlockState());
					}
				}
			}
		}
	}
}
