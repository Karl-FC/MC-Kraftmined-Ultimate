
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class ObsidianShearsItem extends ShearsItem {
	public ObsidianShearsItem() {
		super(new Item.Properties().durability(130));
	}

	@Override
	public int getEnchantmentValue() {
		return 45;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState blockstate) {
		return 12f;
	}
}
