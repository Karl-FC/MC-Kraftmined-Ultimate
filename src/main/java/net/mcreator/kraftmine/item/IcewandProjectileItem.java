
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IcewandProjectileItem extends Item {
	public IcewandProjectileItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
