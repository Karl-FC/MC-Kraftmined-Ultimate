package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.network.KraftmineModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ThirstPlayerDrinksProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:hydrated"))) && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).AllowDrink == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel < 20) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.ThirstExhaustionLevel = 0;
				_vars.syncPlayerVariables(entity);
			}
			if (!itemstack.is(ItemTags.create(ResourceLocation.parse("forge:drinkable_water")))) {
				{
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel + 4;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
