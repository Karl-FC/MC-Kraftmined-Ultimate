package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.KraftmineMod;

public class JumpscareAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == true
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 0
				&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.DRIP.get()) : false)) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.JUMPSCARE_EFFECT.get(), 60, 1));
			{
				double _setval = Mth.nextInt(RandomSource.create(), 1, 7);
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JumpscareVariant = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel - 5;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Thirstlevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 1;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Jumpscare_CD = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 1) {
				Jump1ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 2) {
				Jump2ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 3) {
				Jump3ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 4) {
				Jump4ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 5) {
				Jump5ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 6) {
				Jump6ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			} else if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 7) {
				Jump7ProcedureProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:horror.jumpscare")), SoundSource.HOSTILE, 5, 1, false);
					}
				}
				if (KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown == true) {
					KraftmineMod.queueServerWork(1200, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				} else {
					KraftmineMod.queueServerWork(20, () -> {
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.JumpscareVariant = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Jumpscare_CD = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			}
		}
	}
}
