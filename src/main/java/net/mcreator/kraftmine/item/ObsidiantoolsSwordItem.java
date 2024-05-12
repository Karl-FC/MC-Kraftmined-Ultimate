
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class ObsidiantoolsSwordItem extends SwordItem {
	public ObsidiantoolsSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 130;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 45;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.OBSIDIANSCRAP.get()));
			}
		}, 3, -2f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
	}
}
