
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.kombat.KmKombatMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmKombatModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KmKombatMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRAFTMINE_KOMBAT = REGISTRY.register("kraftmine_kombat",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.km_kombat.kraftmine_kombat")).icon(() -> new ItemStack(KmKombatModItems.NETHERITE_BATTLEAXE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KmKombatModItems.NETHERITE_BATTLEAXE.get());
				tabData.accept(KmKombatModItems.QUIVER_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.EYEPATCH_HELMET.get());
				tabData.accept(KmKombatModItems.OBSIDIAN_SCRAP.get());
				tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.WOOD_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.WOOD_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.WOOD_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.WOOD_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.STONE_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.STONE_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.STONE_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.STONE_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.LAPIS_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.LAPIS_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.LAPIS_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.LAPIS_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.CACTUS_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.CACTUS_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.CACTUS_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.CACTUS_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.TNT_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.TNT_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.TNT_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.TNT_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.NICKEL_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.NICKEL_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.NICKEL_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.NICKEL_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.TITANIUM_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.TITANIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.TITANIUM_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.TITANIUM_ARMOR_BOOTS.get());
				tabData.accept(KmKombatModItems.TOTEM_CREEPING.get());
				tabData.accept(KmKombatModItems.TOTEM_DYING.get());
				tabData.accept(KmKombatModItems.TEST_DUMMY_SPAWN.get());
				tabData.accept(KmKombatModItems.REDSTONE_ARMOR_HELMET.get());
				tabData.accept(KmKombatModItems.REDSTONE_ARMOR_CHESTPLATE.get());
				tabData.accept(KmKombatModItems.REDSTONE_ARMOR_LEGGINGS.get());
				tabData.accept(KmKombatModItems.REDSTONE_ARMOR_BOOTS.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

			tabData.accept(KmKombatModBlocks.NICKEL_ORE.get().asItem());
			tabData.accept(KmKombatModBlocks.NICKEL_BLOCK.get().asItem());
			tabData.accept(KmKombatModBlocks.TUNGSTEN_ORE.get().asItem());
			tabData.accept(KmKombatModBlocks.TUNGSTEN_BLOCK.get().asItem());
			tabData.accept(KmKombatModBlocks.TITANIUM_ORE.get().asItem());
			tabData.accept(KmKombatModBlocks.TITANIUM_BLOCK.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(KmKombatModItems.EYEPATCH_HELMET.get());
			tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.OBSIDIAN_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.WOOD_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.WOOD_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.WOOD_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.WOOD_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.STONE_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.STONE_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.STONE_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.STONE_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.LAPIS_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.LAPIS_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.LAPIS_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.LAPIS_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.CACTUS_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.CACTUS_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.CACTUS_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.CACTUS_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.TNT_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.TNT_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.TNT_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.TNT_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.NICKEL_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.NICKEL_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.NICKEL_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.NICKEL_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.TUNGSTEN_ARMOR_BOOTS.get());
			tabData.accept(KmKombatModItems.TITANIUM_ARMOR_HELMET.get());
			tabData.accept(KmKombatModItems.TITANIUM_ARMOR_CHESTPLATE.get());
			tabData.accept(KmKombatModItems.TITANIUM_ARMOR_LEGGINGS.get());
			tabData.accept(KmKombatModItems.TITANIUM_ARMOR_BOOTS.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(KmKombatModItems.NICKEL_INGOT.get());
			tabData.accept(KmKombatModItems.TUNGSTEN_INGOT.get());
			tabData.accept(KmKombatModItems.TITANIUM_INGOT.get());

		}
	}
}
