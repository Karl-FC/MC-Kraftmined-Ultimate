
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

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

import net.mcreator.kraftmined.KraftminedMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KraftminedModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KraftminedMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRAFTMINE_KOMBAT = REGISTRY.register("kraftmine_kombat",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.kraftmined.kraftmine_kombat")).icon(() -> new ItemStack(KraftminedModItems.NETHERITE_BATTLEAXE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KraftminedModItems.NETHERITE_BATTLEAXE.get());
				tabData.accept(KraftminedModItems.QUIVER_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.EYEPATCH_HELMET.get());
				tabData.accept(KraftminedModItems.OBSIDIAN_SCRAP.get());
				tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.WOOD_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.WOOD_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.WOOD_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.WOOD_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.STONE_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.STONE_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.STONE_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.STONE_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.LAPIS_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.LAPIS_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.LAPIS_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.LAPIS_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.CACTUS_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.CACTUS_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.CACTUS_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.CACTUS_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.TNT_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.TNT_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.TNT_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.TNT_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.NICKEL_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.NICKEL_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.NICKEL_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.NICKEL_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_BOOTS.get());
				tabData.accept(KraftminedModItems.TITANIUM_ARMOR_HELMET.get());
				tabData.accept(KraftminedModItems.TITANIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(KraftminedModItems.TITANIUM_ARMOR_LEGGINGS.get());
				tabData.accept(KraftminedModItems.TITANIUM_ARMOR_BOOTS.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

			tabData.accept(KraftminedModBlocks.NICKEL_ORE.get().asItem());
			tabData.accept(KraftminedModBlocks.NICKEL_BLOCK.get().asItem());
			tabData.accept(KraftminedModBlocks.TUNGSTEN_ORE.get().asItem());
			tabData.accept(KraftminedModBlocks.TUNGSTEN_BLOCK.get().asItem());
			tabData.accept(KraftminedModBlocks.TITANIUM_ORE.get().asItem());
			tabData.accept(KraftminedModBlocks.TITANIUM_BLOCK.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(KraftminedModItems.EYEPATCH_HELMET.get());
			tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.OBSIDIAN_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.WOOD_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.WOOD_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.WOOD_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.WOOD_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.STONE_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.STONE_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.STONE_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.STONE_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.LAPIS_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.LAPIS_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.LAPIS_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.LAPIS_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.CACTUS_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.CACTUS_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.CACTUS_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.CACTUS_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.TNT_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.TNT_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.TNT_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.TNT_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.NICKEL_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.NICKEL_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.NICKEL_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.NICKEL_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.TUNGSTEN_ARMOR_BOOTS.get());
			tabData.accept(KraftminedModItems.TITANIUM_ARMOR_HELMET.get());
			tabData.accept(KraftminedModItems.TITANIUM_ARMOR_CHESTPLATE.get());
			tabData.accept(KraftminedModItems.TITANIUM_ARMOR_LEGGINGS.get());
			tabData.accept(KraftminedModItems.TITANIUM_ARMOR_BOOTS.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(KraftminedModItems.NICKEL_INGOT.get());
			tabData.accept(KraftminedModItems.TUNGSTEN_INGOT.get());
			tabData.accept(KraftminedModItems.TITANIUM_INGOT.get());

		}
	}
}
