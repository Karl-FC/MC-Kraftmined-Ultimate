package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class TheSwitcherProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState targetblock = Blocks.AIR.defaultBlockState();
		double targetZ = 0;
		double targetY = 0;
		double userY = 0;
		double targetX = 0;
		double userZ = 0;
		double userX = 0;
		Entity user = null;
		user = entity;
		targetblock = (world.getBlockState(BlockPos.containing(x, y, z)));
		if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			userX = user.getX();
			userY = user.getY();
			userZ = user.getZ();
			targetX = x;
			targetY = y;
			targetZ = z;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(user.getX(), user.getY(), user.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ladder.place")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((user.getX()), (user.getY()), (user.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ladder.place")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			{
				Entity _ent = user;
				_ent.teleportTo(targetX, targetY, targetZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(targetX, targetY, targetZ, _ent.getYRot(), _ent.getXRot());
			}
			world.setBlock(BlockPos.containing(targetX, targetY, targetZ), Blocks.AIR.defaultBlockState(), 3);
			if (user instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 1, false, false));
			world.setBlock(BlockPos.containing(userX, userY, userZ), targetblock, 3);
		}
	}
}
