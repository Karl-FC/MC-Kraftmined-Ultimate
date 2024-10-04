package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class InfinitePotionInvisibilityRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack Thepotion = ItemStack.EMPTY;
		double MoreCD = 0;
		double MoreHeal = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.PLAYERS, 1, 2);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.PLAYERS, 1, 2, false);
			}
		}
		Thepotion = itemstack;
		if (Thepotion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:replenishment")))) != 0) {
			MoreCD = Thepotion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:replenishment"))));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), (int) (20 * (30 / (MoreCD + 2))));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) (20 * (30 + MoreCD * 30)), 1));
		} else if (Thepotion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:efficacy")))) != 0) {
			MoreHeal = Thepotion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:efficacy"))));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), (int) (20 * (30 + MoreHeal * 30)));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) (20 * (20 + MoreHeal * 5)), (int) (MoreHeal + 1)));
		} else {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(Thepotion.getItem(), 600);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 1));
		}
	}
}
