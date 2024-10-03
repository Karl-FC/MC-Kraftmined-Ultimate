package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.KraftmineMod;

public class HydroArmorBootsTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double feather = 0;
		if (itemstack.getItem() == KraftmineModItems.HYDRO_ARMOR_BOOTS.get()) {
			if (false) {
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.OBSIDIAN.defaultBlockState(), 3);
			}
		} else if (itemstack.getItem() == KraftmineModItems.LAVA_ARMOR_BOOTS.get()) {
			if (false) {
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.OBSIDIAN.defaultBlockState(), 3);
			}
		}
		if (false) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), 10);
		} else {
			KraftmineMod.queueServerWork(40, () -> {
				EnchantmentHelper.updateEnchantments(itemstack,
						mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING))));
			});
		}
	}
}
