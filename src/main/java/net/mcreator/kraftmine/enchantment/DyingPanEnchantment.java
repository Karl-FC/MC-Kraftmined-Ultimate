
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class DyingPanEnchantment extends Enchantment {
	public DyingPanEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.DYING_PAN.get(), Enchantments.UNBREAKING).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.FRYING_PAN.get()).contains(item);
	}
}
