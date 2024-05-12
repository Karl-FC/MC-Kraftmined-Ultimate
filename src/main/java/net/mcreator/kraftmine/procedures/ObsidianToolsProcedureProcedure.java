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
public class ObsidianToolsProcedureProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
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
		if (itemstack.is(ItemTags.create(new ResourceLocation("kraftmine:tools_obsidian")))) {
			if (Math.random() <= 33) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.BLEED_EFFECT.get(), 600, 1, (false), (false)));
			}
		}
	}
}
