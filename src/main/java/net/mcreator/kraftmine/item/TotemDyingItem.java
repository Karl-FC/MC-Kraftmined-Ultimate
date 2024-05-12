
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public class TotemDyingItem extends Item {
	public TotemDyingItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(64).rarity(Rarity.EPIC));
	}
}
