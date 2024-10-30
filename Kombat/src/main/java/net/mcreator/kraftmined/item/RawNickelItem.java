
package net.mcreator.kraftmined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawNickelItem extends Item {
	public RawNickelItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
