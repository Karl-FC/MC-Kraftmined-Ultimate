
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SapphireCoinItem extends Item {
	public SapphireCoinItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
