package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RefreshingProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:hydrated")))) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.HYDRATED.get(), 200, 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(KraftmineModMobEffects.THIRSTY.get());
		}
	}
}
