
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmine.procedures.NethersWrathEntityIsHitWithToolProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

import java.util.List;

public class NethersWrathItem extends SwordItem {
	public NethersWrathItem() {
		super(new Tier() {
			public int getUses() {
				return 2000;
			}

			public float getSpeed() {
				return 15f;
			}

			public float getAttackDamageBonus() {
				return 13f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 1;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.1f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		NethersWrathEntityIsHitWithToolProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), sourceentity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("May activate certain enchantments"));
	}
}
