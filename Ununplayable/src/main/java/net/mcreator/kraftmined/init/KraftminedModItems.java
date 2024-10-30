
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.item.PebbleItem;
import net.mcreator.kraftmined.item.MonodentItem;
import net.mcreator.kraftmined.item.MaterwelonItem;
import net.mcreator.kraftmined.item.GolemArmItem;
import net.mcreator.kraftmined.item.FryingPanItem;
import net.mcreator.kraftmined.item.DidentItem;
import net.mcreator.kraftmined.item.DentItem;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KraftminedMod.MODID);
	public static final DeferredItem<Item> PEBBLE = REGISTRY.register("pebble", PebbleItem::new);
	public static final DeferredItem<Item> DENT = REGISTRY.register("dent", DentItem::new);
	public static final DeferredItem<Item> MATERWELON = REGISTRY.register("materwelon", MaterwelonItem::new);
	public static final DeferredItem<Item> MONODENT = REGISTRY.register("monodent", MonodentItem::new);
	public static final DeferredItem<Item> DIDENT = REGISTRY.register("dident", DidentItem::new);
	public static final DeferredItem<Item> FRYING_PAN = REGISTRY.register("frying_pan", FryingPanItem::new);
	public static final DeferredItem<Item> GOLEM_ARM = REGISTRY.register("golem_arm", GolemArmItem::new);
	public static final DeferredItem<Item> BIG_SPAWN_EGG = REGISTRY.register("big_spawn_egg", () -> new DeferredSpawnEggItem(KraftminedModEntities.BIG, -39169, -256, new Item.Properties()));
	public static final DeferredItem<Item> GOOSE_SPAWN_EGG = REGISTRY.register("goose_spawn_egg", () -> new DeferredSpawnEggItem(KraftminedModEntities.GOOSE, -9281975, -12966892, new Item.Properties()));
	public static final DeferredItem<Item> FLYING_SQUID_SPAWN_EGG = REGISTRY.register("flying_squid_spawn_egg", () -> new DeferredSpawnEggItem(KraftminedModEntities.FLYING_SQUID, -15312235, -8843762, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
