
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

import net.mcreator.kraftmine.procedures.ClaybottleContentProcedure;
import net.mcreator.kraftmine.procedures.ClayWaterBottleRightclickedOnBlockProcedure;
import net.mcreator.kraftmine.procedures.ClayWaterBottlePlayerFinishesUsingItemProcedure;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class PlasticWaterBottle15Item extends Item {
	public PlasticWaterBottle15Item() {
		super(new Item.Properties().tab(null).durability(7).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat()

				.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 30;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(KraftmineModItems.CLAY_WATER_BOTTLE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ClayWaterBottlePlayerFinishesUsingItemProcedure.execute(entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ClayWaterBottleRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ClaybottleContentProcedure.execute(entity, itemstack);
	}
}
