
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.encharted.KmEnchartedMod;

public class KmEnchartedModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KmEnchartedMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRAFTMINE_ENCHANTMENTS = REGISTRY.register("kraftmine_enchantments",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.km_encharted.kraftmine_enchantments")).icon(() -> new ItemStack(Blocks.BOOKSHELF)).displayItems((parameters, tabData) -> {
				tabData.accept(KmEnchartedModItems.INFINITE_HEAL.get());
				tabData.accept(KmEnchartedModItems.INFINITE_RESISTANCE.get());
				tabData.accept(KmEnchartedModItems.INFINITE_SLOWFALLING.get());
				tabData.accept(KmEnchartedModItems.INFINITE_FIRERESISTANCE.get());
				tabData.accept(KmEnchartedModItems.INFINITE_STRENGTH.get());
				tabData.accept(KmEnchartedModItems.INFINITE_INVISIBILITY.get());
				tabData.accept(KmEnchartedModItems.INFINITE_NIGHTVISION.get());
				tabData.accept(KmEnchartedModItems.INFINITE_WATERBREATHING.get());
				tabData.accept(KmEnchartedModItems.INFINITE_SATURATION.get());
				tabData.accept(KmEnchartedModItems.INFINITE_SWIFTNESS.get());
				tabData.accept(KmEnchartedModItems.INFINITE_LEAPING.get());
			}).withSearchBar().build());
}
