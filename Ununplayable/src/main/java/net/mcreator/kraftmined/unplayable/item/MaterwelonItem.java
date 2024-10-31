
package net.mcreator.kraftmined.unplayable.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class MaterwelonItem extends Item {
	public MaterwelonItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(-2).saturationModifier(12.8f).alwaysEdible().build()));
	}
}
