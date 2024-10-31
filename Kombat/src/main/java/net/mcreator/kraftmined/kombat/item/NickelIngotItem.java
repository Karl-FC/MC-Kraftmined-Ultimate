
package net.mcreator.kraftmined.kombat.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NickelIngotItem extends Item {
	public NickelIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
