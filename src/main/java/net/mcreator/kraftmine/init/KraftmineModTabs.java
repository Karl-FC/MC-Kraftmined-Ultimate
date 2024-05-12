
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class KraftmineModTabs {
	public static CreativeModeTab TAB_CRTAB;
	public static CreativeModeTab TAB_CRTABCOMBAT;

	public static void load() {
		TAB_CRTAB = new CreativeModeTab("tabcrtab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(KraftmineModItems.FOOD_MATERWELON.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_CRTABCOMBAT = new CreativeModeTab("tabcrtabcombat") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(KraftmineModItems.NETHERITE_BATTLE_AXE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
