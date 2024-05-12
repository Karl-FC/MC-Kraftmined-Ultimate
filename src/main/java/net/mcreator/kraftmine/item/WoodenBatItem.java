
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.kraftmine.procedures.WoodenBatLivingEntityIsHitWithToolProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class WoodenBatItem extends SwordItem {
	public WoodenBatItem() {
		super(new Tier() {
			public int getUses() {
				return 60;
			}

			public float getSpeed() {
				return 0f;
			}

			public float getAttackDamageBonus() {
				return 1.9999999999999996f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.WOOD_INGOT.get()));
			}
		}, 3, -2.7000000000000002f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		WoodenBatLivingEntityIsHitWithToolProcedure.execute(entity, itemstack);
		return retval;
	}
}
