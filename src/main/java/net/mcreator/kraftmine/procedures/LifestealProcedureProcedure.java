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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LifestealProcedureProcedure {
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
		double Blood = 0;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.LIFESTEAL.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			Blood = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.LIFESTEAL.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ amount * 0.25 * EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.LIFESTEAL.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))));
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
