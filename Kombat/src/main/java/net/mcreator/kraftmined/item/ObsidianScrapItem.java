
package net.mcreator.kraftmined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ObsidianScrapItem extends Item {
	public ObsidianScrapItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
