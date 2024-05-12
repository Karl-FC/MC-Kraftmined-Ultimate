package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.Map;

public class HydroArmorBootsTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double feather = 0;
		if (itemstack.getItem() == KraftmineModItems.HYDRO_ARMOR_BOOTS.get()) {
			if ((world.getBlockState(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()))).getMaterial() == net.minecraft.world.level.material.Material.LAVA) {
				world.setBlock(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.OBSIDIAN.defaultBlockState(), 3);
			}
		} else if (itemstack.getItem() == KraftmineModItems.LAVA_ARMOR_BOOTS.get()) {
			if ((world.getBlockState(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()))).getMaterial() == net.minecraft.world.level.material.Material.WATER) {
				world.setBlock(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()), Blocks.OBSIDIAN.defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)).enchant(Enchantments.FALL_PROTECTION, 10);
		} else {
			KraftmineMod.queueServerWork(40, () -> {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
					if (_enchantments.containsKey(Enchantments.FALL_PROTECTION)) {
						_enchantments.remove(Enchantments.FALL_PROTECTION);
						EnchantmentHelper.setEnchantments(_enchantments, itemstack);
					}
				}
			});
		}
	}
}
