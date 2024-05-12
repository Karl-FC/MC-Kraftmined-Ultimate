package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GlassToolsProcedureProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getItem());
		}
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("kraftmine:tools_glass"))) && !(itemstack.getItem() == KraftmineModItems.GLASS_SWORD.get())) {
			if (Math.random() <= 20) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((itemstack).getMaxDamage(), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
