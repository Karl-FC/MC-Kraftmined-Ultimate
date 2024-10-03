package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.Advancement;

import net.mcreator.kraftmine.network.KraftmineModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TalentLifeProcedureProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent.AdvancementEarnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAdvancement().value(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
		execute(null, world, x, y, z, advancement, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
		if (advancement == null || entity == null)
			return;
		double addhealth = 0;
		if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().get(ResourceLocation.parse("kraftmine:talent_life")).value().equals(advancement)) {
			if (!(entity.getData(KraftmineModVariables.PLAYER_VARIABLES).PlayerMaxHealth > 20)) {
				addhealth = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).PlayerMaxHealth + 10;
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("attribute @p minecraft:generic.max_health base set " + addhealth));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.PlayerMaxHealth = addhealth;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
