
package net.mcreator.kraftmined.unplayable.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.kraftmined.unplayable.init.KmUnplayableModFluids;
import net.mcreator.kraftmined.unplayable.init.KmUnplayableModFluidTypes;
import net.mcreator.kraftmined.unplayable.init.KmUnplayableModBlocks;

public abstract class MilkFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> KmUnplayableModFluidTypes.MILK_TYPE.get(), () -> KmUnplayableModFluids.MILK.get(), () -> KmUnplayableModFluids.FLOWING_MILK.get())
			.explosionResistance(100f).tickRate(10).block(() -> (LiquidBlock) KmUnplayableModBlocks.MILK.get());

	private MilkFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.EXPLOSION;
	}

	public static class Source extends MilkFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MilkFluid {
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
