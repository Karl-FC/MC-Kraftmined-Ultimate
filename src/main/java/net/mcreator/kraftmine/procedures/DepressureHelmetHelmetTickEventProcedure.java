package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

public class DepressureHelmetHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.WATER) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 1, (true), (false)));
		}
		if ((entity.level.dimension()) == (Level.OVERWORLD) && y < -60) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 100, (false), (false)));
		}
		if (y < -64 && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.VOID_AIR) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1, (true), (false)));
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 64), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 64), z, _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
				ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms"));
				if (_player.level.dimension() == destinationType)
					return;
				ServerLevel nextLevel = _player.server.getLevel(destinationType);
				if (nextLevel != null) {
					_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
					_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
					_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
					for (MobEffectInstance _effectinstance : _player.getActiveEffects())
						_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
					_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:backrooms")))) {
				BackroomsOriginProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
