
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.kraftmined.kombat.block.TungstenOreBlock;
import net.mcreator.kraftmined.kombat.block.TungstenBlockBlock;
import net.mcreator.kraftmined.kombat.block.TitaniumOreBlock;
import net.mcreator.kraftmined.kombat.block.TitaniumBlockBlock;
import net.mcreator.kraftmined.kombat.block.NickelOreBlock;
import net.mcreator.kraftmined.kombat.block.NickelBlockBlock;
import net.mcreator.kraftmined.kombat.KmKombatMod;

public class KmKombatModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(KmKombatMod.MODID);
	public static final DeferredBlock<Block> NICKEL_ORE = REGISTRY.register("nickel_ore", NickelOreBlock::new);
	public static final DeferredBlock<Block> NICKEL_BLOCK = REGISTRY.register("nickel_block", NickelBlockBlock::new);
	public static final DeferredBlock<Block> TUNGSTEN_ORE = REGISTRY.register("tungsten_ore", TungstenOreBlock::new);
	public static final DeferredBlock<Block> TUNGSTEN_BLOCK = REGISTRY.register("tungsten_block", TungstenBlockBlock::new);
	public static final DeferredBlock<Block> TITANIUM_ORE = REGISTRY.register("titanium_ore", TitaniumOreBlock::new);
	public static final DeferredBlock<Block> TITANIUM_BLOCK = REGISTRY.register("titanium_block", TitaniumBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
