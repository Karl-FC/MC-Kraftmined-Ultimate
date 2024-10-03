
package net.mcreator.kraftmine.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.kraftmine.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.kraftmine.procedures.AdditionalGenerationConditionProcedure;

public class PalmbentFeatureFeature extends StructureFeature {
	public PalmbentFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!AdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
