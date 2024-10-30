
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.item.PebbleItem;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KraftminedMod.MODID);
	public static final DeferredItem<Item> PEBBLE = REGISTRY.register("pebble", PebbleItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
