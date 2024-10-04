package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LifestealProcedureProcedure {
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
		double Blood = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).isEnchanted() && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:lifesteal")))) != 0) {
			Blood = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:lifesteal"))));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount * 0.25 * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:lifesteal"))))));
			if (Blood >= 1) {
				world.addParticle((SimpleParticleType) (KraftmineModParticleTypes.LIFESTEAL_PARTICLES.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)),
						(entity.getY() + 1 + Mth.nextInt(RandomSource.create(), (int) 0.5, 2)), (entity.getZ() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)), 0, 1, 0);
				if (Blood >= 2) {
					world.addParticle((SimpleParticleType) (KraftmineModParticleTypes.LIFESTEAL_PARTICLES.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)),
							(entity.getY() + 1 + Mth.nextInt(RandomSource.create(), (int) 0.5, 2)), (entity.getZ() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)), 0, 1, 0);
					if (Blood >= 3) {
						world.addParticle((SimpleParticleType) (KraftmineModParticleTypes.LIFESTEAL_PARTICLES.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)),
								(entity.getY() + 1 + Mth.nextInt(RandomSource.create(), (int) 0.5, 2)), (entity.getZ() + Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.5)), 0, 1, 0);
					}
				}
			}
		}
	}
}
