package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class ClayWaterBottleItemIsCraftedsmeltedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == KraftmineModItems.CLAY_WATER_BOTTLE.get()) {
			{
				final String _tagName = "content";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			ClaybottleContentProcedure.execute(entity, itemstack);
		}
	}
}
