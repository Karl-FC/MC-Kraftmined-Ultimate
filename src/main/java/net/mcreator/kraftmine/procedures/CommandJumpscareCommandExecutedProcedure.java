package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.HashMap;

public class CommandJumpscareCommandExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == true) {
			if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("setcooldown")) {
				if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("true")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p {\"text\":\"gamerule setcooldown has been set to True\",\"color\":\"#00FF00\"}");
					KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown = true;
					KraftmineModVariables.WorldVariables.get(world).syncData(world);
				} else if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("false")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p {\"text\":\"gamerule setcooldown has been set to False\",\"color\":\"#00FF00\"}");
					KraftmineModVariables.WorldVariables.get(world).Jumpscare_Cooldown = false;
					KraftmineModVariables.WorldVariables.get(world).syncData(world);
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p {\"text\":\"Unknown command. Type /jumpscare help for help\",\"color\":\"#F4FF00\"}");
				}
			} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("help")) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p {\"text\":\"/Jumpscare selcooldown <true or false>\",\"color\":\"#FFFF00\"}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p {\"text\":\"/Jumpscare summon <number from 1-5>\",\"color\":\"#FFFF00\"}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p {\"text\":\"/Jumpscare help\",\"color\":\"#FFFF00\"}");
			} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("summon")) {
				if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.JUMPSCARE_EFFECT, 60, 1));
					{
						KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
						_vars.JumpscareVariant = Mth.nextInt(RandomSource.create(), 1, 5);
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
					if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("1") || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 1) {
						Jump1ProcedureProcedure.execute(world, entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1, false);
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
					} else if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("2") || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 2) {
						Jump2ProcedureProcedure.execute(world, entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1, false);
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
					} else if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("3") || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 3) {
						Jump3ProcedureProcedure.execute(world, entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1, false);
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
					} else if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("4") || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 4) {
						Jump4ProcedureProcedure.execute(world, entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1, false);
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
					} else if ((cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("5") || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 5) {
						Jump5ProcedureProcedure.execute(world, entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.short")), SoundSource.HOSTILE, 5, 1, false);
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
				} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Jumpscare_CD != 0 || entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant != 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.criminal")), SoundSource.AMBIENT, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:horror.jumpscare.criminal")), SoundSource.AMBIENT, 2, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(":)"), true);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p {\"text\":\"Unknown command. Type /jumpscare help for help\",\"color\":\"#F4FF00\"}");
				}
			}
		} else if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == false) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p {\"text\":\"Gamerule Jumpscares is deactivated. Set it to True it to activate jumpscares\",\"color\":\"#F4FF00\"}");
		}
	}
}
