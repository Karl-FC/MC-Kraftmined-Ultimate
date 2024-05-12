package net.mcreator.kraftmine.procedures;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class ParasNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _lvl && _lvl.isDay() || (world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.PLANT
				|| (world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.REPLACEABLE_PLANT || !world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))
				|| (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x, y, z)) == PlantType.CAVE : false)) {
			return true;
		}
		return false;
	}
}
