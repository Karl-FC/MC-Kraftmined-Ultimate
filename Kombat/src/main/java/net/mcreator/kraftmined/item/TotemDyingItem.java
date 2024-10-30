
package net.mcreator.kraftmined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TotemDyingItem extends Item {
	public TotemDyingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}
}
