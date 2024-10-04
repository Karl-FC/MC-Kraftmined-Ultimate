
package net.mcreator.kraftmine.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.kraftmine.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.kraftmine.procedures.BkbaseAdditionalGenerationConditionProcedure;

public class BkbaseFeatureFeature extends StructureFeature {
	public BkbaseFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!BkbaseAdditionalGenerationConditionProcedure.execute(world, y))
			return false;
		return super.place(context);
	}
}
