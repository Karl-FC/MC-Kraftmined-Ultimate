
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.kraftmined.unplayable.block.TropicalFishOreBlock;
import net.mcreator.kraftmined.unplayable.block.SalmonOreBlock;
import net.mcreator.kraftmined.unplayable.block.MilkBlock;
import net.mcreator.kraftmined.unplayable.block.DirtOreBlock;
import net.mcreator.kraftmined.unplayable.block.CodOreBlock;
import net.mcreator.kraftmined.unplayable.block.BlockrottenfleshBlock;
import net.mcreator.kraftmined.unplayable.block.BlockTropicalfishBlock;
import net.mcreator.kraftmined.unplayable.block.BlockSalmonBlock;
import net.mcreator.kraftmined.unplayable.block.BlockPhantommembraneBlock;
import net.mcreator.kraftmined.unplayable.block.BlockPaperBlock;
import net.mcreator.kraftmined.unplayable.block.BlockGlassbottleBlock;
import net.mcreator.kraftmined.unplayable.block.BlockFeatherBlock;
import net.mcreator.kraftmined.unplayable.block.BlockEggBlock;
import net.mcreator.kraftmined.unplayable.block.BlockCodBlock;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(KmUnplayableMod.MODID);
	public static final DeferredBlock<Block> MILK = REGISTRY.register("milk", MilkBlock::new);
	public static final DeferredBlock<Block> BLOCK_PAPER = REGISTRY.register("block_paper", BlockPaperBlock::new);
	public static final DeferredBlock<Block> BLOCK_COD = REGISTRY.register("block_cod", BlockCodBlock::new);
	public static final DeferredBlock<Block> BLOCK_SALMON = REGISTRY.register("block_salmon", BlockSalmonBlock::new);
	public static final DeferredBlock<Block> BLOCK_GLASSBOTTLE = REGISTRY.register("block_glassbottle", BlockGlassbottleBlock::new);
	public static final DeferredBlock<Block> BLOCKROTTENFLESH = REGISTRY.register("blockrottenflesh", BlockrottenfleshBlock::new);
	public static final DeferredBlock<Block> BLOCK_PHANTOMMEMBRANE = REGISTRY.register("block_phantommembrane", BlockPhantommembraneBlock::new);
	public static final DeferredBlock<Block> BLOCK_FEATHER = REGISTRY.register("block_feather", BlockFeatherBlock::new);
	public static final DeferredBlock<Block> BLOCK_EGG = REGISTRY.register("block_egg", BlockEggBlock::new);
	public static final DeferredBlock<Block> SALMON_ORE = REGISTRY.register("salmon_ore", SalmonOreBlock::new);
	public static final DeferredBlock<Block> COD_ORE = REGISTRY.register("cod_ore", CodOreBlock::new);
	public static final DeferredBlock<Block> TROPICAL_FISH_ORE = REGISTRY.register("tropical_fish_ore", TropicalFishOreBlock::new);
	public static final DeferredBlock<Block> BLOCK_TROPICALFISH = REGISTRY.register("block_tropicalfish", BlockTropicalfishBlock::new);
	public static final DeferredBlock<Block> DIRT_ORE = REGISTRY.register("dirt_ore", DirtOreBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
