package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClayWaterBottlePlayerFinishesUsingItemProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double WaterContent = 0;
		ItemStack Bottle = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.CLAY_WATER_BOTTLE.get()) {
			Bottle = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			WaterContent = Bottle.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("content");
			if (WaterContent == 5) {
				CupDrinkProcedure.execute(entity);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.CLAY_BOTTLE.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if (WaterContent < 5) {
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					{
						final String _tagName = "content";
						final double _tagValue = (WaterContent + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, Bottle, tag -> tag.putDouble(_tagName, _tagValue));
					}
					CupDrinkProcedure.execute(entity);
				} else {
					CupDrinkProcedure.execute(entity);
				}
			}
		}
	}
}
