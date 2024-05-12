
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class TungstenPickaxeItem extends PickaxeItem {
	public TungstenPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 660;
			}

			public float getSpeed() {
				return 15f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 28;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.TUNGSTEN_INGOT.get()));
			}
		}, 1, -2f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB));
	}
}
