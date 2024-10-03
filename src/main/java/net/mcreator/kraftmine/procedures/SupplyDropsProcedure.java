package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class SupplyDropsProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double PosX = 0;
		double PosY = 0;
		double PosZ = 0;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.SUPPLIES) == true) {
			KraftmineModVariables.WorldVariables.get(world).SupplyTImer = KraftmineModVariables.WorldVariables.get(world).SupplyTImer + 1;
			KraftmineModVariables.WorldVariables.get(world).syncData(world);
			if (KraftmineModVariables.WorldVariables.get(world).SupplyTImer == 144000) {
				KraftmineModVariables.WorldVariables.get(world).SupplyTImer = 0;
				KraftmineModVariables.WorldVariables.get(world).syncData(world);
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					for (int index0 = 0; index0 < 5; index0++) {
						PosX = entityiterator.getX() + Mth.nextInt(RandomSource.create(), -16, 16);
						PosY = entityiterator.getY() + Mth.nextInt(RandomSource.create(), 5, 10);
						PosZ = entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -16, 16);
						if (false) {
							break;
						}
					}
					if (false) {
						if (world instanceof ServerLevel _level)
							FallingBlockEntity.fall(_level, BlockPos.containing(PosX, PosY, PosZ), KraftmineModBlocks.SUPPLY_CRATE.get().defaultBlockState());
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(PosX, PosY, PosZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(PosX, PosY, PosZ, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
