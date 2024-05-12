
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class ObsidiantoolsShovelItem extends ShovelItem {
	public ObsidiantoolsShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 130;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 3f;
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
		}, 1, -2f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).fireResistant());
	}
}
