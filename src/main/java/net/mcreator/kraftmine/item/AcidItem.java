
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModFluids;

public class AcidItem extends BucketItem {
	public AcidItem() {
		super(KraftmineModFluids.ACID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE).tab(KraftmineModTabs.TAB_CRTAB));
	}
}
