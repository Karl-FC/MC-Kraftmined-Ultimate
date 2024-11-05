
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

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

import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmUnplayableModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KmUnplayableMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRAFTMINE_UNPLAYABLE = REGISTRY.register("kraftmine_unplayable",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.km_unplayable.kraftmine_unplayable")).icon(() -> new ItemStack(KmUnplayableModItems.MATERWELON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KmUnplayableModItems.MATERWELON.get());
				tabData.accept(KmUnplayableModItems.MONODENT.get());
				tabData.accept(KmUnplayableModItems.DIDENT.get());
				tabData.accept(KmUnplayableModItems.FRYING_PAN.get());
				tabData.accept(KmUnplayableModItems.GOLEM_ARM.get());
				tabData.accept(KmUnplayableModItems.BIG_SPAWN_EGG.get());
				tabData.accept(KmUnplayableModBlocks.BLOCK_PAPER.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_COD.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_SALMON.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_GLASSBOTTLE.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCKROTTENFLESH.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_PHANTOMMEMBRANE.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_FEATHER.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_EGG.get().asItem());
				tabData.accept(KmUnplayableModBlocks.SALMON_ORE.get().asItem());
				tabData.accept(KmUnplayableModBlocks.COD_ORE.get().asItem());
				tabData.accept(KmUnplayableModBlocks.TROPICAL_FISH_ORE.get().asItem());
				tabData.accept(KmUnplayableModBlocks.BLOCK_TROPICALFISH.get().asItem());
				tabData.accept(KmUnplayableModBlocks.DIRT_ORE.get().asItem());
				tabData.accept(KmUnplayableModItems.SURPRISE_EGG.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(KmUnplayableModItems.MONODENT.get());
			tabData.accept(KmUnplayableModItems.DIDENT.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(KmUnplayableModItems.BIG_SPAWN_EGG.get());
			tabData.accept(KmUnplayableModItems.GOOSE_SPAWN_EGG.get());
			tabData.accept(KmUnplayableModItems.FLYING_SQUID_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(KmUnplayableModItems.FRYING_PAN.get());

		}
	}
}
