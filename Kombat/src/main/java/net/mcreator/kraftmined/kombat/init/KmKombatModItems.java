
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.kraftmined.kombat.item.WoodArmorItem;
import net.mcreator.kraftmined.kombat.item.TungstenIngotItem;
import net.mcreator.kraftmined.kombat.item.TungstenArmorItem;
import net.mcreator.kraftmined.kombat.item.TotemDyingItem;
import net.mcreator.kraftmined.kombat.item.TotemCreepingItem;
import net.mcreator.kraftmined.kombat.item.TntArmorItem;
import net.mcreator.kraftmined.kombat.item.TitaniumIngotItem;
import net.mcreator.kraftmined.kombat.item.TitaniumArmorItem;
import net.mcreator.kraftmined.kombat.item.TestDummySpawnItem;
import net.mcreator.kraftmined.kombat.item.StoneArmorItem;
import net.mcreator.kraftmined.kombat.item.RedstoneArmorItem;
import net.mcreator.kraftmined.kombat.item.RawTungstenItem;
import net.mcreator.kraftmined.kombat.item.RawTitaniumItem;
import net.mcreator.kraftmined.kombat.item.RawNickelItem;
import net.mcreator.kraftmined.kombat.item.QuiverItem;
import net.mcreator.kraftmined.kombat.item.ObsidianScrapItem;
import net.mcreator.kraftmined.kombat.item.ObsidianArmorItem;
import net.mcreator.kraftmined.kombat.item.NickelIngotItem;
import net.mcreator.kraftmined.kombat.item.NickelArmorItem;
import net.mcreator.kraftmined.kombat.item.NetheriteBattleaxeItem;
import net.mcreator.kraftmined.kombat.item.LapisArmorItem;
import net.mcreator.kraftmined.kombat.item.EyepatchItem;
import net.mcreator.kraftmined.kombat.item.CactusArmorItem;
import net.mcreator.kraftmined.kombat.KmKombatMod;

public class KmKombatModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KmKombatMod.MODID);
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
	public static final DeferredItem<Item> NICKEL_INGOT = REGISTRY.register("nickel_ingot", NickelIngotItem::new);
	public static final DeferredItem<Item> NICKEL_ORE = block(KmKombatModBlocks.NICKEL_ORE);
	public static final DeferredItem<Item> NICKEL_BLOCK = block(KmKombatModBlocks.NICKEL_BLOCK);
	public static final DeferredItem<Item> TUNGSTEN_INGOT = REGISTRY.register("tungsten_ingot", TungstenIngotItem::new);
	public static final DeferredItem<Item> TUNGSTEN_ORE = block(KmKombatModBlocks.TUNGSTEN_ORE);
	public static final DeferredItem<Item> TUNGSTEN_BLOCK = block(KmKombatModBlocks.TUNGSTEN_BLOCK);
	public static final DeferredItem<Item> TITANIUM_INGOT = REGISTRY.register("titanium_ingot", TitaniumIngotItem::new);
	public static final DeferredItem<Item> TITANIUM_ORE = block(KmKombatModBlocks.TITANIUM_ORE);
	public static final DeferredItem<Item> TITANIUM_BLOCK = block(KmKombatModBlocks.TITANIUM_BLOCK);
	public static final DeferredItem<Item> RAW_NICKEL = REGISTRY.register("raw_nickel", RawNickelItem::new);
	public static final DeferredItem<Item> RAW_TITANIUM = REGISTRY.register("raw_titanium", RawTitaniumItem::new);
	public static final DeferredItem<Item> RAW_TUNGSTEN = REGISTRY.register("raw_tungsten", RawTungstenItem::new);
	public static final DeferredItem<Item> NICKEL_ARMOR_HELMET = REGISTRY.register("nickel_armor_helmet", NickelArmorItem.Helmet::new);
	public static final DeferredItem<Item> NICKEL_ARMOR_CHESTPLATE = REGISTRY.register("nickel_armor_chestplate", NickelArmorItem.Chestplate::new);
	public static final DeferredItem<Item> NICKEL_ARMOR_LEGGINGS = REGISTRY.register("nickel_armor_leggings", NickelArmorItem.Leggings::new);
	public static final DeferredItem<Item> NICKEL_ARMOR_BOOTS = REGISTRY.register("nickel_armor_boots", NickelArmorItem.Boots::new);
	public static final DeferredItem<Item> TUNGSTEN_ARMOR_HELMET = REGISTRY.register("tungsten_armor_helmet", TungstenArmorItem.Helmet::new);
	public static final DeferredItem<Item> TUNGSTEN_ARMOR_CHESTPLATE = REGISTRY.register("tungsten_armor_chestplate", TungstenArmorItem.Chestplate::new);
	public static final DeferredItem<Item> TUNGSTEN_ARMOR_LEGGINGS = REGISTRY.register("tungsten_armor_leggings", TungstenArmorItem.Leggings::new);
	public static final DeferredItem<Item> TUNGSTEN_ARMOR_BOOTS = REGISTRY.register("tungsten_armor_boots", TungstenArmorItem.Boots::new);
	public static final DeferredItem<Item> TITANIUM_ARMOR_HELMET = REGISTRY.register("titanium_armor_helmet", TitaniumArmorItem.Helmet::new);
	public static final DeferredItem<Item> TITANIUM_ARMOR_CHESTPLATE = REGISTRY.register("titanium_armor_chestplate", TitaniumArmorItem.Chestplate::new);
	public static final DeferredItem<Item> TITANIUM_ARMOR_LEGGINGS = REGISTRY.register("titanium_armor_leggings", TitaniumArmorItem.Leggings::new);
	public static final DeferredItem<Item> TITANIUM_ARMOR_BOOTS = REGISTRY.register("titanium_armor_boots", TitaniumArmorItem.Boots::new);
	public static final DeferredItem<Item> TOTEM_CREEPING = REGISTRY.register("totem_creeping", TotemCreepingItem::new);
	public static final DeferredItem<Item> TOTEM_DYING = REGISTRY.register("totem_dying", TotemDyingItem::new);
	public static final DeferredItem<Item> TEST_DUMMY_SPAWN = REGISTRY.register("test_dummy_spawn", TestDummySpawnItem::new);
	public static final DeferredItem<Item> REDSTONE_ARMOR_HELMET = REGISTRY.register("redstone_armor_helmet", RedstoneArmorItem.Helmet::new);
	public static final DeferredItem<Item> REDSTONE_ARMOR_CHESTPLATE = REGISTRY.register("redstone_armor_chestplate", RedstoneArmorItem.Chestplate::new);
	public static final DeferredItem<Item> REDSTONE_ARMOR_LEGGINGS = REGISTRY.register("redstone_armor_leggings", RedstoneArmorItem.Leggings::new);
	public static final DeferredItem<Item> REDSTONE_ARMOR_BOOTS = REGISTRY.register("redstone_armor_boots", RedstoneArmorItem.Boots::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
