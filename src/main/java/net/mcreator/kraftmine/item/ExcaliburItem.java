
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.kraftmine.procedures.ExcaliburEntityHitProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class ExcaliburItem extends SwordItem {
	public ExcaliburItem() {
		super(new Tier() {
			public int getUses() {
				return 250;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.DEEPSLATE));
			}
		}, 3, -3.9f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ExcaliburEntityHitProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity, itemstack);
		return retval;
	}
}
