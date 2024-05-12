
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;

import java.util.List;

public class SaberSwingEnchantment extends Enchantment {
	public SaberSwingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.SABER_RED.get(), KraftmineModItems.DIAMONDSABER.get(), KraftmineModItems.SABER_WHITE.get(), KraftmineModItems.SABER_DARK.get(), KraftmineModItems.SABER_PURPLE.get(), KraftmineModItems.SABER_GREEN.get(),
				KraftmineModItems.SABER_ORANGE.get(), KraftmineModItems.SABER_YELLOW.get()).contains(item);
	}
}
