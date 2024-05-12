
package net.mcreator.kraftmine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.procedures.ShardMakeItemGlowProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public class TranscendenceShardItem extends Item {
	public TranscendenceShardItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
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
}
