
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class StunningEnchantment extends Enchantment {
	public StunningEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.SABER_SWING.get(), KraftmineModEnchantments.LIFESTEAL.get(), KraftmineModEnchantments.BANEOF_METAPOD.get(), Enchantments.KNOCKBACK, Enchantments.UNBREAKING, Enchantments.SHARPNESS,
				Enchantments.BANE_OF_ARTHROPODS, Enchantments.SMITE).contains(ench);
	}
}
