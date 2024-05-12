package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.KraftmineMod;

public class NextbotTargetlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getPersistentData().getBoolean("locked") == true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:mob.nextbot.target")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:mob.nextbot.target")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			KraftmineMod.queueServerWork(300, () -> {
				sourceentity.getPersistentData().putBoolean("locked", (false));
			});
		}
	}
}
