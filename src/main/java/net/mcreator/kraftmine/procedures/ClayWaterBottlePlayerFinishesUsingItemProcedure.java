package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.kraftmine.init.KraftmineModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ClayWaterBottlePlayerFinishesUsingItemProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
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
			WaterContent = Bottle.getOrCreateTag().getDouble("content");
			if (WaterContent == 5) {
				CupDrinkProcedure.execute(entity);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.CLAY_BOTTLE.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if (WaterContent < 5) {
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					Bottle.getOrCreateTag().putDouble("content", (WaterContent + 1));
					CupDrinkProcedure.execute(entity);
				} else {
					CupDrinkProcedure.execute(entity);
				}
			}
		}
	}
}
