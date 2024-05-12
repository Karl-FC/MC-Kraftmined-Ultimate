
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class PlasticHoeItem extends HoeItem {
	public PlasticHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 216;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 13;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.PLASTIC.get()));
			}
		}, 0, -3f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}
}
