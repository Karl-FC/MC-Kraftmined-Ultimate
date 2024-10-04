package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.KraftmineMod;

public class JumpscareAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 0
				&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(KraftmineModMobEffects.DRIP))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.JUMPSCARE_EFFECT, 60, 1));
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.JumpscareVariant = Mth.nextInt(RandomSource.create(), 1, 7);
				_vars.syncPlayerVariables(entity);
			}
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel - 5;
				_vars.syncPlayerVariables(entity);
			}
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Jumpscare_CD = 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 1) {
				Jump1ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 2) {
				Jump2ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 3) {
				Jump3ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 4) {
				Jump4ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 5) {
				Jump5ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 6) {
				Jump6ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 7) {
				Jump7ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.JumpscareVariant = 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
							_vars.Jumpscare_CD = 0;
							_vars.syncPlayerVariables(entity);
						}
					});
				}
			}
		}
	}
}
