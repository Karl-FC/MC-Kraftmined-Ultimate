
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class MagicianSecretEnchantment extends Enchantment {
	public MagicianSecretEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.TRIDENT, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.SUPERSTITIOUS.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.LIGHTNING_ROD.get(), KraftmineModItems.FIRE_SCEPTER.get(), KraftmineModItems.ICE_WAND.get(), KraftmineModItems.THE_SWITCHER.get()).contains(item);
	}
}
