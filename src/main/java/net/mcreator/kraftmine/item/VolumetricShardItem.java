
package net.mcreator.kraftmine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.procedures.ShardMakeItemGlowProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

import java.util.List;

public class VolumetricShardItem extends Item {
	public VolumetricShardItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(16).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return ShardMakeItemGlowProcedure.execute(entity, itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Press Z to use"));
	}
}
