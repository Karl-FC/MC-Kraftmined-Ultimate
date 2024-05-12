
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public class FoodMaterwelonItem extends Item {
	public FoodMaterwelonItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.7f)

				.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}
}
