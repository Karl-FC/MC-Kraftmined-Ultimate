
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class SlicingEnchantment extends Enchantment {
	public SlicingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.SABER_SWING.get(), KraftmineModEnchantments.BLEEDING_EDGE.get(), KraftmineModEnchantments.STUNNING.get(), Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS,
				Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.MOB_LOOTING, Enchantments.SWEEPING_EDGE, Enchantments.UNBREAKING, Enchantments.MENDING).contains(ench);
	}
}
