package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

public class LifeOrbOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double addhealth = 0;
		if (!(entity.getPersistentData().getDouble("minecraft:generic.max_health") >= 60) && (entity instanceof Player _plr ? _plr.experienceLevel : 0) > 20) {
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(5));
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(KraftmineModBlocks.LIFE_ORB.get().defaultBlockState()));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 1, false, false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
	}
}
