
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmine.init.KraftmineModTabs;

import java.util.List;

public class IceHoeItem extends HoeItem {
	public IceHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 152;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return -1f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.PACKED_ICE));
			}
		}, 0, -3f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Deals extra frost damage"));
		list.add(Component.literal("Slows down the player"));
	}
}
