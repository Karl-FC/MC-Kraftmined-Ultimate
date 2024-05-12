package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MobAmogusPlayerCollidesWithThisEntityProcedure {
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
		double SusMultiplier = 0;
		double SusTime = 0;
		if (sourceentity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:amogus"))) && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.DRIP.get()) : false) == false) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SUS.get(), 200, 1));
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.SUS.get()) : false) {
				SusMultiplier = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.SUS.get()) ? _livEnt.getEffect(KraftmineModMobEffects.SUS.get()).getAmplifier() : 0;
				SusTime = 200 - SusMultiplier * 20;
				entity.hurt(DamageSource.GENERIC, (float) (1 + SusMultiplier));
				if (SusTime < 20) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) (SusMultiplier * 2), (int) (SusMultiplier + 1)));
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SUS.get(), (int) SusTime, (int) (SusMultiplier + 1)));
				}
			} else {
				SusMultiplier = 0;
			}
			if (sourceentity instanceof Player _player) {
				_player.getAbilities().invulnerable = (true);
				_player.onUpdateAbilities();
			}
			KraftmineMod.queueServerWork(30, () -> {
				if (sourceentity instanceof Player _player) {
					_player.getAbilities().invulnerable = (true);
					_player.onUpdateAbilities();
				}
			});
		}
	}
}
