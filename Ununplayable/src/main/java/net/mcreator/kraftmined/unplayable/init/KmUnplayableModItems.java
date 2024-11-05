
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.kraftmined.unplayable.item.SurpriseEggItem;
import net.mcreator.kraftmined.unplayable.item.PebbleItem;
import net.mcreator.kraftmined.unplayable.item.MonodentItem;
import net.mcreator.kraftmined.unplayable.item.MaterwelonItem;
import net.mcreator.kraftmined.unplayable.item.GolemArmItem;
import net.mcreator.kraftmined.unplayable.item.FryingPanItem;
import net.mcreator.kraftmined.unplayable.item.DidentItem;
import net.mcreator.kraftmined.unplayable.item.DentItem;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KmUnplayableMod.MODID);
	public static final DeferredItem<Item> PEBBLE = REGISTRY.register("pebble", PebbleItem::new);
	public static final DeferredItem<Item> DENT = REGISTRY.register("dent", DentItem::new);
	public static final DeferredItem<Item> MATERWELON = REGISTRY.register("materwelon", MaterwelonItem::new);
	public static final DeferredItem<Item> MONODENT = REGISTRY.register("monodent", MonodentItem::new);
	public static final DeferredItem<Item> DIDENT = REGISTRY.register("dident", DidentItem::new);
	public static final DeferredItem<Item> FRYING_PAN = REGISTRY.register("frying_pan", FryingPanItem::new);
	public static final DeferredItem<Item> GOLEM_ARM = REGISTRY.register("golem_arm", GolemArmItem::new);
	public static final DeferredItem<Item> BIG_SPAWN_EGG = REGISTRY.register("big_spawn_egg", () -> new DeferredSpawnEggItem(KmUnplayableModEntities.BIG, -39169, -256, new Item.Properties()));
	public static final DeferredItem<Item> GOOSE_SPAWN_EGG = REGISTRY.register("goose_spawn_egg", () -> new DeferredSpawnEggItem(KmUnplayableModEntities.GOOSE, -9281975, -12966892, new Item.Properties()));
	public static final DeferredItem<Item> FLYING_SQUID_SPAWN_EGG = REGISTRY.register("flying_squid_spawn_egg", () -> new DeferredSpawnEggItem(KmUnplayableModEntities.FLYING_SQUID, -15312235, -8843762, new Item.Properties()));
	public static final DeferredItem<Item> BLOCK_PAPER = block(KmUnplayableModBlocks.BLOCK_PAPER);
	public static final DeferredItem<Item> BLOCK_COD = block(KmUnplayableModBlocks.BLOCK_COD);
	public static final DeferredItem<Item> BLOCK_SALMON = block(KmUnplayableModBlocks.BLOCK_SALMON);
	public static final DeferredItem<Item> BLOCK_GLASSBOTTLE = block(KmUnplayableModBlocks.BLOCK_GLASSBOTTLE);
	public static final DeferredItem<Item> BLOCKROTTENFLESH = block(KmUnplayableModBlocks.BLOCKROTTENFLESH);
	public static final DeferredItem<Item> BLOCK_PHANTOMMEMBRANE = block(KmUnplayableModBlocks.BLOCK_PHANTOMMEMBRANE);
	public static final DeferredItem<Item> BLOCK_FEATHER = block(KmUnplayableModBlocks.BLOCK_FEATHER);
	public static final DeferredItem<Item> BLOCK_EGG = block(KmUnplayableModBlocks.BLOCK_EGG);
	public static final DeferredItem<Item> SALMON_ORE = block(KmUnplayableModBlocks.SALMON_ORE);
	public static final DeferredItem<Item> COD_ORE = block(KmUnplayableModBlocks.COD_ORE);
	public static final DeferredItem<Item> TROPICAL_FISH_ORE = block(KmUnplayableModBlocks.TROPICAL_FISH_ORE);
	public static final DeferredItem<Item> BLOCK_TROPICALFISH = block(KmUnplayableModBlocks.BLOCK_TROPICALFISH);
	public static final DeferredItem<Item> DIRT_ORE = block(KmUnplayableModBlocks.DIRT_ORE);
	public static final DeferredItem<Item> SURPRISE_EGG = REGISTRY.register("surprise_egg", SurpriseEggItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
