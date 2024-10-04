
package net.mcreator.kraftmine.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.kraftmine.init.KraftmineModFluids;
import net.mcreator.kraftmine.init.KraftmineModFluidTypes;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

public abstract class MilkBucketFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> KraftmineModFluidTypes.MILK_BUCKET_TYPE.get(), () -> KraftmineModFluids.MILK_BUCKET.get(), () -> KraftmineModFluids.FLOWING_MILK_BUCKET.get())
			.explosionResistance(100f).tickRate(6).block(() -> (LiquidBlock) KraftmineModBlocks.MILK_BUCKET.get());

	private MilkBucketFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	public static class Source extends MilkBucketFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MilkBucketFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
