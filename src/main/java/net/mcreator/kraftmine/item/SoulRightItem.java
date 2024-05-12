
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public class SoulRightItem extends Item {
	public SoulRightItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}
}
