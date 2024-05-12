package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModParticleTypes;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class BleedEffectActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.BLEED_EFFECT.get()) : false) == true
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.REGENERATION) : false) == false) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.BLEED_EFFECT.get()) ? _livEnt.getEffect(KraftmineModMobEffects.BLEED_EFFECT.get()).getAmplifier() : 0, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 45,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.BLEED_EFFECT.get()) ? _livEnt.getEffect(KraftmineModMobEffects.BLEED_EFFECT.get()).getAmplifier() : 0, (false), (false)));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (KraftmineModParticleTypes.BLOOD.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 10, 1, 2, 1, 0);
		}
	}
}
