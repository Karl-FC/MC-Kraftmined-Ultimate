package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

public class InfinitePotionNightVisionRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack Thepotion = ItemStack.EMPTY;
		double MoreCD = 0;
		double MoreHeal = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honey_bottle.drink")), SoundSource.PLAYERS, 1, 2);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honey_bottle.drink")), SoundSource.PLAYERS, 1, 2, false);
			}
		}
		Thepotion = itemstack;
		if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.REPLENISHMENT.get(), Thepotion) != 0) {
			MoreCD = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.REPLENISHMENT.get(), Thepotion);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), (int) (20 * (30 / (MoreCD + 2))));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) (20 * (30 + MoreCD * 30)), 1));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.EFFICACY.get(), Thepotion) != 0) {
			MoreHeal = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.EFFICACY.get(), Thepotion);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), (int) (20 * (30 + MoreHeal * 30)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) (20 * (20 + MoreHeal * 5)), (int) (MoreHeal + 1)));
		} else {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), 600);
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1));
		}
	}
}
