package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BackstabbingProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.DAGGER.get()
				^ EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BACKSTABBING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if ((sourceentity.getDirection()) == (entity.getDirection())) {
				damage = amount;
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				entity.hurt(DamageSource.GENERIC, (float) (damage * 3));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 2, 2, 0);
			} else if (!((sourceentity.getDirection()) == (entity.getDirection()))) {
				damage = amount;
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				entity.hurt(DamageSource.GENERIC, (float) (damage / 2));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.DAGGER.get()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BACKSTABBING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if ((sourceentity.getDirection()) == (entity.getDirection())) {
				damage = amount;
				entity.hurt(DamageSource.GENERIC, (float) (damage * 3));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (entity.getX()), (entity.getY()), (entity.getZ()), 15, 2, 2, 2, 0);
			} else if (!((sourceentity.getDirection()) == (entity.getDirection()))) {
				damage = amount;
				entity.hurt(DamageSource.GENERIC, (float) (damage / 2));
			}
		}
	}
}
