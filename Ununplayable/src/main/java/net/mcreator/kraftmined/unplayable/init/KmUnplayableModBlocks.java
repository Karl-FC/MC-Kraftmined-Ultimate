
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.kraftmined.unplayable.block.MilkBlock;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(KmUnplayableMod.MODID);
	public static final DeferredBlock<Block> MILK = REGISTRY.register("milk", MilkBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
