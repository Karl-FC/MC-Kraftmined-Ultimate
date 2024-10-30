
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.item.WoodArmorItem;
import net.mcreator.kraftmined.item.TntArmorItem;
import net.mcreator.kraftmined.item.StoneArmorItem;
import net.mcreator.kraftmined.item.QuiverItem;
import net.mcreator.kraftmined.item.ObsidianScrapItem;
import net.mcreator.kraftmined.item.ObsidianArmorItem;
import net.mcreator.kraftmined.item.NetheriteBattleaxeItem;
import net.mcreator.kraftmined.item.LapisArmorItem;
import net.mcreator.kraftmined.item.EyepatchItem;
import net.mcreator.kraftmined.item.CactusArmorItem;
import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KraftminedMod.MODID);
	public static final DeferredItem<Item> NETHERITE_BATTLEAXE = REGISTRY.register("netherite_battleaxe", NetheriteBattleaxeItem::new);
	public static final DeferredItem<Item> QUIVER_CHESTPLATE = REGISTRY.register("quiver_chestplate", QuiverItem.Chestplate::new);
	public static final DeferredItem<Item> EYEPATCH_HELMET = REGISTRY.register("eyepatch_helmet", EyepatchItem.Helmet::new);
	public static final DeferredItem<Item> OBSIDIAN_SCRAP = REGISTRY.register("obsidian_scrap", ObsidianScrapItem::new);
	public static final DeferredItem<Item> OBSIDIAN_ARMOR_HELMET = REGISTRY.register("obsidian_armor_helmet", ObsidianArmorItem.Helmet::new);
	public static final DeferredItem<Item> OBSIDIAN_ARMOR_CHESTPLATE = REGISTRY.register("obsidian_armor_chestplate", ObsidianArmorItem.Chestplate::new);
	public static final DeferredItem<Item> OBSIDIAN_ARMOR_LEGGINGS = REGISTRY.register("obsidian_armor_leggings", ObsidianArmorItem.Leggings::new);
	public static final DeferredItem<Item> OBSIDIAN_ARMOR_BOOTS = REGISTRY.register("obsidian_armor_boots", ObsidianArmorItem.Boots::new);
	public static final DeferredItem<Item> WOOD_ARMOR_HELMET = REGISTRY.register("wood_armor_helmet", WoodArmorItem.Helmet::new);
	public static final DeferredItem<Item> WOOD_ARMOR_CHESTPLATE = REGISTRY.register("wood_armor_chestplate", WoodArmorItem.Chestplate::new);
	public static final DeferredItem<Item> WOOD_ARMOR_LEGGINGS = REGISTRY.register("wood_armor_leggings", WoodArmorItem.Leggings::new);
	public static final DeferredItem<Item> WOOD_ARMOR_BOOTS = REGISTRY.register("wood_armor_boots", WoodArmorItem.Boots::new);
	public static final DeferredItem<Item> STONE_ARMOR_HELMET = REGISTRY.register("stone_armor_helmet", StoneArmorItem.Helmet::new);
	public static final DeferredItem<Item> STONE_ARMOR_CHESTPLATE = REGISTRY.register("stone_armor_chestplate", StoneArmorItem.Chestplate::new);
	public static final DeferredItem<Item> STONE_ARMOR_LEGGINGS = REGISTRY.register("stone_armor_leggings", StoneArmorItem.Leggings::new);
	public static final DeferredItem<Item> STONE_ARMOR_BOOTS = REGISTRY.register("stone_armor_boots", StoneArmorItem.Boots::new);
	public static final DeferredItem<Item> LAPIS_ARMOR_HELMET = REGISTRY.register("lapis_armor_helmet", LapisArmorItem.Helmet::new);
	public static final DeferredItem<Item> LAPIS_ARMOR_CHESTPLATE = REGISTRY.register("lapis_armor_chestplate", LapisArmorItem.Chestplate::new);
	public static final DeferredItem<Item> LAPIS_ARMOR_LEGGINGS = REGISTRY.register("lapis_armor_leggings", LapisArmorItem.Leggings::new);
	public static final DeferredItem<Item> LAPIS_ARMOR_BOOTS = REGISTRY.register("lapis_armor_boots", LapisArmorItem.Boots::new);
	public static final DeferredItem<Item> CACTUS_ARMOR_HELMET = REGISTRY.register("cactus_armor_helmet", CactusArmorItem.Helmet::new);
	public static final DeferredItem<Item> CACTUS_ARMOR_CHESTPLATE = REGISTRY.register("cactus_armor_chestplate", CactusArmorItem.Chestplate::new);
	public static final DeferredItem<Item> CACTUS_ARMOR_LEGGINGS = REGISTRY.register("cactus_armor_leggings", CactusArmorItem.Leggings::new);
	public static final DeferredItem<Item> CACTUS_ARMOR_BOOTS = REGISTRY.register("cactus_armor_boots", CactusArmorItem.Boots::new);
	public static final DeferredItem<Item> TNT_ARMOR_HELMET = REGISTRY.register("tnt_armor_helmet", TntArmorItem.Helmet::new);
	public static final DeferredItem<Item> TNT_ARMOR_CHESTPLATE = REGISTRY.register("tnt_armor_chestplate", TntArmorItem.Chestplate::new);
	public static final DeferredItem<Item> TNT_ARMOR_LEGGINGS = REGISTRY.register("tnt_armor_leggings", TntArmorItem.Leggings::new);
	public static final DeferredItem<Item> TNT_ARMOR_BOOTS = REGISTRY.register("tnt_armor_boots", TntArmorItem.Boots::new);
	// Start of user code block custom items
	// End of user code block custom items
}
