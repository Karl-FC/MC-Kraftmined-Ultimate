
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.kraftmine.procedures.UnoReverseCardRightclickedProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class UnoReverseCardItem extends Item {
	public UnoReverseCardItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat()

				.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.CROSSBOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 50;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		UnoReverseCardRightclickedProcedure.execute(world, x, y, z, entity);
		return retval;
	}
}
