
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
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRAFTMINE_UNPLAYABLE = REGISTRY.register("kraftmine_unplayable",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.kraftmined.kraftmine_unplayable")).icon(() -> new ItemStack(KraftminedModItems.MATERWELON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KraftminedModItems.MATERWELON.get());
				tabData.accept(KraftminedModItems.MONODENT.get());
				tabData.accept(KraftminedModItems.DIDENT.get());
				tabData.accept(KraftminedModItems.FRYING_PAN.get());
				tabData.accept(KraftminedModItems.GOLEM_ARM.get());
				tabData.accept(KraftminedModItems.BIG_SPAWN_EGG.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(KraftminedModItems.MONODENT.get());
			tabData.accept(KraftminedModItems.DIDENT.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(KraftminedModItems.BIG_SPAWN_EGG.get());
			tabData.accept(KraftminedModItems.GOOSE_SPAWN_EGG.get());
			tabData.accept(KraftminedModItems.FLYING_SQUID_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(KraftminedModItems.FRYING_PAN.get());

		}
	}
}
