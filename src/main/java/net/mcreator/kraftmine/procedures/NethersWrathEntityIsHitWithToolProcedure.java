package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.entity.ZombiePigManEntity;
import net.mcreator.kraftmine.entity.HerobrineEntity;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.Map;

public class NethersWrathEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof HerobrineEntity) {
			((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.SHARPNESS, 5);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			KraftmineMod.queueServerWork(60, () -> {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(Enchantments.SHARPNESS)) {
						_enchantments.remove(Enchantments.SHARPNESS);
						EnchantmentHelper.setEnchantments(_enchantments, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
			});
		} else if (sourceentity instanceof ZombifiedPiglin || sourceentity instanceof Piglin || sourceentity instanceof WitherSkeleton || sourceentity instanceof ZombiePigManEntity) {
			((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.SHARPNESS, 2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			KraftmineMod.queueServerWork(60, () -> {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(Enchantments.SHARPNESS)) {
						_enchantments.remove(Enchantments.SHARPNESS);
						EnchantmentHelper.setEnchantments(_enchantments, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
			});
		}
	}
}
