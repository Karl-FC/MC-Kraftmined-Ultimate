
package net.mcreator.kraftmine.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;
import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModFluids;
import net.mcreator.kraftmine.init.KraftmineModFluidTypes;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

public abstract class AcidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> KraftmineModFluidTypes.ACID_TYPE.get(), () -> KraftmineModFluids.ACID.get(), () -> KraftmineModFluids.FLOWING_ACID.get()).explosionResistance(100f)
			.tickRate(10).levelDecreasePerBlock(2).slopeFindDistance(5).bucket(() -> KraftmineModItems.ACID_BUCKET.get()).block(() -> (LiquidBlock) KraftmineModBlocks.ACID.get());

	private AcidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (KraftmineModParticleTypes.ACIDBUBBLE.get());
	}

	public static class Source extends AcidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AcidFluid {
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
