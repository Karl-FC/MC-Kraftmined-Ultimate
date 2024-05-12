
package net.mcreator.kraftmine.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.kraftmine.procedures.TestDummyItemRightclickedOnBlockProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class TestDummyItemItem extends Item {
	public TestDummyItemItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TestDummyItemRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()),
				context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
