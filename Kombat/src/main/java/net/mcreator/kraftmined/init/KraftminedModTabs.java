
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
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(KraftminedModItems.EYEPATCH_HELMET.get());

		}
	}
}
