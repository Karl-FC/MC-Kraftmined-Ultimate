package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GigaChadProcedure {
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
		if (sourceentity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.GIGA_EFFECT.get()) : false) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				entity.hurt(DamageSource.GENERIC, Mth.nextInt(RandomSource.create(), 15, 20));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 60, 1));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1));
		}
	}
}
