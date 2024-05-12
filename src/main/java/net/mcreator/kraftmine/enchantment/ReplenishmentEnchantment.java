
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;

import java.util.List;

public class ReplenishmentEnchantment extends Enchantment {
	public ReplenishmentEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.VANISHABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.INFINITE_POTION_REVITALIZATION.get(), KraftmineModItems.INFINITE_POTION_LEAPING.get(), KraftmineModItems.INFINITE_POTION_STRENGTH.get(), KraftmineModItems.INFINITE_POTION_RESISTANCE.get(),
				KraftmineModItems.INFINITE_POTION_FIRE_RESISTANCE.get(), KraftmineModItems.INFINITE_POTION_INVISIBILITY.get(), KraftmineModItems.INFINITE_POTION_SLOW_FALLING.get(), KraftmineModItems.INFINITE_POTION_DRIP.get(),
				KraftmineModItems.INFINITE_POTION_HYDRATION.get(), KraftmineModItems.INFINITE_POTION_SATURATION.get(), KraftmineModItems.INFINITE_POTION_SWIFTNESS.get(), KraftmineModItems.INFINITE_POTION_NIGHT_VISION.get(),
				KraftmineModItems.INFINITE_POTION_WATER_BREATHING.get()).contains(item);
	}
}
