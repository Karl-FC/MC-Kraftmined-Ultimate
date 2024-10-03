package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class DripArmorBodyTickEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:drippy"))) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(KraftmineModMobEffects.DRIP))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.DRIP, 60, 1, false, false));
			if (itemstack.getItem() == KraftmineModItems.CARBON_ARMOR_BOOTS.get() && (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 7
					&& !(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.MOVEMENT_SPEED))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.DRIP, 60, 1, false, false));
			}
		}
	}
}
