
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.item.NetheriteBattleaxeItem;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KraftminedMod.MODID);
	public static final DeferredItem<Item> NETHERITE_BATTLEAXE = REGISTRY.register("netherite_battleaxe", NetheriteBattleaxeItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
