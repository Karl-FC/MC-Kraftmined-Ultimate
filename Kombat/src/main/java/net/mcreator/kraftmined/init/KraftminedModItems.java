
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.item.QuiverItem;
import net.mcreator.kraftmined.item.ObsidianScrapItem;
import net.mcreator.kraftmined.item.NetheriteBattleaxeItem;
import net.mcreator.kraftmined.item.EyepatchItem;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KraftminedMod.MODID);
	public static final DeferredItem<Item> NETHERITE_BATTLEAXE = REGISTRY.register("netherite_battleaxe", NetheriteBattleaxeItem::new);
	public static final DeferredItem<Item> QUIVER_CHESTPLATE = REGISTRY.register("quiver_chestplate", QuiverItem.Chestplate::new);
	public static final DeferredItem<Item> EYEPATCH_HELMET = REGISTRY.register("eyepatch_helmet", EyepatchItem.Helmet::new);
	public static final DeferredItem<Item> OBSIDIAN_SCRAP = REGISTRY.register("obsidian_scrap", ObsidianScrapItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
