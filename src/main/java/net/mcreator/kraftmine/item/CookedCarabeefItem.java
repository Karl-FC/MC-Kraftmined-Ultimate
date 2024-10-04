
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedCarabeefItem extends Item {
	public CookedCarabeefItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationModifier(12.9f).build()));
	}
}
