
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

public class GlassShovelItem extends ShovelItem {
	public GlassShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 26;
			}

			public float getSpeed() {
				return 2f;
			}

			public float getAttackDamageBonus() {
				return -2f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 3;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.GLASS));
			}
		}, 1, -3f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Has a chance to explosively 'shatter' during use"));
	}
}
