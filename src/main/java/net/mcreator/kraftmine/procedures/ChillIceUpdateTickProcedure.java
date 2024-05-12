package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

public class ChillIceUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty())) {
			count = count + 1;
			if (count == 200) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
