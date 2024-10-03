package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GlassToolsProcedureProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getItem());
		}
	}

	public static void execute(LevelAccessor world, ItemStack itemstack) {
		execute(null, world, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("kraftmine:tools_glass"))) && !(itemstack.getItem() == KraftmineModItems.GLASS_SWORD.get())) {
			if (Math.random() <= 20) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(itemstack.getMaxDamage(), _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}
