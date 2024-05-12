
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.kraftmine.procedures.GolemsArmLivingEntityIsHitWithToolProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class GolemsArmItem extends SwordItem {
	public GolemsArmItem() {
		super(new Tier() {
			public int getUses() {
				return 250;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.IRON_INGOT));
			}
		}, 3, -3.5f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		GolemsArmLivingEntityIsHitWithToolProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}
}
