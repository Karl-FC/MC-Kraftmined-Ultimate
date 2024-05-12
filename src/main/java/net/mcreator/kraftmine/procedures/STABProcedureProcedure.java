package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class STABProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double extradamage = 0;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.STAB.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			extradamage = amount * EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.STAB.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 0.25;
			entity.hurt(DamageSource.GENERIC, (float) extradamage);
		}
	}
}
