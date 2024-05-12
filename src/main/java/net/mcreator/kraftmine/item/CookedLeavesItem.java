
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public class CookedLeavesItem extends Item {
	public CookedLeavesItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(-0.1f).alwaysEat()

				.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}
}
