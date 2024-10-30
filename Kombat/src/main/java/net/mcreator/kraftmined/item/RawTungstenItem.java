
package net.mcreator.kraftmined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawTungstenItem extends Item {
	public RawTungstenItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
