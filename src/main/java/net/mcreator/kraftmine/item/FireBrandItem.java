
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.kraftmine.procedures.FireBrandLivingEntityIsHitWithToolProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class FireBrandItem extends SwordItem {
	public FireBrandItem() {
		super(new Tier() {
			public int getUses() {
				return 100;
			}

			public float getSpeed() {
				return 1f;
			}

			public float getAttackDamageBonus() {
				return 9f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 1;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.FIRE_CHARGE));
			}
		}, 3, -3f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		FireBrandLivingEntityIsHitWithToolProcedure.execute(entity, sourceentity);
		return retval;
	}
}
