package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BleedingEdgeProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double EnchantLevel = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem && ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BLEEDING_EDGE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			EnchantLevel = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BLEEDING_EDGE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * EnchantLevel * 0.1) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.BLEED_EFFECT.get(), 600, 1));
			}
		}
	}
}
