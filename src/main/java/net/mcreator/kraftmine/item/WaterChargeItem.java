
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.kraftmine.procedures.WaterChargeRightclickedOnBlockProcedure;

public class WaterChargeItem extends Item {
	public WaterChargeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WaterChargeRightclickedOnBlockProcedure.execute(context.getLevel(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
