package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class SupplyDropsProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
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
					for (int index0 = 0; index0 < (int) (5); index0++) {
						PosX = entityiterator.getX() + Mth.nextInt(RandomSource.create(), -16, 16);
						PosY = entityiterator.getY() + Mth.nextInt(RandomSource.create(), 5, 10);
						PosZ = entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -16, 16);
						if ((world.getBlockState(new BlockPos(PosX, PosY, PosZ))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
							break;
						}
					}
					if ((world.getBlockState(new BlockPos(PosX, PosY, PosZ))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						if (world instanceof ServerLevel _level)
							FallingBlockEntity.fall(_level, new BlockPos(PosX, PosY, PosZ), KraftmineModBlocks.SUPPLY_CRATE.get().defaultBlockState());
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(PosX, PosY, PosZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(PosX, PosY, PosZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
