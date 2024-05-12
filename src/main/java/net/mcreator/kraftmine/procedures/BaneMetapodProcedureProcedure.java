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
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BaneMetapodProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double BaneLevel = 0;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted()
				&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BANEOF_METAPOD.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 1) {
			BaneLevel = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BANEOF_METAPOD.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
			entity.hurt(DamageSource.GENERIC, Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) * 0.25
					* EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BANEOF_METAPOD.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.BANEOF_METAPOD_PARTICLES.get()), (entity.getX()), (entity.getY()), (entity.getZ()), (int) BaneLevel, 1, 1, 1, 0.6);
		}
	}
}
