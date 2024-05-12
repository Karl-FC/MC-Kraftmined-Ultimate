
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class PlasticCutlassItem extends SwordItem {
	public PlasticCutlassItem() {
		super(new Tier() {
			public int getUses() {
				return 215;
			}

			public float getSpeed() {
				return 3.5f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.PLASTIC.get()));
			}
		}, 3, -2.4f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
	}
}
