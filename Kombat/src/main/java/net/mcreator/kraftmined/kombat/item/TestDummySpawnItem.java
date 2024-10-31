
package net.mcreator.kraftmined.kombat.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.kraftmined.kombat.procedures.TestDummySpawnRightclickedOnBlockProcedure;

import java.util.List;

public class TestDummySpawnItem extends Item {
	public TestDummySpawnItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("Click on block to spawn"));
		list.add(Component.literal("Sneak while using Use Button on Dummy to change modes"));
		list.add(Component.literal("MODE 1: Default"));
		list.add(Component.literal("MODE 2: Damage Counter"));
		list.add(Component.literal("MODE 3: HP Indicator"));
		list.add(Component.literal("MODE 4: HP Percentage"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TestDummySpawnRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}
}
