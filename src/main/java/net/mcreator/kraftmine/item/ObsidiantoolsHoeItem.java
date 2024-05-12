
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class ObsidiantoolsHoeItem extends HoeItem {
	public ObsidiantoolsHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 130;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 45;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.OBSIDIANSCRAP.get()));
			}
		}, 0, -2.5f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}
}
