
package net.mcreator.kraftmine.block;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.procedures.AcidMobplayerCollidesBlockProcedure;
import net.mcreator.kraftmine.init.KraftmineModFluids;

public class AcidBlock extends LiquidBlock {
	public AcidBlock() {
		super(() -> KraftmineModFluids.ACID.get(), BlockBehaviour.Properties.of(Material.WATER, MaterialColor.COLOR_GREEN).strength(100f).noCollission().noLootTable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 5;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		AcidMobplayerCollidesBlockProcedure.execute(entity);
	}
}
