package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

public class LocateblockprocedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		boolean found = false;
		String blockneed = "";
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double foundsx = 0;
		double foundsy = 0;
		double foundsz = 0;
		double PosY = 0;
		double Whereisit = 0;
		double PosYup = 0;
		double PosYdown = 0;
		blockneed = cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "";
		found = false;
		PosYup = y;
		PosYdown = y;
		for (int index0 = 0; index0 < 200; index0++) {
			if ((world.getBlockState(BlockPos.containing(x, PosYup, z))).is(BlockTags.create(ResourceLocation.parse((blockneed).toLowerCase(java.util.Locale.ENGLISH))))) {
				found = true;
			}
			PosYup = PosYup + 1;
		}
		if (found == false) {
			PosYdown = y;
			for (int index1 = 0; index1 < 100; index1++) {
				if ((world.getBlockState(BlockPos.containing(x, PosYdown, z))).is(BlockTags.create(ResourceLocation.parse((blockneed).toLowerCase(java.util.Locale.ENGLISH))))) {
					found = true;
				}
				PosYdown = PosYdown - 1;
			}
		}
		if (found == true) {
			if (PosYup - y < y + PosYdown) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("The nearest" + blockneed + " is at " + x + PosYup + z)), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("The nearest" + blockneed + " is at " + x + PosYdown + z)), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Unable to locate the requested block or block tag within a square of 1000x400x1000 blocks area"), false);
		}
	}
}
