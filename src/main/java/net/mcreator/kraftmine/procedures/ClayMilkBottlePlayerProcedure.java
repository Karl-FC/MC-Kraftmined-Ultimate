package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;

public class ClayMilkBottlePlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double WaterContent = 0;
		WaterContent = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("content");
		if (WaterContent <= 0) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.CLAY_BOTTLE.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
			}
		} else if (WaterContent > 0) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("content", (WaterContent - 1));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
