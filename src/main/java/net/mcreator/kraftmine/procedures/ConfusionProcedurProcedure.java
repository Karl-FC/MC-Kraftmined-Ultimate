package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ConfusionProcedurProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double dmg = 0;
		dmg = amount;
		if (sourceentity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.CONFUSION.get()) : false) {
			if (Math.random() <= 50) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("confused").bypassArmor(), Mth.nextInt(RandomSource.create(), (int) Math.round(dmg / 5),
							(int) (dmg + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.CONFUSION.get()) ? _livEnt.getEffect(KraftmineModMobEffects.CONFUSION.get()).getAmplifier() : 0) * 3)));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:player.oof")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:player.oof")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}
