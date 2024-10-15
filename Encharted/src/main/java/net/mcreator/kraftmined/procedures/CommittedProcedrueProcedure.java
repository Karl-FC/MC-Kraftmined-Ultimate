package net.mcreator.kraftmined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.kraftmined.init.KraftminedModAttributes;
import net.mcreator.kraftmined.KraftminedMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CommittedProcedrueProcedure {
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
		double extradamage = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isEnchanted() && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmined:committed")))) != 0) {
			if (Math.random() <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmined:committed")))) * 0.15) {
				extradamage = (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(KraftminedModAttributes.COMMITTMENT) ? _livingEntity6.getAttribute(KraftminedModAttributes.COMMITTMENT).getBaseValue() : 0)
						* amount * 0.25;
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) extradamage);
				world.addParticle(ParticleTypes.SPIT, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
			}
			if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(KraftminedModAttributes.COMMITTMENT))
				_livingEntity14.getAttribute(KraftminedModAttributes.COMMITTMENT).setBaseValue(
						((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(KraftminedModAttributes.COMMITTMENT) ? _livingEntity13.getAttribute(KraftminedModAttributes.COMMITTMENT).getBaseValue() : 0)
								+ 1));
			KraftminedMod.queueServerWork(60, () -> {
				if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(KraftminedModAttributes.COMMITTMENT))
					_livingEntity15.getAttribute(KraftminedModAttributes.COMMITTMENT).setBaseValue(0);
			});
		}
	}
}
