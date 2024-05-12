
package net.mcreator.kraftmine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmine.procedures.StickOfDeathLivingEntityIsHitWithToolProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

import java.util.List;

public class StickOfDeathItem extends SwordItem {
	public StickOfDeathItem() {
		super(new Tier() {
			public int getUses() {
				return 3;
			}

			public float getSpeed() {
				return 1f;
			}

			public float getAttackDamageBonus() {
				return 6.200000000000001f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.9f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		StickOfDeathLivingEntityIsHitWithToolProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Use wisely"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
