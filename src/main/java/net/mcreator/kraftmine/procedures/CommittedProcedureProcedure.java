package net.mcreator.kraftmine.procedures;

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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CommittedProcedureProcedure {
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
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:committed")))) != 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				extradamage = amount * Mth.nextInt(RandomSource.create(), 0, (int) (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:committed")))) + 1) * 0.25));
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) extradamage);
				world.addParticle(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isEnchanted() && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:committed")))) != 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				extradamage = amount * Mth.nextInt(RandomSource.create(), 0, (int) (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:committed")))) + 1) * 0.25));
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) extradamage);
				world.addParticle(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
			}
		}
	}
}
