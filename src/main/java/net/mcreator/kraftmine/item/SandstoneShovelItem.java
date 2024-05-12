
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmine.init.KraftmineModTabs;

import java.util.List;

public class SandstoneShovelItem extends ShovelItem {
	public SandstoneShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 183;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 11;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.SANDSTONE));
			}
		}, 1, -3f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Has a chance to temporarily blind those near it"));
	}
}
