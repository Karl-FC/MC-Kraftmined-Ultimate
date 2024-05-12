package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

public class BkEntitiesNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms")))) {
			return true;
		}
		return false;
	}
}
