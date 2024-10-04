package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BackstabbingProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.DAGGER.get() ^ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:backstabbing")))) != 0) {
			if ((sourceentity.getDirection()) == (entity.getDirection())) {
				damage = amount;
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (damage * 3));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 2, 2, 0);
			} else if (!((sourceentity.getDirection()) == (entity.getDirection()))) {
				damage = amount;
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (damage / 2));
			}
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.DAGGER.get()
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:backstabbing")))) != 0) {
			if ((sourceentity.getDirection()) == (entity.getDirection())) {
				damage = amount;
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (damage * 3));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (entity.getX()), (entity.getY()), (entity.getZ()), 15, 2, 2, 2, 0);
			} else if (!((sourceentity.getDirection()) == (entity.getDirection()))) {
				damage = amount;
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (damage / 2));
			}
		}
	}
}
