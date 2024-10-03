
package net.mcreator.kraftmine.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.kraftmine.procedures.SupplyCrateAdditionalGenerationConditionProcedure;

public class SupplyCrateFeatureFeature extends OreFeature {
	public SupplyCrateFeatureFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!SupplyCrateAdditionalGenerationConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
