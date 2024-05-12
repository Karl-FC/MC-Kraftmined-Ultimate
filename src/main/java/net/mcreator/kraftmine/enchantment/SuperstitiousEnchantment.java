
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class SuperstitiousEnchantment extends Enchantment {
	public SuperstitiousEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.TRIDENT, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.MAGICIAN_SECRET.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.ICE_WAND.get(), KraftmineModItems.FIRE_SCEPTER.get(), KraftmineModItems.LIGHTNING_ROD.get(), KraftmineModItems.THE_SWITCHER.get()).contains(item);
	}
}
